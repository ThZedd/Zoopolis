package pt.iade.Zoopolis.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pt.iade.Zoopolis.models.Person;
import pt.iade.Zoopolis.models.LoginRequestDTO;
import pt.iade.Zoopolis.models.LoginResponseDTO;
import pt.iade.Zoopolis.models.repositories.PersonRepository;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/persons")
public class PersonController {
    private final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonRepository personRepository;

    // Chave secreta para assinar os tokens JWT
    private static final String SECRET_KEY = "YourSuperSecretKeyForJWTToken12345"; // Deve ter pelo menos 32 caracteres.

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Person> getPersons() {
        logger.info("Sending all the users");
        return personRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Person> getPerson(@PathVariable int id) {
        logger.info("Sending user with id {}", id);
        return personRepository.findById(id);
    }

    // Registro de usuário
    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person registerUser(@Valid @RequestBody Person newPerson) {
        logger.info("Registering a new user: {}", newPerson.getEmail());

        // Verificar se o e-mail já existe
        Optional<Person> existingPerson = personRepository.findByEmail(newPerson.getEmail());
        if (existingPerson.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already in use");
        }

        // Aqui você pode implementar hashing de senha
        newPerson.setPassword(newPerson.getPassword()); // Use hashing seguro em produção.

        return personRepository.save(newPerson);
    }

    // Login do usuário
    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginResponseDTO loginUser(@Valid @RequestBody LoginRequestDTO loginRequest) {
        logger.info("Authenticating user: {}", loginRequest.getEmail());

        Optional<Person> existingPerson = personRepository.findByEmail(loginRequest.getEmail());
        if (existingPerson.isPresent()) {
            if (existingPerson.get().getPassword().equals(loginRequest.getPassword())) {
                String token = generateToken(existingPerson.get());
                return new LoginResponseDTO(existingPerson.get().getId(), token);
            } else {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid password");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    // Método auxiliar para gerar o token JWT
    private String generateToken(Person person) {
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .setSubject(person.getEmail())
                .claim("id", person.getId())
                .claim("name", person.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // Token válido por 24 horas
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Endpoint para validar o token JWT
    @GetMapping(path = "/validate", produces = MediaType.APPLICATION_JSON_VALUE)
    public String validateToken(@RequestHeader("Authorization") String token) {
        try {
            // Remover "Bearer " do token, se presente
            if (token.startsWith("Bearer ")) {
                token = token.substring(7);
            }

            Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return "Token is valid";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid or expired token");
        }
    }
}

package pt.iade.Zoopolis.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.Zoopolis.models.EmailDTO;
import pt.iade.Zoopolis.models.Person;
import pt.iade.Zoopolis.models.repositories.PersonRepository;

import java.util.Optional;


@RestController
@RequestMapping(path = "/api/persons")
public class PersonController {
    private final Logger logger = LoggerFactory.getLogger(PersonController.class);
    @Autowired
    private PersonRepository personRepository;

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

    @GetMapping(path = "/{id}/email", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmailDTO getPersonEmail(@PathVariable int id) {
        logger.info("Sending email of user with id {}", id);
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            return new EmailDTO(person.get().getEmail());
        } else {
            throw new RuntimeException("Email not found from Person with id " + id);
        }
    }


}

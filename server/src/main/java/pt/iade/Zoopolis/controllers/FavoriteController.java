package pt.iade.Zoopolis.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.Zoopolis.interfaces.AnimalProjection;
import pt.iade.Zoopolis.models.AnimalDTO;
import pt.iade.Zoopolis.models.Favorite;
import pt.iade.Zoopolis.models.repositories.FavoriteRepository;

import java.util.Optional;


@RestController
@RequestMapping(path = "/api/favorite")
public class FavoriteController {
    private final Logger logger = LoggerFactory.getLogger(FavoriteController.class);
    @Autowired
    private FavoriteRepository favoriteRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Favorite> getFavorites() {
        logger.info("Sending all the users");
        return favoriteRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Favorite> getFavorite(@PathVariable int id) {
        logger.info("Sending user with id {}", id);
        return favoriteRepository.findById(id);
    }
    @GetMapping(path = "/person/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AnimalDTO> getFavoriteAnimalsByPerson(@PathVariable int personId) {
        logger.info("Fetching favorite animals for person with ID {}", personId);
        return favoriteRepository.findAnimalsByPersonId(personId);
    }

    // Verificar se um animal é favorito de uma pessoa
    @GetMapping(path = "/isFavorite", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean isFavorite(@RequestParam int personId, @RequestParam int animalId) {
        logger.info("Checking if animal with ID {} is favorite for person with ID {}", animalId, personId);
        return favoriteRepository.isFavorite(personId, animalId);
    }

    // Adicionar um animal aos favoritos de uma pessoa
    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public String addFavorite(@RequestParam int personId, @RequestParam int animalId) {
        logger.info("Adding animal with ID {} to favorites for person with ID {}", animalId, personId);

        // Verificar se já é favorito
        if (favoriteRepository.isFavorite(personId, animalId)) {
            return "Animal is already a favorite for this person.";
        }

        // Adicionar favorito
        favoriteRepository.addFavorite(personId, animalId);
        return "Animal added to favorites successfully.";
    }

    // Remover um animal dos favoritos de uma pessoa
    @DeleteMapping(path = "/remove", produces = MediaType.APPLICATION_JSON_VALUE)
    public String removeFavorite(@RequestParam int personId, @RequestParam int animalId) {
        logger.info("Removing animal with ID {} from favorites for person with ID {}", animalId, personId);

        // Verificar se o favorito existe
        if (!favoriteRepository.isFavorite(personId, animalId)) {
            return "Animal is not a favorite for this person.";
        }

        // Remover favorito
        favoriteRepository.removeFavorite(personId, animalId);
        return "Animal removed from favorites successfully.";
    }
}
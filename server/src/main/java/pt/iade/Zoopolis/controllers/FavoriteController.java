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
}
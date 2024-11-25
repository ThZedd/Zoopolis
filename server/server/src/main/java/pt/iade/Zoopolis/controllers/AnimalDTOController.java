package pt.iade.Zoopolis.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.iade.Zoopolis.models.Animal;
import pt.iade.Zoopolis.models.AnimalDTO;
import pt.iade.Zoopolis.models.repositories.AnimalRepository;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/animalsDTO")
public class AnimalDTOController {
    private final Logger logger = LoggerFactory.getLogger(AnimalDTOController.class);
    @Autowired
    private AnimalRepository animalRepository;

    // Endpoint que retorna todos os animais como AnimalDTO
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AnimalDTO> getAllAnimals() {
        logger.info("Sending all Animals as DTO");

        List<AnimalDTO> animalDTOs = ((List<Animal>) animalRepository.findAll()).stream()
                .map(animal -> new AnimalDTO(
                        animal.getId(),
                        animal.getName(),
                        animal.getCiName(),
                        animal.getDescription()
                ))
                .collect(Collectors.toList());

        return animalDTOs;
    }

    // Endpoint que retorna um único animal como AnimalDTO
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AnimalDTO getAnimal(@PathVariable int id) {
        logger.info("Sending animal with id {} as DTO", id);

        return animalRepository.findById(id)
                .map(animal -> new AnimalDTO(
                        animal.getId(),
                        animal.getName(),
                        animal.getCiName(),
                        animal.getDescription()
                ))
                .orElseThrow(() -> new RuntimeException("Animal not found"));
    }
}






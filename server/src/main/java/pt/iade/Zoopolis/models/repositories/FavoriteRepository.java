package pt.iade.Zoopolis.models.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.iade.Zoopolis.interfaces.AnimalProjection;
import pt.iade.Zoopolis.models.AnimalDTO;
import pt.iade.Zoopolis.models.Favorite;


@Repository
public interface FavoriteRepository extends CrudRepository<Favorite, Integer> {

    @Query("""
            SELECT new pt.iade.Zoopolis.models.AnimalDTO(
                a.id, a.name, a.ciName, a.description, a.imageUrl
            )
            FROM Animal a
            JOIN Favorite f ON a.id = f.animal.id
            JOIN Person p ON p.id = f.person.id
            WHERE p.id = :personId
            """)
    Iterable<AnimalDTO> findAnimalsByPersonId(int personId);
}


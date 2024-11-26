package pt.iade.Zoopolis.models.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.iade.Zoopolis.models.Person;



@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {


}

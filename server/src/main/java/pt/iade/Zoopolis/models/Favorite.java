package pt.iade.Zoopolis.models;

import jakarta.persistence.*;

@Entity
@Table(name = "favorite")
public class Favorite{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fav_id")
    private int id;

    @ManyToOne
    @JoinColumn(
            name = "fav_ani_id",
            referencedColumnName = "ani_id",
            nullable = true
    )
    private Animal animal;

    @ManyToOne
    @JoinColumn(
            name = "fav_per_id",
            referencedColumnName = "per_id",
            nullable = true
    )
    private Person person;

    public Favorite() {}

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return animal;
    }
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}

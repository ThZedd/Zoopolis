package pt.iade.Zoopolis.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "favorite")
public class Favorite{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fav_id")
    private int id;

    @Column(name = "fav_animal")
    private boolean favorite;

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
}

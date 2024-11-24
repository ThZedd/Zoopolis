package pt.iade.Zoopolis.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "visited")
public class Visited{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vi_id")
    private int id;

    @Column(name = "vi_dtime")
    private LocalDateTime dtime;


    @ManyToOne
    @JoinColumn(
            name = "vi_per_id",
            referencedColumnName = "per_id",
            nullable = true
    )
    private Person person;

    @ManyToOne
    @JoinColumn(
            name = "vi_sa_id",
            referencedColumnName = "sa_id",
            nullable = true
    )
    private Sub_Area sub_area;
}

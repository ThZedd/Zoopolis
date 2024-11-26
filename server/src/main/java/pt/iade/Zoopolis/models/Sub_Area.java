package pt.iade.Zoopolis.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "sub_area")
public class Sub_Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sa_id")
    private int id;

    @Column(name = "sa_name")
    private String name;


    @ManyToOne
    @JoinColumn(
                name = "sa_area_id",
                referencedColumnName = "area_id",
                nullable = true
        )
       private Area area;
}

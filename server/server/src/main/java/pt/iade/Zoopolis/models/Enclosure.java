package pt.iade.Zoopolis.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "enclosure")
public class Enclosure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enc_id")
    private int id;

    @Column(name = "enc_name")
    private String name;

    @Column(name = "enc_aniclass")
    private String animalclass;

    @Column(name = "enc_mapsid")
    private String mapsid;

    @Column(name = "enc_sup_amount")
    private int sup_amount;

    @Column(name = "enc_lat")
    private double latitude;

    @Column(name = "enc_long")
    private double longitude;

    @ManyToOne
        @JoinColumn(
                name = "enc_sa_id",
               referencedColumnName = "sa_id",
               nullable = true
       )
       private Sub_Area sub_area;
}

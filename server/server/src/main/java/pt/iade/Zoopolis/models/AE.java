package pt.iade.Zoopolis.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "ae")
public class AE{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ae_id")
    private int id;

    @Column(name = "ae_dt_in")
    private LocalDateTime datein;

    @Column(name = "ae_dt_out")
    private LocalDateTime dateout;

    @ManyToOne
    @JoinColumn(
            name = "ae_ani_id",
            referencedColumnName = "ani_id",
            nullable = true
    )
    private Animal animal;

    @ManyToOne
    @JoinColumn(
            name = "ae_enc_id",
            referencedColumnName = "enc_id",
            nullable = true
    )
    private Enclosure enclosure;
}

package azamat.model.entity.jashtarIshteri;

import azamat.model.FileInformation.Gallery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "sportsEvents")
public class SportsEvents {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "sports_seq")
    @SequenceGenerator(name = "sports_seq",
            sequenceName = "SEQ_SPORTS", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column(length = 10000000)
    private String infoSportEvents;

    @OneToOne
    private Gallery gallery;
}

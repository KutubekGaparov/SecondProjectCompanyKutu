package azamat.db.model.entity.jashtarIshteri;

import azamat.FileInformation.FileInformation;
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
    private String sportEventsName;
    private String address;
    private String time;
    @Column(length = 10000000)
    private String info;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileInformation fileInformation;

}

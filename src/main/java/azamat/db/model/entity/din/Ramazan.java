package azamat.db.model.entity.din;

import azamat.FileInformation.FileInformation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ramazan")
@RequiredArgsConstructor
@Getter
@Setter
public class Ramazan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "ramazan_seq")
    @SequenceGenerator(name = "ramazan_seq",
            sequenceName = "SEQ_RAMAZAN", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column(length = 10000000)
    private String text;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileInformation fileInformation;

}

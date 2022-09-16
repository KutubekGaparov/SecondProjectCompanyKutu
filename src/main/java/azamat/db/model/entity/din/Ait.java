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

public class Ait {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "ait_seq")
    @SequenceGenerator(name = "ait_seq",
            sequenceName = "SEQ_AIT", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(length = 1000000)
    private String text;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileInformation fileInformation;


}

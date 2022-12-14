package azamat.db.model.entity.Kultura;

import azamat.FileInformation.FileInformation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "contests")
public class Contests {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "contests_seq")
    @SequenceGenerator(name = "contests_seq",
            sequenceName = "SEQ_CONTESTS", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(length = 1000000)
    private String text;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileInformation fileInformation;

}

package azamat.model.entity.Kultura;

import azamat.model.FileInformation.Gallery;
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

    @OneToOne
    private Gallery gallery;
}

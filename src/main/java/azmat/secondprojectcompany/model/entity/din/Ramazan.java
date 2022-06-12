package azmat.secondprojectcompany.model.entity.din;

import azmat.secondprojectcompany.model.FileInformation.Gallery;
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

    private String text;

    @OneToOne(cascade = CascadeType.ALL)
    private Gallery gallery;
}

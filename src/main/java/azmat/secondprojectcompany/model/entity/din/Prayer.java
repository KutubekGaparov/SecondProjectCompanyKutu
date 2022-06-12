package azmat.secondprojectcompany.model.entity.din;

import azmat.secondprojectcompany.model.FileInformation.Gallery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "prayer")
@RequiredArgsConstructor
@Getter
@Setter
public class Prayer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "prayer_seq")
    @SequenceGenerator(name = "prayer_seq",
            sequenceName = "SEQ_PRAYER", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column(length = 10000000)
    private String text;

    @OneToOne
    private Gallery gallery;

}

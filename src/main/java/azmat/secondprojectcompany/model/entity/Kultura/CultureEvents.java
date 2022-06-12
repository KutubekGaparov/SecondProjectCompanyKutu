package azmat.secondprojectcompany.model.entity.Kultura;

import azmat.secondprojectcompany.model.FileInformation.Gallery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "cultureEvents")
public class CultureEvents {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "culture_seq")
    @SequenceGenerator(name = "culture_seq",
            sequenceName = "SEQ_CULTURE", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column(length = 10000000)
    private String text;

    @OneToOne
    private Gallery gallery;
}

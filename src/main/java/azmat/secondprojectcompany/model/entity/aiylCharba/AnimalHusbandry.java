package azmat.secondprojectcompany.model.entity.aiylCharba;

import azmat.secondprojectcompany.model.FileInformation.Gallery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "animalHusbandry")
public class AnimalHusbandry {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "use_seq")
    @SequenceGenerator(name = "use_seq",
            sequenceName = "SEQ_USE", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String text;

    @OneToOne
    private Gallery gallery;
}

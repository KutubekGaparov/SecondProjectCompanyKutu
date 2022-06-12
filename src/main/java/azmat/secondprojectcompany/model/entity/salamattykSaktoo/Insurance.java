package azmat.secondprojectcompany.model.entity.salamattykSaktoo;

import azmat.secondprojectcompany.model.FileInformation.Gallery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "insurance")

public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "insurance_seq")
    @SequenceGenerator(name = "insurance_seq",
            sequenceName = "SEQ_INSURANCE", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String text;

    @OneToOne
    private Gallery gallery;
}

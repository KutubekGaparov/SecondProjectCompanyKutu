package azmat.secondprojectcompany.model.entity.Kultura;

import azmat.secondprojectcompany.model.FileInformation.Gallery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "culturalFigures")
public class CulturalFigures {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "culturalF_seq")
    @SequenceGenerator(name = "culturalF_seq",
            sequenceName = "SEQ_CULTURAL", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String fullName;
    @Column(length = 10000000)
    private String text;

    @OneToOne
    private Gallery gallery;
}

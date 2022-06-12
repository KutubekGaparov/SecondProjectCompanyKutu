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
@Table(name = "museums")
public class Museums {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "museums_seq")
    @SequenceGenerator(name = "museums_seq",
            sequenceName = "SEQ_MUSEUMS", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String text;

    @OneToOne
    private Gallery gallery;
}

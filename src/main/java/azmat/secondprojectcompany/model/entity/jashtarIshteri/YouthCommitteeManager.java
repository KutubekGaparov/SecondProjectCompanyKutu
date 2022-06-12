package azmat.secondprojectcompany.model.entity.jashtarIshteri;

import azmat.secondprojectcompany.model.FileInformation.Gallery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "youthCommitteeManager")
public class YouthCommitteeManager {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "youth_seq")
    @SequenceGenerator(name = "youth_seq",
            sequenceName = "SEQ_YOUTH", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String infoManager;

    @OneToOne
    private Gallery gallery;
}

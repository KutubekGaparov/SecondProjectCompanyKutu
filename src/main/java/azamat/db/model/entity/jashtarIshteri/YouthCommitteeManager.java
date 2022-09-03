package azamat.db.model.entity.jashtarIshteri;

import azamat.FileInformation.Gallery;
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
    @Column(length = 10000000)
    private String infoManager;

    @OneToOne
    private Gallery gallery;
}

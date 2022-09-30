package azamat.db.model.entity.jashtarIshteri;

import azamat.FileInformation.FileInformation;
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
    private String managerName;
    private String managerDirectorName;
    private String phone;
    private String address;
    private String info;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileInformation fileInformation;

}

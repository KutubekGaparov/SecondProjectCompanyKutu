package azamat.db.model.entity.salamattykSaktoo;

import azamat.FileInformation.FileInformation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "medicalCenter")

public class MedicalCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "medical_seq")
    @SequenceGenerator(name = "medical_seq",
            sequenceName = "SEQ_MEDICAL", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(unique = true)
    private String hospitalName;
    @Column(unique = true)
    private String directorHospital;
    private String  address;
    private String phoneNumber;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileInformation fileInformation;

}

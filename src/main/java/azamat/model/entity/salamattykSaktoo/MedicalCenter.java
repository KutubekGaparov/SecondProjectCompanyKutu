package azamat.model.entity.salamattykSaktoo;

import azamat.model.FileInformation.Gallery;
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

    @OneToOne
    private Gallery gallery;
}

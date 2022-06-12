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
@Table(name = "hospitals")

public class Hospitals {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "hospitals_seq")
    @SequenceGenerator(name = "hospitals_seq",
            sequenceName = "SEQ_HOSPITALS", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String hospitalName;
    private String directorHospital;
    private String  address;
    private String phoneNumber;
    private String email;

    @OneToOne
    private Gallery gallery;

}

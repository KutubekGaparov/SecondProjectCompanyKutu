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
@Table(name = "hospitals")

public class Hospitals {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "hospitals_seq")
    @SequenceGenerator(name = "hospitals_seq",
            sequenceName = "SEQ_HOSPITALS", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(unique = true)
    private String hospitalName;
    @Column(unique = true)
    private String directorHospital;
    private String  address;
    private String phoneNumber;
    private String email;
    private String info;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileInformation fileInformation;

}

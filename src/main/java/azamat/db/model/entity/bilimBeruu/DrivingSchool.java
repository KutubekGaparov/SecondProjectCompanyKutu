package azamat.db.model.entity.bilimBeruu;

import azamat.FileInformation.FileInformation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "drivingSchool")
public class DrivingSchool {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "driving_seq")
    @SequenceGenerator(name = "driving_seq",
            sequenceName = "DRIVING_USE", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String director;
    private String phoneNumber;
    private String drivingCourseName;

    private String address;

    @Column(length = 100000000)
    private String text;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileInformation fileInformation;
}


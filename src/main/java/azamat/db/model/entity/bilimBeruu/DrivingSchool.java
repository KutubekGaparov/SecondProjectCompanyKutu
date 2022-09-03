package azamat.db.model.entity.bilimBeruu;

import azamat.FileInformation.Gallery;
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

    @OneToOne(cascade = CascadeType.ALL)
    private Gallery gallery;

}

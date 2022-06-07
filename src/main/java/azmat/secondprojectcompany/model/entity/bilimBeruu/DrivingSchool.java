package azmat.secondprojectcompany.model.entity.bilimBeruu;

import azmat.secondprojectcompany.model.FileInformation.Gallery;
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
            generator ="hibernate_gen" )
    @SequenceGenerator(name = "hibernate_gen",sequenceName = "hibernate_seq",allocationSize = 1)
    @Column(name = "id",nullable = false)
    private Long id;

    private String director;
    private String phoneNumber;
    private String drivingCourseName;

    @OneToOne(cascade = CascadeType.ALL)
    private Gallery gallery;

}

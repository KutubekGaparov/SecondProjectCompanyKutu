package azmat.secondprojectcompany.model.entity.bilimMinistirligi;

import azmat.secondprojectcompany.model.entity.BilimBeruu;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.CascadeType.MERGE;

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

    @ManyToOne
    private BilimBeruu bilimBeruu;


}

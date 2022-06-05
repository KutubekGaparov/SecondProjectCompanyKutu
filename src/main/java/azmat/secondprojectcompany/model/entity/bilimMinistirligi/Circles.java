package azmat.secondprojectcompany.model.entity.bilimMinistirligi;

import azmat.secondprojectcompany.model.entity.BilimBeruu;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.CascadeType.REFRESH;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "circles")

public class Circles {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator ="hibernate_gen" )
    @SequenceGenerator(name = "hibernate_gen",sequenceName = "hibernate_seq",allocationSize = 1)
    @Column(name = "id",nullable = false)
    private Long id;

    private String courseName;
    private String courseTeacher;
    private String info;
    private String phoneNumber;

    @ManyToOne
    private BilimBeruu bilimBeruu;

}

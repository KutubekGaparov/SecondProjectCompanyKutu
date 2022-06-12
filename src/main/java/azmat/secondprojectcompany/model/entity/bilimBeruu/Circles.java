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
@Table(name = "circles")

public class Circles {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "circles_seq")
    @SequenceGenerator(name = "circles_seq",
            sequenceName = "SEQ_CIRCLES", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String courseName;
    private String courseTeacher;
    private String info;
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    private Gallery gallery;

}

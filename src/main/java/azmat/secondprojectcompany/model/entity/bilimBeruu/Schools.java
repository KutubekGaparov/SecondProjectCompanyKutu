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
@Table(name = "schools")

public class Schools {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "school_seq")
    @SequenceGenerator(name = "school_seq",
            sequenceName = "SEQ_SCHOOL", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String schoolName;
    private String directorFullName;
    private String address;
    private String phoneNumber;

    private String text;

    @OneToOne(cascade = CascadeType.ALL)
    private Gallery gallery;

}

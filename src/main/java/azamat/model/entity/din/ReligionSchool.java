package azamat.model.entity.din;

import azamat.model.FileInformation.Gallery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "religion_school")
@RequiredArgsConstructor
@Getter @Setter
public class ReligionSchool {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "religion_seq")
    @SequenceGenerator(name = "religion_seq",
            sequenceName = "SEQ_RELIGION", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String schoolName;
    private String director;
    private LocalDate directorBirthDay;
    private String address;
    private String phone;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Gallery gallery;
}

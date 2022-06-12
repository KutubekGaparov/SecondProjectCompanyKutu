package azmat.secondprojectcompany.model;

import azmat.secondprojectcompany.model.FileInformation.Gallery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tazalyk")
@RequiredArgsConstructor
@Getter
@Setter
public class Tazalyk {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "taz_seq")
    @SequenceGenerator(name = "taz_seq",
            sequenceName = "SEQ_TAZ", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String fullName;
    private LocalDate birthday;
    private String email;
    private String phoneNumber;

    @OneToOne
    private Gallery gallery;
}

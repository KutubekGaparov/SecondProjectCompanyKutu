package azmat.secondprojectcompany.model.entity.din;

import azmat.secondprojectcompany.model.FileInformation.Gallery;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_gen")
    @SequenceGenerator(name = "hibernate_gen", sequenceName = "hibernate_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String schoolName;
    private String director;
    private LocalDate directorBirthDay;
    private String address;
    private int phone;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Gallery gallery;
}

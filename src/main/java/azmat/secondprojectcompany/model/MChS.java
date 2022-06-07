package azmat.secondprojectcompany.model;

import azmat.secondprojectcompany.model.FileInformation.Gallery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "mchs")
@RequiredArgsConstructor
@Getter
@Setter
public class MChS {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_gen")
    @SequenceGenerator(name = "hibernate_gen", sequenceName = "hibernate_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String fullName;
    private LocalDate birthday;
    private String email;
    private String phoneNumber;

    @OneToOne
    private Gallery gallery;
}

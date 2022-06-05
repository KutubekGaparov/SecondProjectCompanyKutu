package azmat.secondprojectcompany.model.entity.din;

import azmat.secondprojectcompany.model.FileInformation.Gallery;
import azmat.secondprojectcompany.model.entity.DinIshteri;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "mechitter")
@RequiredArgsConstructor
@Getter
@Setter
public class Mechitter {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_gen")
    @SequenceGenerator(name = "hibernate_gen", sequenceName = "hibernate_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String mosqueName;
    private String imamName;
    private String imamLastName;
    private LocalDate birthDay;
    private String positions;
    private String address;
    private int phone;
    private String email;

    @ManyToOne
    private DinIshteri dinIshteri;

    @OneToMany
    private List<Gallery> gallery;
}

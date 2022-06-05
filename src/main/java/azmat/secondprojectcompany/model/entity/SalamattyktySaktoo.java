package azmat.secondprojectcompany.model.entity;

import azmat.secondprojectcompany.model.entity.salamattykSaktoo.DoctorsAdvice;
import azmat.secondprojectcompany.model.entity.salamattykSaktoo.Hospitals;
import azmat.secondprojectcompany.model.entity.salamattykSaktoo.Insurance;
import azmat.secondprojectcompany.model.entity.salamattykSaktoo.MedicalCenter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "salamattyk")
@RequiredArgsConstructor
@Getter
@Setter

public class SalamattyktySaktoo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_gen")
    @SequenceGenerator(name = "hibernate_gen", sequenceName = "hibernate_seg", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "salamattyktySaktoo")
    private List<DoctorsAdvice> doctorsAdvice;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "salamattyktySaktoo")
    private List<Hospitals> hospitals;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "salamattyktySaktoo")
    private Insurance insurance;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "salamattyktySaktoo")
    private List<MedicalCenter> medicalCenter;

}

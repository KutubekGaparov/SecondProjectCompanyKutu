package azmat.secondprojectcompany.model.entity;

import azmat.secondprojectcompany.model.entity.bilimMinistirligi.Circles;
import azmat.secondprojectcompany.model.entity.bilimMinistirligi.DrivingSchool;
import azmat.secondprojectcompany.model.entity.bilimMinistirligi.Kindergartens;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bilim")
@RequiredArgsConstructor
@Getter
@Setter
public class BilimBeruu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_gen")
    @SequenceGenerator(name = "hibernate_gen", sequenceName = "hibernate_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "bilimBeruu",cascade = CascadeType.ALL)
    private List<Circles> circles;

    @OneToMany(mappedBy = "bilimBeruu",cascade = CascadeType.ALL)
    private List<DrivingSchool> drivingSchool;

    @OneToMany(mappedBy = "bulimBeruu",cascade = CascadeType.ALL)
    private List<Kindergartens> kindergartens;



}

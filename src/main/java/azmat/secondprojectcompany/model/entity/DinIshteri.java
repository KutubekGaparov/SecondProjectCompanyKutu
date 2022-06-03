package azmat.secondprojectcompany.model.entity;

import azmat.secondprojectcompany.model.entity.din.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "din")
@Getter
@Setter
@RequiredArgsConstructor
public class DinIshteri {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_gen")
    @SequenceGenerator(name = "hibernate_gen", sequenceName = "hibernate_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "dinIshteri")
    private Ait ait;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dinIshteri")
    private List<DEvents> dEvents;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "dinIshteri")
    private Ethics ethics;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dinIshteri")
    private List<Hadj> hadj;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dinIshteri")
    private List<Mechitter> mechitter;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dinIshteri")
    private List<Prayer> prayer;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "dinIshteri")
    private Ramazan ramazan;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dinIshteri")
    private List<ReligionSchool> religionSchools;

}

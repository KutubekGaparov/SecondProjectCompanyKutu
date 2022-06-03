package azmat.secondprojectcompany.model.entity;

import azmat.secondprojectcompany.model.entity.Kultura.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "madaniat")
@RequiredArgsConstructor
@Getter
@Setter
public class Madaniat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_gen")
    @SequenceGenerator(name = "hibernate_gen", sequenceName = "hibernate_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "madaniat")
    private Contests contests;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "madaniat")
    private List<CulturalFigures> culturalFigures;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "madaniat")
    private CultureEvents cultureEvents;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "madaniat")
    private HousesOfCulture housesOfCulture;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "madaniat")
    private Museums museums;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "madaniat")
    private Sentence sentence;

}

package azmat.secondprojectcompany.model.entity;

import azmat.secondprojectcompany.model.entity.jashtarIshteri.EnterprisingYouth;
import azmat.secondprojectcompany.model.entity.jashtarIshteri.OfferForYouth;
import azmat.secondprojectcompany.model.entity.jashtarIshteri.YouthCommitteeManager;
import azmat.secondprojectcompany.model.entity.jashtarIshteri.YouthInitiatives;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "jashtar")
@RequiredArgsConstructor
@Getter
@Setter
public class JashtarIshteri {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_gen")
    @SequenceGenerator(name = "hibernate_gen", sequenceName = "hibernate_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "jashtarIshteri")
    private List<EnterprisingYouth> enterprisingYouth;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "jashtarIshteri")
    private List<OfferForYouth> offerForYouths;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "jashtarIshteri")
    private YouthCommitteeManager youthCommitteeManager;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "jashtarIshteri")
    private List<YouthInitiatives> youthInitiatives;

}

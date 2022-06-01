package azmat.secondprojectcompany.model.entity;

import azmat.secondprojectcompany.model.FileInformation.Gallery;
import azmat.secondprojectcompany.model.NewsAnnouncement;
import azmat.secondprojectcompany.model.entity.aiylCharba.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "charba")
@RequiredArgsConstructor
public class AiylCharba {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_gen")
    @SequenceGenerator(name = "hibernate_gen", sequenceName = "hibernate_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ACEvent> acEvent;

    @OneToOne(cascade = CascadeType.ALL)
    private AnimalHusbandry animalHusbandry;

    @OneToOne(cascade = CascadeType.ALL)
    private GrainGrowing grainGrowing;

    @OneToOne(cascade = CascadeType.ALL)
    private Laws laws;

    @OneToOne(cascade = CascadeType.ALL)
    private Pasture pasture;

    @OneToMany
    private List<Tips> tips;

    @OneToMany(cascade = CascadeType.ALL)
    private List<NewsAnnouncement> newsAnnouncement;

    @OneToMany
    private List<Gallery> gallery;
}
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

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "aiylCharba")
    private List<ACEvent> acEvent;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "aiylCharba")
    private AnimalHusbandry animalHusbandry;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "aiylCharba")
    private GrainGrowing grainGrowing;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "aiylCharba")
    private Laws laws;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "aiylCharba")
    private Pasture pasture;

    @OneToMany(mappedBy = "aiylCharba")
    private List<Tips> tips;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "aiylCharba")
    private List<NewsAnnouncement> newsAnnouncement;

    @OneToMany()
    private List<Gallery> gallery;
}
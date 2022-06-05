package azmat.secondprojectcompany.model.entity.din;

import azmat.secondprojectcompany.model.FileInformation.Gallery;
import azmat.secondprojectcompany.model.entity.DinIshteri;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "d_events")
@RequiredArgsConstructor
@Getter
@Setter
public class DEvents {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_gen")
    @SequenceGenerator(name = "hibernate_gen", sequenceName = "hibernate_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String info;

    @ManyToOne
    private DinIshteri dinIshteri;

    @OneToMany
    private List<Gallery> gallery;
}

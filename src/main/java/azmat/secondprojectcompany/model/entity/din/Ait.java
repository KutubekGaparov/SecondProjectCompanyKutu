package azmat.secondprojectcompany.model.entity.din;

import azmat.secondprojectcompany.model.entity.DinIshteri;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ramazan")
@RequiredArgsConstructor
@Getter
@Setter

public class Ait {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_gen")
    @SequenceGenerator(name = "hibernate_gen", sequenceName = "hibernate_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 1000000)
    private String text;


    @OneToOne
    private DinIshteri dinIshteri;

}

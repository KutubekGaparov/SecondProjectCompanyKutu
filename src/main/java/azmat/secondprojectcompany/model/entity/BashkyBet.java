package azmat.secondprojectcompany.model.entity;

import azmat.secondprojectcompany.model.Kyzmatkerler;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bashky")
@RequiredArgsConstructor
@Getter
@Setter

public class BashkyBet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_gen")
    @SequenceGenerator(name = "hibernate_gen", sequenceName = "hibernate_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany
    private List<Kyzmatkerler> kyzmatkerler;

}

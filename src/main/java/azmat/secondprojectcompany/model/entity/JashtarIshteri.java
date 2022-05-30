package azmat.secondprojectcompany.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

}

package azmat.secondprojectcompany.model.entity.jashtarIshteri;

import azmat.secondprojectcompany.model.entity.JashtarIshteri;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "youthInitiatives")
public class YouthInitiatives {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator ="hibernate_gen" )
    @SequenceGenerator(name = "hibernate_gen",sequenceName = "hibernate_seq",allocationSize = 1)
    @Column(name = "id",nullable = false)
    private Long id;

    private String initiatives;

    @ManyToOne
    private JashtarIshteri jashtarIshteri;

}

package azmat.secondprojectcompany.model.entity.aiylCharba;

import azmat.secondprojectcompany.model.entity.AiylCharba;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "grainGrowing")
public class GrainGrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator ="hibernate_gen" )
    @SequenceGenerator(name = "hibernate_gen",sequenceName = "hibernate_seq",allocationSize = 1)
    @Column(name = "id",nullable = false)
    private Long id;

    private String text;

    private String directorFullName;

    @OneToOne
    private AiylCharba aiylCharba;

}

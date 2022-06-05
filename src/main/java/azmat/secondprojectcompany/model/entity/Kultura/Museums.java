package azmat.secondprojectcompany.model.entity.Kultura;

import azmat.secondprojectcompany.model.FileInformation.Gallery;
import azmat.secondprojectcompany.model.entity.Madaniat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "museums")
public class Museums {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator ="hibernate_gen" )
    @SequenceGenerator(name = "hibernate_gen",sequenceName = "hibernate_seq",allocationSize = 1)
    @Column(name = "id",nullable = false)
    private Long id;

    private String text;

    @ManyToOne
    private Madaniat madaniat;

    @OneToOne
    private Gallery gallery;
}

package azmat.secondprojectcompany.model.entity.jashtarIshteri;

import azmat.secondprojectcompany.model.FileInformation.Gallery;
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
            generator = "you_seq")
    @SequenceGenerator(name = "you_seq",
            sequenceName = "SEQ_YOU", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column(length = 10000000)
    private String initiatives;

    @OneToOne
    private Gallery gallery;
}

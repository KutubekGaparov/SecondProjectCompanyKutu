package azmat.secondprojectcompany.model.entity.din;

import azmat.secondprojectcompany.model.FileInformation.Gallery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ramazan")
@RequiredArgsConstructor
@Getter
@Setter

public class Ait {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "ait_seq")
    @SequenceGenerator(name = "ait_seq",
            sequenceName = "SEQ_AIT", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(length = 1000000)
    private String text;

    @OneToOne
    private Gallery gallery;

}

package azmat.secondprojectcompany.model.entity.din;

import azmat.secondprojectcompany.model.FileInformation.Gallery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hadj")
@RequiredArgsConstructor
@Getter
@Setter
public class Hadj {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "hadj_seq")
    @SequenceGenerator(name = "hadj_seq",
            sequenceName = "SEQ_HADJ", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;


    private String fullName;
    @Column(length = 10000000)
    private String text;

    @OneToOne
    private Gallery gallery;
}

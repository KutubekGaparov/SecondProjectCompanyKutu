package azmat.secondprojectcompany.model.entity.bilimBeruu;

import azmat.secondprojectcompany.model.FileInformation.Gallery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "ort")

public class ORT {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "ort_seq")
    @SequenceGenerator(name = "ort_seq",
            sequenceName = "SEQ_ORT", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column(length = 10000000)
    private String text;

    @OneToOne(cascade = CascadeType.ALL)
    private Gallery gallery;


}

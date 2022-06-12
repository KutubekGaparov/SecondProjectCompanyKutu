package azmat.secondprojectcompany.model;

import azmat.secondprojectcompany.model.FileInformation.Gallery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ataktuular")
@RequiredArgsConstructor
@Getter
@Setter
public class Ataktuular {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "at_seq")
    @SequenceGenerator(name = "at_seq",
            sequenceName = "SEQ_AT", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String info;

    @OneToOne
    private Gallery gallery;
}

package azmat.secondprojectcompany.model.entity.aiylCharba;

import azmat.secondprojectcompany.model.FileInformation.Gallery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "pasture")
public class Pasture {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "pasture_seq")
    @SequenceGenerator(name = "pasture_seq",
            sequenceName = "SEQ_PASTURE", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String text;

    private String directorFullName;

    @OneToOne
    private Gallery gallery;
}

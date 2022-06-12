package azmat.secondprojectcompany.model.entity.Kultura;

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
@Table(name = "housesOfCulture")
public class HousesOfCulture {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "houses_seq")
    @SequenceGenerator(name = "houses_seq",
            sequenceName = "SEQ_HOUSES", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String text;

    @OneToOne
    private Gallery gallery;

}

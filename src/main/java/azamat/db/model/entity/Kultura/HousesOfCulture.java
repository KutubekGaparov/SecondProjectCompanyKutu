package azamat.db.model.entity.Kultura;

import azamat.FileInformation.Gallery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    @Column(length = 10000000)
    private String text;

    @OneToOne
    private Gallery gallery;

}

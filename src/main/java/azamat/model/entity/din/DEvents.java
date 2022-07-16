package azamat.model.entity.din;

import azamat.model.FileInformation.Gallery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "d_events")
@RequiredArgsConstructor
@Getter
@Setter
public class DEvents {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "use_dEvent")
    @SequenceGenerator(name = "use_dEvent",
            sequenceName = "SEQ_DEVENT", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column(length = 10000000)
    private String info;

    @OneToOne
    private Gallery gallery;
}

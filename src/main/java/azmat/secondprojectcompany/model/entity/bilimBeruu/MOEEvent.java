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
@Table(name = "event")

public class MOEEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "events_seq")
    @SequenceGenerator(name = "events_seq",
            sequenceName = "SEQ_EVENTS", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String text;

    @OneToOne(cascade = CascadeType.ALL)
    private Gallery gallery;

}

package azmat.secondprojectcompany.model.entity.aiylCharba;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter @Setter
@RequiredArgsConstructor
@Table(name = "acEvent")
public class ACEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "asEvent_seq")
    @SequenceGenerator(name = "asEvent_seq",
            sequenceName = "SEQ_ASEVENT", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column(length = 10000000)
    private String text;

}

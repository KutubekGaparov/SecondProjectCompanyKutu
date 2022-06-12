package azmat.secondprojectcompany.model.entity.aiylCharba;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "laws")
public class Laws {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "laws_seq")
    @SequenceGenerator(name = "laws_seq",
            sequenceName = "SEQ_LAWS", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String text;

}

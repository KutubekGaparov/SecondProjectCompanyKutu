package azamat.db.model.entity.Kultura;

import azamat.FileInformation.FileInformation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "museums")
public class Museums {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "museums_seq")
    @SequenceGenerator(name = "museums_seq",
            sequenceName = "SEQ_MUSEUMS", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column(length = 10000000)
    private String text;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileInformation fileInformation;

}

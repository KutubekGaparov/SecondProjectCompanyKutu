package azamat.db.model.entity.din;

import azamat.FileInformation.FileInformation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ethics")
@RequiredArgsConstructor
@Getter
@Setter
public class Ethics {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "ethics_seq")
    @SequenceGenerator(name = "ethics_seq",
            sequenceName = "SEQ_ETHICS", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column(length = 10000000)
    private String text;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileInformation fileInformation;

}

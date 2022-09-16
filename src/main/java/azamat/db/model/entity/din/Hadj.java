package azamat.db.model.entity.din;

import azamat.FileInformation.FileInformation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "hadj")
@RequiredArgsConstructor
@Getter
@Setter
public class Hadj {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "hadj_seq")
    @SequenceGenerator(name = "hadj_seq",
            sequenceName = "SEQ_HADJ", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;


    private String fullName;
    @Column(length = 10000000)
    private String text;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileInformation fileInformation;

}

package azamat.db.model.entity.salamattykSaktoo;

import azamat.FileInformation.FileInformation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "insurance")

public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "insurance_seq")
    @SequenceGenerator(name = "insurance_seq",
            sequenceName = "SEQ_INSURANCE", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column(length = 10000000)
    private String info;
    private String title;
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileInformation fileInformation;

}

package azamat.db.model.entity.jashtarIshteri;

import azamat.FileInformation.FileInformation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "offerForYouth")
public class OfferForYouth {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "off_seq")
    @SequenceGenerator(name = "off_seq",
            sequenceName = "SEQ_OFF", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column(length = 10000000)
    private String offer;

    private String title;
    private String info;
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileInformation fileInformation;

}

package azamat.db.model.entity.jashtarIshteri;

import azamat.FileInformation.FileInformation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "enterprisingYouth")
public class EnterprisingYouth {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "enter_seq")
    @SequenceGenerator(name = "enter_seq",
            sequenceName = "SEQ_ENTER", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String fullName;
    private String age;
    private String direction;
    private String result;
    private String info;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileInformation fileInformation;

}

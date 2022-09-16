package azamat.db.model;

import azamat.FileInformation.FileInformation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "mchs")
@RequiredArgsConstructor
@Getter
@Setter
public class MChS {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "mch_seq")
    @SequenceGenerator(name = "mch_seq",
            sequenceName = "SEQ_MCH", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String fullName;
    private LocalDate birthDay;
    private String email;
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileInformation fileInformation;

}

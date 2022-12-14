package azamat.db.model;

import azamat.FileInformation.FileInformation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tazalyk")
@RequiredArgsConstructor
@Getter
@Setter
public class Tazalyk {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "taz_seq")
    @SequenceGenerator(name = "taz_seq",
            sequenceName = "SEQ_TAZ", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String fullName;
    private LocalDate birthday;
    private String email;
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileInformation fileInformation;

}

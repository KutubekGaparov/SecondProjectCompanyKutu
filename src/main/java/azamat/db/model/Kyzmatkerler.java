package azamat.db.model;

import azamat.FileInformation.FileInformation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "kyzmatkerler")
@RequiredArgsConstructor
@Getter @Setter
public class Kyzmatkerler {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "kyz_seq")
    @SequenceGenerator(name = "kyz_seq",
            sequenceName = "SEQ_KYZ", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String firstName;
    private String lastName;
    private String patronymic;

    private LocalDate birthDay;
    private String positions;
    private String email;
    private String phoneNumber;

    private String type;
    @Column(length = 10000000)
    private String text;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileInformation fileInformation;

}

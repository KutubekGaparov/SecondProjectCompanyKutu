package azmat.secondprojectcompany.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "kyzmatkerler")
@RequiredArgsConstructor
@Getter
@Setter
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

}

package azmat.secondprojectcompany.model.bashkyBet;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_gen")
    @SequenceGenerator(name = "hibernate_gen", sequenceName = "hibernate_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;
    private String lastName;
    private String patronymic;
    private LocalDate birthDay;
    private String positions;
    private String email;
    private int phone;
}

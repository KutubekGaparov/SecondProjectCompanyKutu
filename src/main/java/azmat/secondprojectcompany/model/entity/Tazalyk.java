package azmat.secondprojectcompany.model.entity;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_gen")
    @SequenceGenerator(name = "hibernate_gen", sequenceName = "hibernate_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String fullName;
    private LocalDate birthday;
    private String email;
    private String phoneNumber;

}

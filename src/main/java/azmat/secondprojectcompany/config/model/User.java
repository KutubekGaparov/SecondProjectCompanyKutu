package azmat.secondprojectcompany.config.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email")
        })
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_seq")
    @SequenceGenerator(name = "user_seq",
            sequenceName = "SEQ_USER", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min = 8, max = 64, message = "Password must be 8-64 char long")
    private String password;

    private String fullName;

    @OneToOne
    private Role role;

}

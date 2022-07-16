package azamat.model.entity.din;

import azamat.model.FileInformation.Gallery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "mechitter")
@RequiredArgsConstructor
@Getter
@Setter
public class Mechitter {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "mechitter_seq")
    @SequenceGenerator(name = "mechitter_seq",
            sequenceName = "SEQ_MECHITTER", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(unique = true)
    private String mosqueName;
    @Column(unique = true)
    private String imamName;
    @Column(unique = true)
    private String imamLastName;
    private LocalDate birthDay;
    private String positions;
    private String address;
    private String phone;
    private String email;

    @OneToOne
    private Gallery gallery;
}

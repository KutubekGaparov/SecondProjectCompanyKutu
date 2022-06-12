package azmat.secondprojectcompany.model;

import azmat.secondprojectcompany.model.FileInformation.Gallery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    @OneToOne
    private Gallery gallery;
}

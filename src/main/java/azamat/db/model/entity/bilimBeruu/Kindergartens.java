package azamat.db.model.entity.bilimBeruu;

import azamat.FileInformation.Gallery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "kindergartens")

public class Kindergartens {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "kinder_seq")
    @SequenceGenerator(name = "kinder_seq",
            sequenceName = "SEQ_KINDER", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String kindergartensName;
    private String directorFullName;
    private String countKindergartens;
    private String language;
    private String address;
    private String email;
    private String phoneNumber;



    @OneToOne(cascade = CascadeType.ALL)
    private Gallery gallery;

}

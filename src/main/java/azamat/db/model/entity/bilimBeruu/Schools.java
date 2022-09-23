package azamat.db.model.entity.bilimBeruu;

import azamat.FileInformation.FileInformation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "schools")

public class Schools {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "school_seq")
    @SequenceGenerator(name = "school_seq",
            sequenceName = "SEQ_SCHOOL", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(unique = true)
    private String schoolName;

    @Column(unique = true)
    private String directorFullName;

    private String address;
    private String phoneNumber;

    @Column(length = 10000000)
    private String text;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileInformation fileInformation;
}


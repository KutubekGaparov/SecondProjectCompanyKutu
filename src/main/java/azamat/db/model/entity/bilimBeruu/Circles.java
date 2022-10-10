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
@Table(name = "circles")

public class Circles {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "circles_seq")
    @SequenceGenerator(name = "circles_seq",
            sequenceName = "SEQ_CIRCLES", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String courseName;
    private String courseTeacher;
    @Column(length = 10000000)
    private String info;
    private String phoneNumber;
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileInformation fileInformation;
}


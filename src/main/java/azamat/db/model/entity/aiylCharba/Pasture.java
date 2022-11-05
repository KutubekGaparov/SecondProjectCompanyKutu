package azamat.db.model.entity.aiylCharba;

import azamat.FileInformation.FileInformation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "pasture")
public class Pasture {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "pasture_seq")
    @SequenceGenerator(name = "pasture_seq",
            sequenceName = "SEQ_PASTURE", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column(length = 10000000)
    private String text;
    private Integer sss;

    @Column(unique = true)
    private String directorFullName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileInformation fileInformation;
}


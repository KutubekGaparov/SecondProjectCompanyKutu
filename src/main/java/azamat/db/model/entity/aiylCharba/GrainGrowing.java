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
@Table(name = "grainGrowing")
public class GrainGrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "grain_seq")
    @SequenceGenerator(name = "grain_seq",
            sequenceName = "SEQ_GRAIN", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column(length = 10000000)
    private String text;

    @Column(unique = true)
    private String directorFullName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileInformation fileInformation;
}


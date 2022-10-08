package azamat.db.model;

import azamat.FileInformation.FileInformation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "newAnnouncement")

public class NewsAnnouncement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "new_seq")
    @SequenceGenerator(name = "new_seq",
            sequenceName = "SEQ_NEW", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column(length = 1000000)
    private String text;
    private String dateOfNewAnnouncement;
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileInformation fileInformation;

}

package azmat.secondprojectcompany.model;

import azmat.secondprojectcompany.model.FileInformation.Gallery;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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
    @Column(length = 10000000)
    private String text;

    @OneToOne
    private Gallery gallery;
}

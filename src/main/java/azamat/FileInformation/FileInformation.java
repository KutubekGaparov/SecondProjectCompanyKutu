package azamat.FileInformation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@RequiredArgsConstructor
@Table(name = "gallery")
public class FileInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "gallery_seq")
    @SequenceGenerator(name = "gallery_seq",
            sequenceName = "SEQ_GALLERY", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long fileId;

    private String photo;

    private String keyOfPhoto;

}

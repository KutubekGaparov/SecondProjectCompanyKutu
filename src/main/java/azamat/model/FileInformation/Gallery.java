package azamat.model.FileInformation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "gallery")
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "gallery_seq")
    @SequenceGenerator(name = "gallery_seq",
            sequenceName = "SEQ_GALLERY", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String firstPhoto;
    private String secondPhoto;
    private String thirdPhoto;
    private String file;

    private String keyOfFirstPhoto;
    private String keyOfSecondPhoto;
    private String keyOfThirdPhoto;
    private String KeyOfFile;
}

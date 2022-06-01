package azmat.secondprojectcompany.model.din;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "prayer")
@RequiredArgsConstructor
@Getter
@Setter
public class Prayer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_gen")
    @SequenceGenerator(name = "hibernate_gen", sequenceName = "hibernate_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String prayerName;
    private int timePrayer;
    private String ablution;

}

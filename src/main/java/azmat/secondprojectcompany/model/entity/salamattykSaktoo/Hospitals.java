package azmat.secondprojectcompany.model.entity.salamattykSaktoo;

import azmat.secondprojectcompany.model.FileInformation.Gallery;
import azmat.secondprojectcompany.model.entity.SalamattyktySaktoo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "hospitals")

public class Hospitals {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator ="hibernate_gen" )
    @SequenceGenerator(name = "hibernate_gen",sequenceName = "hibernate_seq",allocationSize = 1)
    @Column(name = "id",nullable = false)
    private Long id;

    private String hospitalName;
    private String directorHospital;
    private String  address;
    private String phoneNumber;
    private String email;

    @ManyToOne
    private SalamattyktySaktoo salamattyktySaktoo;

    @OneToOne
    private Gallery gallery;

}

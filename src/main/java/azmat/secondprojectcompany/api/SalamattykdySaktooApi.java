package azmat.secondprojectcompany.api;

import azmat.secondprojectcompany.db.servise.salamattykdySaktoo.DoctorsAdviceService;
import azmat.secondprojectcompany.db.servise.salamattykdySaktoo.HospitalsService;
import azmat.secondprojectcompany.db.servise.salamattykdySaktoo.InsuranceService;
import azmat.secondprojectcompany.db.servise.salamattykdySaktoo.MedicalCenterService;
import azmat.secondprojectcompany.model.entity.jashtarIshteri.YouthCommitteeManager;
import azmat.secondprojectcompany.model.entity.salamattykSaktoo.DoctorsAdvice;
import azmat.secondprojectcompany.model.entity.salamattykSaktoo.Hospitals;
import azmat.secondprojectcompany.model.entity.salamattykSaktoo.Insurance;
import azmat.secondprojectcompany.model.entity.salamattykSaktoo.MedicalCenter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/agriculture/acEvent")
@AllArgsConstructor
@Tag(name = "SalamattykdySaktoo GetApi")
public class SalamattykdySaktooApi {

    private DoctorsAdviceService doctorsAdviceService;
    private HospitalsService hospitalsService;
    private InsuranceService insuranceService;
    private MedicalCenterService medicalCenterService;

    @Operation(summary = "Get all doctorsAdvice")
    @GetMapping("/doctorsAdvice")
    public List<DoctorsAdvice> getAllDoctorsAdvices() {
        return doctorsAdviceService.getAll();
    }

    @Operation(summary = "Get all hospitals")
    @GetMapping("/hospitals")
    public List<Hospitals> getAllHospitals() {
        return hospitalsService.getAll();
    }

    @Operation(summary = "Get all insurance")
    @GetMapping("/insurance")
    public List<Insurance> getAllInsurance() {
        return insuranceService.getAll();
    }

    @Operation(summary = "Get all medicalCenter")
    @GetMapping("/medicalCenter")
    public List<MedicalCenter> getAllMedicalCenter() {
        return medicalCenterService.getAll();
    }

}

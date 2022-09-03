package azamat.api.salamattykdySaktooApi;

import azamat.db.servise.salamattykdySaktoo.MedicalCenterService;
import azamat.db.model.entity.salamattykSaktoo.MedicalCenter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/healthcare/medicalCenter")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "SalamattykSaktoo Medical Center", description = "crud operations")
public class MedicalCenterApi {

    private MedicalCenterService medicalCenterService;

    @Operation(summary = "Save MedicalCenter by id ")
    @PostMapping("/save")
    public MedicalCenter saveMedicalCenterService(@RequestBody MedicalCenter medicalCenter) {
        return medicalCenterService.saveMedicalCenter(medicalCenter);
    }

    @Operation(summary = "Update MedicalCenter by id")
    @PatchMapping("/{id}")
    public MedicalCenter update(@RequestBody MedicalCenter medicalCenter,@PathVariable Long id) {
        return medicalCenterService.update(medicalCenter,id);
    }

    @Operation(summary = "Delete MedicalCenter by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveMedicalCenterService(@PathVariable Long id) {
        return medicalCenterService.deleteById(id);
    }
}

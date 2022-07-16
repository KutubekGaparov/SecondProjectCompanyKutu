package azamat.api.salamattykdySaktooApi;

import azamat.db.servise.salamattykdySaktoo.HospitalsService;
import azamat.model.entity.salamattykSaktoo.Hospitals;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/healthcare/hospitals")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "SalamattykSaktoo", description = "crud operations")
public class HospitalsApi {

    private HospitalsService hospitalsService;

    @Operation(summary = "Save Hospitals by id ")
    @PostMapping("/save")
    public Hospitals saveHospitalsService(@RequestBody Hospitals hospitals) {
        return hospitalsService.saveHospitals(hospitals);
    }

    @Operation(summary = "Update Hospitals by id")
    @PatchMapping("/{id}")
    public Hospitals update(@RequestBody Hospitals hospitals,@PathVariable Long id) {
        return hospitalsService.update(hospitals,id);
    }

    @Operation(summary = "Delete Hospitals by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveHospitalsService(@PathVariable Long id) {
        return hospitalsService.deleteById(id);
    }
}

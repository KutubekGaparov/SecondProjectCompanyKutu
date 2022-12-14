package azamat.api.salamattykdySaktooApi;

import azamat.db.servise.salamattykdySaktoo.HospitalsService;
import azamat.db.model.entity.salamattykSaktoo.Hospitals;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/healthcare/hospitals")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "SalamattykSaktoo Hospitals", description = "crud operations")
public class HospitalsApi {

    private HospitalsService hospitalsService;

    @Operation(summary = "Save Hospitals by id ")
    @PostMapping("/save")
    public Hospitals saveHospitalsService(@RequestBody Hospitals hospitals) {
        return hospitalsService.saveHospitals(hospitals);
    }

    @Operation(summary = "Upload files", description = "Upload files to aws")
    @PostMapping("/upload-file/{id}")
    public LinkedHashMap<String, String> uploadFile(@RequestBody MultipartFile firstPhoto,
                                                    @PathVariable Long id) {
        return hospitalsService.uploadFile(firstPhoto, id);
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

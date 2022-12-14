package azamat.api.salamattykdySaktooApi;

import azamat.db.servise.salamattykdySaktoo.InsuranceService;
import azamat.db.model.entity.salamattykSaktoo.Insurance;
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
@RequestMapping("/api/healthcare/insurance")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "SalamattykSaktoo Insurances", description = "crud operations")
public class InsuranceApi {

    private InsuranceService insuranceService;

    @Operation(summary = "Save Insurance by id ")
    @PostMapping("/save")
    public Insurance saveInsuranceService(@RequestBody Insurance insurance) {
        return insuranceService.saveInsurance(insurance);
    }
    @Operation(summary = "Upload files", description = "Upload files to aws")
    @PostMapping("/upload-file/{id}")
    public LinkedHashMap<String, String> uploadFile(@RequestBody MultipartFile firstPhoto,
                                                    @PathVariable Long id) {
        return insuranceService.uploadFile(firstPhoto, id);
    }

    @Operation(summary = "Update Insurance by id")
    @PatchMapping("/{id}")
    public Insurance update(@RequestBody Insurance insurance,@PathVariable Long id) {
        return insuranceService.update(insurance,id);
    }

    @Operation(summary = "Delete Insurance by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveInsuranceService(@PathVariable Long id) {
        return insuranceService.deleteById(id);
    }
}

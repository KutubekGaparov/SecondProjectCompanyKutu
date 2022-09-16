package azamat.api.salamattykdySaktooApi;

import azamat.db.servise.salamattykdySaktoo.DoctorsAdviceService;
import azamat.db.model.entity.salamattykSaktoo.DoctorsAdvice;
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
@RequestMapping("/api/healthcare/doctorsAdvice")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "SalamattykSaktoo Doctors Advice", description = "crud operations")
public class DoctorsAdviceApi {

    private DoctorsAdviceService doctorsAdviceService;

    @Operation(summary = "Save DoctorsAdvice by id ")
    @PostMapping("/save")
    public DoctorsAdvice saveDoctorsAdviceService(@RequestBody DoctorsAdvice doctorsAdvice) {
        return doctorsAdviceService.saveDoctorsAdvice(doctorsAdvice);
    }

    @Operation(summary = "Upload files", description = "Upload files to aws")
    @PostMapping("/upload-file/{id}")
    public LinkedHashMap<String, String> uploadFile(@RequestBody MultipartFile firstPhoto,
                                                    @PathVariable Long id) {
        return doctorsAdviceService.uploadFile(firstPhoto, id);
    }

    @Operation(summary = "Update DoctorsAdvice by id")
    @PatchMapping("/{id}")
    public DoctorsAdvice update(@RequestBody DoctorsAdvice doctorsAdvice,@PathVariable Long id) {
        return doctorsAdviceService.update(doctorsAdvice,id);
    }

    @Operation(summary = "Delete DoctorsAdvice by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveDoctorsAdviceService(@PathVariable Long id) {
        return doctorsAdviceService.deleteById(id);
    }
}

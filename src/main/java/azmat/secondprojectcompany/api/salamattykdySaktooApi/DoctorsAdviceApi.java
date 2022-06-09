package azmat.secondprojectcompany.api.salamattykdySaktooApi;

import azmat.secondprojectcompany.db.servise.salamattykdySaktoo.DoctorsAdviceService;
import azmat.secondprojectcompany.model.entity.salamattykSaktoo.DoctorsAdvice;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "SalamattykSaktoo", description = "crud operations")
public class DoctorsAdviceApi {

    private DoctorsAdviceService doctorsAdviceService;

    @Operation(summary = "Save DoctorsAdvice by id ")
    @PostMapping("/save")
    public DoctorsAdvice saveDoctorsAdviceService(@RequestBody DoctorsAdvice doctorsAdvice) {
        return doctorsAdviceService.saveDoctorsAdvice(doctorsAdvice);
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

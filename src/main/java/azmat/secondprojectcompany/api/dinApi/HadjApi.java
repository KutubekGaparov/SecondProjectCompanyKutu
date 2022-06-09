package azmat.secondprojectcompany.api.dinApi;

import azmat.secondprojectcompany.db.servise.dinService.HadjService;
import azmat.secondprojectcompany.model.entity.bilimBeruu.Schools;
import azmat.secondprojectcompany.model.entity.din.Hadj;
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
@Tag(name = "Din", description = "crud operations")
public class HadjApi {

    private HadjService hadjService;

    @Operation(summary = "Save Hadj by id ")
    @PostMapping("/save")
    public Hadj saveHadjService(@RequestBody Hadj hadj) {
        return hadjService.saveHadj(hadj);
    }

    @Operation(summary = "Update Hadj by id")
    @PatchMapping("/{id}")
    public Hadj update(@RequestBody Hadj hadj,@PathVariable Long id) {
        return hadjService.update(hadj,id);
    }

    @Operation(summary = "Delete Hadj by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveHadjService(@PathVariable Long id) {
        return hadjService.deleteById(id);
    }
}

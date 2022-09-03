package azamat.api.bilimBeruuApi;

import azamat.db.servise.bilimBeruu.ORTService;
import azamat.db.model.entity.bilimBeruu.ORT;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/education/ort")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "BilimBeruu ORT", description = "crud operations")
public class ORTApi {

    private ORTService ortService;

    @Operation(summary = "Save ORT by id ")
    @PostMapping("/save")
    public ORT saveORTService(@RequestBody ORT ort) {
        return ortService.saveORT(ort);
    }

    @Operation(summary = "Update ORT by id")
    @PatchMapping("/{id}")
    public ORT update(@RequestBody ORT ort,@PathVariable Long id) {
        return ortService.update(ort,id);
    }

    @Operation(summary = "Delete ORT by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveORTService(@PathVariable Long id) {
        return ortService.deleteById(id);
    }
}

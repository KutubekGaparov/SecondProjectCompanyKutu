package azmat.secondprojectcompany.api.dinApi;

import azmat.secondprojectcompany.db.servise.dinService.MechitterService;
import azmat.secondprojectcompany.model.entity.bilimBeruu.Schools;
import azmat.secondprojectcompany.model.entity.din.Mechitter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/din/mosques")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "Din", description = "crud operations")
public class MechitterApi {

    private MechitterService mechitterService;

    @Operation(summary = "Save Mechitter by id ")
    @PostMapping("/save")
    public Mechitter saveMechitterService(@RequestBody Mechitter mechitter) {
        return mechitterService.saveMechitter(mechitter);
    }

    @Operation(summary = "Update Mechitter by id")
    @PatchMapping("/{id}")
    public Mechitter update(@RequestBody Mechitter mechitter,@PathVariable Long id) {
        return mechitterService.update(mechitter,id);
    }

    @Operation(summary = "Delete Mechitter by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveMechitterService(@PathVariable Long id) {
        return mechitterService.deleteById(id);
    }
}

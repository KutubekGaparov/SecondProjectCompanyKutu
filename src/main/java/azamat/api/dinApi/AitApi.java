package azamat.api.dinApi;

import azamat.db.servise.dinService.AitService;
import azamat.model.entity.din.Ait;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/din/ait")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "Din", description = "crud operations")
public class AitApi {

    private AitService aitService;

    @Operation(summary = "Save Ait by id ")
    @PostMapping("/save")
    public Ait saveAitService(@RequestBody Ait ait) {
        return aitService.saveAit(ait);
    }

    @Operation(summary = "Update Ait by id")
    @PatchMapping("/{id}")
    public Ait update(@RequestBody Ait ait,@PathVariable Long id) {
        return aitService.update(ait,id);
    }

    @Operation(summary = "Delete Ait by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveAitService(@PathVariable Long id) {
        return aitService.deleteById(id);
    }
}

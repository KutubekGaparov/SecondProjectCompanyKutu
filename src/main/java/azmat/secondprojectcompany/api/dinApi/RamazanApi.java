package azmat.secondprojectcompany.api.dinApi;

import azmat.secondprojectcompany.db.servise.dinService.RamazanService;
import azmat.secondprojectcompany.model.entity.bilimBeruu.Schools;
import azmat.secondprojectcompany.model.entity.din.Ramazan;
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
public class RamazanApi {

    private RamazanService ramazanService;

    @Operation(summary = "Save Ramazan by id ")
    @PostMapping("/save")
    public Ramazan saveRamazanService(@RequestBody Ramazan ramazan) {
        return ramazanService.saveRamazan(ramazan);
    }

    @Operation(summary = "Update Ramazan by id")
    @PatchMapping("/{id}")
    public Ramazan update(@RequestBody Ramazan ramazan,@PathVariable Long id) {
        return ramazanService.update(ramazan,id);
    }

    @Operation(summary = "Delete Ramazan by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveRamazanService(@PathVariable Long id) {
        return ramazanService.deleteById(id);
    }
}

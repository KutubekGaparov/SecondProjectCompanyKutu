package azamat.api.jashtarIshteriApi;

import azamat.db.servise.jashtarIshteri.YouthInitiativesService;
import azamat.model.entity.jashtarIshteri.YouthInitiatives;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/youthAffairs/youthInitiatives")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "JashtarIshteri", description = "crud operations")
public class YouthInitiativesApi {

    private YouthInitiativesService youthInitiativesService;

    @Operation(summary = "Save YouthInitiatives by id ")
    @PostMapping("/save")
    public YouthInitiatives saveYouthInitiativesService(@RequestBody YouthInitiatives youthInitiatives) {
        return youthInitiativesService.saveYouthInitiatives(youthInitiatives);
    }

    @Operation(summary = "Update YouthInitiatives by id")
    @PatchMapping("/{id}")
    public YouthInitiatives update(@RequestBody YouthInitiatives youthInitiatives,@PathVariable Long id) {
        return youthInitiativesService.update(youthInitiatives,id);
    }

    @Operation(summary = "Delete YouthInitiatives by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveYouthInitiativesService(@PathVariable Long id) {
        return youthInitiativesService.deleteById(id);
    }
}

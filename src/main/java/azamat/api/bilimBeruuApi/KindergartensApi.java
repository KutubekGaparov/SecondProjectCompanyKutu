package azamat.api.bilimBeruuApi;

import azamat.db.servise.bilimBeruu.KindergartensService;
import azamat.db.model.entity.bilimBeruu.Kindergartens;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/education/kindergartens")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "BilimBeruu Kindergartens", description = "crud operations")
public class KindergartensApi {

    private KindergartensService kindergartensService;

    @Operation(summary = "Save Kindergartens by id ")
    @PostMapping("/save")
    public Kindergartens saveKindergartensService(@RequestBody Kindergartens kindergartens) {
        return kindergartensService.saveKindergartens(kindergartens);
    }

    @Operation(summary = "Update Kindergartens by id")
    @PatchMapping("/{id}")
    public Kindergartens update(@RequestBody Kindergartens kindergartens,@PathVariable Long id) {
        return kindergartensService.update(kindergartens,id);
    }

    @Operation(summary = "Delete Kindergartens by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveKindergartensService(@PathVariable Long id) {
        return kindergartensService.deleteById(id);
    }
}

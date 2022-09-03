package azamat.api.culturaApi;

import azamat.db.servise.kultura.CulturalFiguresService;
import azamat.db.model.entity.Kultura.CulturalFigures;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/culture")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "Cultura CulturalFigures", description = "crud operations")
public class CulturalFiguresApi {

    private CulturalFiguresService culturalFiguresService;

    @Operation(summary = "Save CulturalFigures by id ")
    @PostMapping("/save")
    public CulturalFigures saveCulturalFiguresService(@RequestBody CulturalFigures culturalFigures) {
        return culturalFiguresService.saveCulturalFigures(culturalFigures);
    }

    @Operation(summary = "Update CulturalFigures by id")
    @PatchMapping("/{id}")
    public CulturalFigures update(@RequestBody CulturalFigures culturalFigures,@PathVariable Long id) {
        return culturalFiguresService.update(culturalFigures,id);
    }

    @Operation(summary = "Delete CulturalFigures by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveCulturalFiguresService(@PathVariable Long id) {
        return culturalFiguresService.deleteById(id);
    }
}

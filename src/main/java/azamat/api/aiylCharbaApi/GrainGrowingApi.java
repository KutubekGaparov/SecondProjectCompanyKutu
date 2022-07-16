package azamat.api.aiylCharbaApi;

import azamat.db.servise.aiylCharba.GrainGrowingService;
import azamat.model.entity.aiylCharba.GrainGrowing;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/agriculture/grainGrowing")
@AllArgsConstructor
//@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "AiylCharba", description = "crud operations")
public class GrainGrowingApi {

    private GrainGrowingService grainGrowingService;

    @Operation(summary = "Save GrainGrowing by id ")
    @PostMapping("/save")
    public GrainGrowing saveGrainGrowingService(@RequestBody GrainGrowing grainGrowing) {
        return grainGrowingService.saveGrainGraving(grainGrowing);
    }

    @Operation(summary = "Update GrainGrowing by id")
    @PatchMapping("/{id}")
    public GrainGrowing update(@RequestBody GrainGrowing grainGrowing, @PathVariable Long id) {
        return grainGrowingService.update(grainGrowing,id);
    }

    @Operation(summary = "Delete ACEvent by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveGrainGrowingService(@PathVariable Long id) {
        return grainGrowingService.deleteById(id);
    }

}

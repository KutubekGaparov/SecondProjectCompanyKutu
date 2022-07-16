package azamat.api.bilimBeruuApi;

import azamat.db.servise.bilimBeruu.CirclesService;
import azamat.model.entity.bilimBeruu.Circles;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/education/circles")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "BilimBeruu", description = "crud operations")
public class CirclesApi {

    private CirclesService circlesService;

    @Operation(summary = "Save Circles by id ")
    @PostMapping("/save")
    public Circles saveCirclesService(@RequestBody Circles circles) {
        return circlesService.saveCircles(circles);
    }

    @Operation(summary = "Update Circles by id")
    @PatchMapping("/{id}")
    public Circles update(@RequestBody Circles circles,@PathVariable Long id) {
        return circlesService.update(circles,id);
    }

    @Operation(summary = "Delete Circles by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveCirclesService(@PathVariable Long id) {
        return circlesService.deleteById(id);
    }



}

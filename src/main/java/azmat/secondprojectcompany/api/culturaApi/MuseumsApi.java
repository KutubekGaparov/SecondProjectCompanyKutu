package azmat.secondprojectcompany.api.culturaApi;

import azmat.secondprojectcompany.db.servise.kultura.MuseumsService;
import azmat.secondprojectcompany.model.entity.Kultura.Museums;
import azmat.secondprojectcompany.model.entity.bilimBeruu.MOEEvent;
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
@Tag(name = "Cultura", description = "crud operations")
public class MuseumsApi {

    private MuseumsService museumsService;

    @Operation(summary = "Save Museums by id ")
    @PostMapping("/save")
    public Museums saveMuseumsService(@RequestBody Museums museums) {
        return museumsService.saveMuseums(museums);
    }

    @Operation(summary = "Update Museums by id")
    @PatchMapping("/{id}")
    public Museums update(@RequestBody Museums museums,@PathVariable Long id) {
        return museumsService.update(museums,id);
    }

    @Operation(summary = "Delete BEEvent by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveMuseumsService(@PathVariable Long id) {
        return museumsService.deleteById(id);
    }
}

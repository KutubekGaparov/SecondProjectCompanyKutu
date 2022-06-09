package azmat.secondprojectcompany.api.bilimBeruuApi;

import azmat.secondprojectcompany.db.servise.bilimBeruu.MOEEventService;
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
@Tag(name = "BilimBeruu", description = "crud operations")
public class BEventApi {

    private MOEEventService eventService;

    @Operation(summary = "Save BEEvent by id ")
    @PostMapping("/save")
    public MOEEvent saveBEventService(@RequestBody MOEEvent event) {
        return eventService.saveEvent(event);
    }

    @Operation(summary = "Update BEEvent by id")
    @PatchMapping("/{id}")
    public MOEEvent update(@RequestBody MOEEvent event,@PathVariable Long id) {
        return eventService.update(event,id);
    }

    @Operation(summary = "Delete BEEvent by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveBEventService(@PathVariable Long id) {
        return eventService.deleteById(id);
    }
}

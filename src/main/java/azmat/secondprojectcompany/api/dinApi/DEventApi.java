package azmat.secondprojectcompany.api.dinApi;

import azmat.secondprojectcompany.db.servise.dinService.DEventService;
import azmat.secondprojectcompany.model.entity.bilimBeruu.Schools;
import azmat.secondprojectcompany.model.entity.din.Ait;
import azmat.secondprojectcompany.model.entity.din.DEvents;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/din/dEvent")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "Din", description = "crud operations")
public class DEventApi {

    private DEventService dEventService;

    @Operation(summary = "Save DEvents by id ")
    @PostMapping("/save")
    public DEvents saveDEventsService(@RequestBody DEvents dEvents) {
        return dEventService.saveDEvents(dEvents);
    }

    @Operation(summary = "Update DEvents by id")
    @PatchMapping("/{id}")
    public DEvents update(@RequestBody DEvents dEvents,@PathVariable Long id) {
        return dEventService.update(dEvents,id);
    }

    @Operation(summary = "Delete DEvents by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveDEventsService(@PathVariable Long id) {
        return dEventService.deleteById(id);
    }
}

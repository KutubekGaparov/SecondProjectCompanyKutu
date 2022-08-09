package azamat.api.aiylCharbaApi;

import azamat.db.servise.aiylCharba.ACEventService;
import azamat.model.entity.aiylCharba.ACEvent;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/agriculture/acEvent")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "AiylCharba ACEvent", description = "crud operations")
public class ACEventApi {


    private ACEventService acEventService;

    @Operation(summary = "Save ACEvent by id ")
    @PostMapping("/save")
    public ACEvent saveAcEventService(@RequestBody ACEvent acEvent) {
        return acEventService.saveAsEvent(acEvent);
    }

    @Operation(summary = "Update ACEvent by id")
    @PatchMapping("/{id}")
    public ACEvent update(@RequestBody ACEvent acEvent,@PathVariable Long id) {
        return acEventService.update(acEvent,id);
    }

    @Operation(summary = "Delete ACEvent by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveAcEventService(@PathVariable Long id) {
        return acEventService.deleteById(id);
    }

}

package azamat.api.jashtarIshteriApi;

import azamat.db.servise.jashtarIshteri.SportsEventsService;
import azamat.db.model.entity.jashtarIshteri.SportsEvents;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/youthAffairs/sports")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "JashtarIshteri SportsEvents", description = "crud operations")
public class SportsEventsApi {

    private SportsEventsService sportsEventService;

    @Operation(summary = "Save SportsEvents by id ")
    @PostMapping("/save")
    public SportsEvents saveSportsEventsService(@RequestBody SportsEvents sportsEvents) {
        return sportsEventService.saveSportsEvents(sportsEvents);
    }

    @Operation(summary = "Upload files", description = "Upload files to aws")
    @PostMapping("/upload-file/{id}")
    public LinkedHashMap<String, String> uploadFile(@RequestBody MultipartFile firstPhoto,
                                                    @PathVariable Long id) {
        return sportsEventService.uploadFile(firstPhoto, id);
    }

    @Operation(summary = "Update SportsEvents by id")
    @PatchMapping("/{id}")
    public SportsEvents update(@RequestBody SportsEvents sportsEvents,@PathVariable Long id) {
        return sportsEventService.update(sportsEvents,id);
    }

    @Operation(summary = "Delete SportsEvents by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveSportsEventsService(@PathVariable Long id) {
        return sportsEventService.deleteById(id);
    }
}

package azamat.api.dinApi;

import azamat.db.servise.dinService.DEventService;
import azamat.db.model.entity.din.DEvents;
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
@RequestMapping("/api/din/dEvent")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "Din DEvents", description = "crud operations")
public class DEventApi {

    private DEventService dEventService;

    @Operation(summary = "Save DEvents by id ")
    @PostMapping("/save")
    public DEvents saveDEventsService(@RequestBody DEvents dEvents) {
        return dEventService.saveDEvents(dEvents);
    }

    @Operation(summary = "Upload files", description = "Upload files to aws")
    @PostMapping("/upload-file/{id}")
    public LinkedHashMap<String, String> uploadFile(@RequestBody MultipartFile firstPhoto,
                                                    @PathVariable Long id) {
        return dEventService.uploadFile(firstPhoto, id);
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

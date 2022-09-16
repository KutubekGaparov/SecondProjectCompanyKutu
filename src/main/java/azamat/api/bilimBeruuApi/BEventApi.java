package azamat.api.bilimBeruuApi;

import azamat.db.servise.bilimBeruu.MOEEventService;
import azamat.db.model.entity.bilimBeruu.MOEEvent;
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
@RequestMapping("/api/education/bEvent")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "BilimBeruu MOEEvent", description = "crud operations")
public class BEventApi {

    private MOEEventService eventService;

    @Operation(summary = "Save BEEvent by id ")
    @PostMapping("/save")
    public MOEEvent saveBEventService(@RequestBody MOEEvent event) {
        return eventService.saveEvent(event);
    }

    @Operation(summary = "Upload files", description = "Upload files to aws")
    @PostMapping("/upload-file/{id}")
    public LinkedHashMap<String, String> uploadFile(@RequestBody MultipartFile firstPhoto,
                                                    @PathVariable Long id) {
        return eventService.uploadFile(firstPhoto, id);
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

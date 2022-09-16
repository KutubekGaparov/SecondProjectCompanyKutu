package azamat.api.culturaApi;

import azamat.db.servise.kultura.CultureEventsService;
import azamat.db.model.entity.Kultura.CultureEvents;
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
@RequestMapping("/api/culture/cultureEvents")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "Cultura CultureEvents", description = "crud operations")
public class CultureEventsApi {

    private CultureEventsService cultureEventsService;

    @Operation(summary = "Save CultureEvents by id ")
    @PostMapping("/save")
    public CultureEvents saveCultureEventsService(@RequestBody CultureEvents cultureEvents) {
        return cultureEventsService.saveCultureEvents(cultureEvents);
    }

    @Operation(summary = "Upload files", description = "Upload files to aws")
    @PostMapping("/upload-file/{id}")
    public LinkedHashMap<String, String> uploadFile(@RequestBody MultipartFile firstPhoto,
                                                    @PathVariable Long id) {
        return cultureEventsService.uploadFile(firstPhoto, id);
    }
    @Operation(summary = "Update CultureEvents by id")
    @PatchMapping("/{id}")
    public CultureEvents update(@RequestBody CultureEvents cultureEvents,@PathVariable Long id) {
        return cultureEventsService.update(cultureEvents,id);
    }

    @Operation(summary = "Delete BEEvent by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveCultureEventsService(@PathVariable Long id) {
        return cultureEventsService.deleteById(id);
    }
}

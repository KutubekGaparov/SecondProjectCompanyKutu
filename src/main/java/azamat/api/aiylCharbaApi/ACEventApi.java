package azamat.api.aiylCharbaApi;

import azamat.db.servise.aiylCharba.ACEventService;
import azamat.db.model.entity.aiylCharba.ACEvent;
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

    @Operation(summary = "Upload files", description = "Upload files to aws")
    @PostMapping("/upload-file/{id}")
    public LinkedHashMap<String, String> uploadFile(@RequestBody MultipartFile firstPhoto,
                                                    @PathVariable Long id) {
        return acEventService.uploadFile(firstPhoto, id);
    }

}

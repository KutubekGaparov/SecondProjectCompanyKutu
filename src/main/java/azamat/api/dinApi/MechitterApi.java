package azamat.api.dinApi;

import azamat.db.servise.dinService.MechitterService;
import azamat.db.model.entity.din.Mechitter;
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
@RequestMapping("/api/din/mosques")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "Din Mechitter", description = "crud operations")
public class MechitterApi {

    private MechitterService mechitterService;

    @Operation(summary = "Save Mechitter by id ")
    @PostMapping("/save")
    public Mechitter saveMechitterService(@RequestBody Mechitter mechitter) {
        return mechitterService.saveMechitter(mechitter);
    }

    @Operation(summary = "Upload files", description = "Upload files to aws")
    @PostMapping("/upload-file/{id}")
    public LinkedHashMap<String, String> uploadFile(@RequestBody MultipartFile firstPhoto,
                                                    @PathVariable Long id) {
        return mechitterService.uploadFile(firstPhoto, id);
    }
    @Operation(summary = "Update Mechitter by id")
    @PatchMapping("/{id}")
    public Mechitter update(@RequestBody Mechitter mechitter,@PathVariable Long id) {
        return mechitterService.update(mechitter,id);
    }

    @Operation(summary = "Delete Mechitter by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveMechitterService(@PathVariable Long id) {
        return mechitterService.deleteById(id);
    }
}

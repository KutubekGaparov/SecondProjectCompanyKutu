package azamat.api.dinApi;

import azamat.db.servise.dinService.RamazanService;
import azamat.db.model.entity.din.Ramazan;
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
@RequestMapping("/api/din/ramazan")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "Din Ramazan", description = "crud operations")
public class RamazanApi {

    private RamazanService ramazanService;

    @Operation(summary = "Save Ramazan by id ")
    @PostMapping("/save")
    public Ramazan saveRamazanService(@RequestBody Ramazan ramazan) {
        return ramazanService.saveRamazan(ramazan);
    }

    @Operation(summary = "Upload files", description = "Upload files to aws")
    @PostMapping("/upload-file/{id}")
    public LinkedHashMap<String, String> uploadFile(@RequestBody MultipartFile firstPhoto,
                                                    @PathVariable Long id) {
        return ramazanService.uploadFile(firstPhoto, id);
    }
    @Operation(summary = "Update Ramazan by id")
    @PatchMapping("/{id}")
    public Ramazan update(@RequestBody Ramazan ramazan,@PathVariable Long id) {
        return ramazanService.update(ramazan,id);
    }

    @Operation(summary = "Delete Ramazan by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveRamazanService(@PathVariable Long id) {
        return ramazanService.deleteById(id);
    }
}

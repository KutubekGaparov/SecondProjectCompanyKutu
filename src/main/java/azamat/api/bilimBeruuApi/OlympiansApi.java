package azamat.api.bilimBeruuApi;

import azamat.db.servise.bilimBeruu.OlympiansService;
import azamat.db.model.entity.bilimBeruu.Olympians;
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
@RequestMapping("/api/education/olympiads")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "BilimBeruu Olympians", description = "crud operations")
public class OlympiansApi {

    private OlympiansService olympiansService;

    @Operation(summary = "Save Olympians by id ")
    @PostMapping("/save")
    public Olympians saveOlympiansService(@RequestBody Olympians olympians) {
        return olympiansService.saveOlympians(olympians);
    }

    @Operation(summary = "Update Olympians by id")
    @PatchMapping("/{id}")
    public Olympians update(@RequestBody Olympians olympians,@PathVariable Long id) {
        return olympiansService.update(olympians,id);
    }

    @Operation(summary = "Delete Olympians by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveOlympiansService(@PathVariable Long id) {
        return olympiansService.deleteById(id);
    }

    @Operation(summary = "Upload files", description = "Upload files to aws")
    @PostMapping("/upload-file/{id}")
    public LinkedHashMap<String, String> uploadFile(@RequestBody MultipartFile firstPhoto,
                                                    @PathVariable Long id) {
        return olympiansService.uploadFile(firstPhoto, id);
    }
}

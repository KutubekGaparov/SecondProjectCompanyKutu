package azamat.api.bashkyBetApi;

import azamat.db.model.Ataktuular;
import azamat.db.servise.bashkyBet.AtaktuularService;
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
@RequestMapping("/api/homePage/ataktuular")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "BashkyBet Ataktuular", description = "crud operations")
public class AtaktuularApi {

    private AtaktuularService service;

    @Operation(summary = "Save Ataktuular by id ")
    @PostMapping("/save")
    public Ataktuular saveKyzmatkerlerService(@RequestBody Ataktuular ataktuular) {
        return service.save(ataktuular);
    }

    @Operation(summary = "Update Ataktuular by id")
    @PatchMapping("/{id}")
    public Ataktuular update(@RequestBody Ataktuular ataktuular, @PathVariable Long id) {
        return service.update(ataktuular, id);
    }

    @Operation(summary = "Delete Ataktuular by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveKyzmatkerlerService(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @Operation(summary = "Upload files", description = "Upload files to aws")
    @PostMapping("/upload-file/{id}")
    public LinkedHashMap<String, String> uploadFile(@RequestBody MultipartFile firstPhoto,
                                                    @PathVariable Long id) {
        return service.uploadFile(firstPhoto, id);
    }
}

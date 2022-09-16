package azamat.api.bilimBeruuApi;

import azamat.db.servise.bilimBeruu.KindergartensService;
import azamat.db.model.entity.bilimBeruu.Kindergartens;
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
@RequestMapping("/api/education/kindergartens")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "BilimBeruu Kindergartens", description = "crud operations")
public class KindergartensApi {

    private KindergartensService kindergartensService;

    @Operation(summary = "Save Kindergartens by id ")
    @PostMapping("/save")
    public Kindergartens saveKindergartensService(@RequestBody Kindergartens kindergartens) {
        return kindergartensService.saveKindergartens(kindergartens);
    }

    @Operation(summary = "Update Kindergartens by id")
    @PatchMapping("/{id}")
    public Kindergartens update(@RequestBody Kindergartens kindergartens,@PathVariable Long id) {
        return kindergartensService.update(kindergartens,id);
    }

    @Operation(summary = "Delete Kindergartens by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveKindergartensService(@PathVariable Long id) {
        return kindergartensService.deleteById(id);
    }
    @Operation(summary = "Upload files", description = "Upload files to aws")
    @PostMapping("/upload-file/{id}")
    public LinkedHashMap<String, String> uploadFile(@RequestBody MultipartFile firstPhoto,
                                                    @PathVariable Long id) {
        return kindergartensService.uploadFile(firstPhoto, id);
    }
}

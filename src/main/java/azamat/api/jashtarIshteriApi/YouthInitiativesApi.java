package azamat.api.jashtarIshteriApi;

import azamat.db.servise.jashtarIshteri.YouthInitiativesService;
import azamat.db.model.entity.jashtarIshteri.YouthInitiatives;
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
@RequestMapping("/api/youthAffairs/youthInitiatives")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "JashtarIshteri YouthInitiatives", description = "crud operations")
public class YouthInitiativesApi {

    private YouthInitiativesService youthInitiativesService;

    @Operation(summary = "Save YouthInitiatives by id ")
    @PostMapping("/save")
    public YouthInitiatives saveYouthInitiativesService(@RequestBody YouthInitiatives youthInitiatives) {
        return youthInitiativesService.saveYouthInitiatives(youthInitiatives);
    }

    @Operation(summary = "Upload files", description = "Upload files to aws")
    @PostMapping("/upload-file/{id}")
    public LinkedHashMap<String, String> uploadFile(@RequestBody MultipartFile firstPhoto,
                                                    @PathVariable Long id) {
        return youthInitiativesService.uploadFile(firstPhoto, id);
    }

    @Operation(summary = "Update YouthInitiatives by id")
    @PatchMapping("/{id}")
    public YouthInitiatives update(@RequestBody YouthInitiatives youthInitiatives,@PathVariable Long id) {
        return youthInitiativesService.update(youthInitiatives,id);
    }

    @Operation(summary = "Delete YouthInitiatives by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveYouthInitiativesService(@PathVariable Long id) {
        return youthInitiativesService.deleteById(id);
    }
}

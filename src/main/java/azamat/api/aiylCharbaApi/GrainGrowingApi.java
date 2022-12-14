package azamat.api.aiylCharbaApi;

import azamat.db.servise.aiylCharba.GrainGrowingService;
import azamat.db.model.entity.aiylCharba.GrainGrowing;
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
@RequestMapping("/api/agriculture/grainGrowing")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "AiylCharba GrainGrowing", description = "crud operations")
public class GrainGrowingApi {

    private GrainGrowingService grainGrowingService;

    @Operation(summary = "Save GrainGrowing by id ")
    @PostMapping("/save")
    public GrainGrowing saveGrainGrowingService(@RequestBody GrainGrowing grainGrowing) {
        return grainGrowingService.saveGrainGraving(grainGrowing);
    }

    @Operation(summary = "Update GrainGrowing by id")
    @PatchMapping("/{id}")
    public GrainGrowing update(@RequestBody GrainGrowing grainGrowing, @PathVariable Long id) {
        return grainGrowingService.update(grainGrowing,id);
    }

    @Operation(summary = "Delete ACEvent by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveGrainGrowingService(@PathVariable Long id) {
        return grainGrowingService.deleteById(id);
    }

    @Operation(summary = "Upload files", description = "Upload files to aws")
    @PostMapping("/upload-file/{id}")
    public LinkedHashMap<String, String> uploadFile(@RequestBody MultipartFile firstPhoto,
                                                    @PathVariable Long id) {
        return grainGrowingService.uploadFile(firstPhoto, id);
    }
}

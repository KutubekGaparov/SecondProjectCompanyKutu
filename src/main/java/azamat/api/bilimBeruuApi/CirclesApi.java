package azamat.api.bilimBeruuApi;

import azamat.db.servise.bilimBeruu.CirclesService;
import azamat.db.model.entity.bilimBeruu.Circles;
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
@RequestMapping("/api/education/circles")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "BilimBeruu Circles", description = "crud operations")
public class CirclesApi {

    private CirclesService circlesService;

    @Operation(summary = "Save Circles by id ")
    @PostMapping("/save")
    public Circles saveCirclesService(@RequestBody Circles circles) {
        return circlesService.saveCircles(circles);
    }

    @Operation(summary = "Upload files", description = "Upload files to aws")
    @PostMapping("/upload-file/{id}")
    public LinkedHashMap<String, String> uploadFile(@RequestBody MultipartFile firstPhoto,
                                                    @PathVariable Long id) {
        return circlesService.uploadFile(firstPhoto, id);
    }
    @Operation(summary = "Update Circles by id")
    @PatchMapping("/{id}")
    public Circles update(@RequestBody Circles circles,@PathVariable Long id) {
        return circlesService.update(circles,id);
    }

    @Operation(summary = "Delete Circles by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveCirclesService(@PathVariable Long id) {
        return circlesService.deleteById(id);
    }



}

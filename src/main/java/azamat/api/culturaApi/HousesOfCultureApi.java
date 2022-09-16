package azamat.api.culturaApi;

import azamat.db.servise.kultura.HousesOfCultureService;
import azamat.db.model.entity.Kultura.HousesOfCulture;
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
@RequestMapping("/api/culture/housesOfCulture")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "Cultura HousesOfCulture", description = "crud operations")
public class HousesOfCultureApi {

    private HousesOfCultureService housesOfCultureService;

    @Operation(summary = "Save HousesOfCulture by id ")
    @PostMapping("/save")
    public HousesOfCulture saveHousesOfCultureService(@RequestBody HousesOfCulture houses) {
        return housesOfCultureService.saveHousesOfCulture(houses);
    }

    @Operation(summary = "Upload files", description = "Upload files to aws")
    @PostMapping("/upload-file/{id}")
    public LinkedHashMap<String, String> uploadFile(@RequestBody MultipartFile firstPhoto,
                                                    @PathVariable Long id) {
        return housesOfCultureService.uploadFile(firstPhoto, id);
    }
    @Operation(summary = "Update HousesOfCulture by id")
    @PatchMapping("/{id}")
    public HousesOfCulture update(@RequestBody HousesOfCulture houses,@PathVariable Long id) {
        return housesOfCultureService.update(houses,id);
    }

    @Operation(summary = "Delete HousesOfCulture by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveHousesOfCultureService(@PathVariable Long id) {
        return housesOfCultureService.deleteById(id);
    }
}

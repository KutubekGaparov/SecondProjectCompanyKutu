package azmat.secondprojectcompany.api.culturaApi;

import azmat.secondprojectcompany.db.servise.kultura.HousesOfCultureService;
import azmat.secondprojectcompany.model.entity.Kultura.HousesOfCulture;
import azmat.secondprojectcompany.model.entity.bilimBeruu.MOEEvent;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/culture/housesOfCulture")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "Cultura", description = "crud operations")
public class HousesOfCultureApi {

    private HousesOfCultureService housesOfCultureService;

    @Operation(summary = "Save HousesOfCulture by id ")
    @PostMapping("/save")
    public HousesOfCulture saveHousesOfCultureService(@RequestBody HousesOfCulture houses) {
        return housesOfCultureService.saveHousesOfCulture(houses);
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

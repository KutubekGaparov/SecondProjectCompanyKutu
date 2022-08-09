package azamat.api.dinApi;

import azamat.db.servise.dinService.PrayerService;
import azamat.model.entity.din.Prayer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/din/prayer")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "Din Prayer", description = "crud operations")
public class PrayerApi {

    private PrayerService prayerService;

    @Operation(summary = "Save Prayer by id ")
    @PostMapping("/save")
    public Prayer savePrayerService(@RequestBody Prayer prayer) {
        return prayerService.savePrayer(prayer);
    }

    @Operation(summary = "Update Prayer by id")
    @PatchMapping("/{id}")
    public Prayer update(@RequestBody Prayer prayer,@PathVariable Long id) {
        return prayerService.update(prayer,id);
    }

    @Operation(summary = "Delete Prayer by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> savePrayerService(@PathVariable Long id) {
        return prayerService.deleteById(id);
    }

}

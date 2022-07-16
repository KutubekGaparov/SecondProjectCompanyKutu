package azamat.api.dinApi;

import azamat.db.servise.dinService.EthicsService;
import azamat.model.entity.din.Ethics;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/din/ethics")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "Din", description = "crud operations")
public class EthicsApi {

    private EthicsService ethicsService;

    @Operation(summary = "Save Ethics by id ")
    @PostMapping("/save")
    public Ethics saveEthicsService(@RequestBody Ethics ethics) {
        return ethicsService.saveEthics(ethics);
    }

    @Operation(summary = "Update Ethics by id")
    @PatchMapping("/{id}")
    public Ethics update(@RequestBody Ethics ethics,@PathVariable Long id) {
        return ethicsService.update(ethics,id);
    }

    @Operation(summary = "Delete Ethics by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveEthicsService(@PathVariable Long id) {
        return ethicsService.deleteById(id);
    }
}

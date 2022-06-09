package azmat.secondprojectcompany.api.bashkyBetApi;

import azmat.secondprojectcompany.db.servise.bashkyBet.KyzmatkerlerService;
import azmat.secondprojectcompany.model.Kyzmatkerler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "BashkyBet", description = "crud operations")
public class KyzmatkerlerApi {

    private KyzmatkerlerService kyzmatkerlerService;

    @Operation(summary = "Save Kyzmatkerler by id ")
    @PostMapping("/save")
    public Kyzmatkerler saveKyzmatkerlerService(@RequestBody Kyzmatkerler kyzmatkerler) {
        return kyzmatkerlerService.saveKyzmatkerler(kyzmatkerler);
    }

    @Operation(summary = "Update Kyzmatkerler by id")
    @PatchMapping("/{id}")
    public Kyzmatkerler update(@RequestBody Kyzmatkerler kyzmatkerler,@PathVariable Long id) {
        return kyzmatkerlerService.update(kyzmatkerler,id);
    }

    @Operation(summary = "Delete Kyzmatkerler by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveKyzmatkerlerService(@PathVariable Long id) {
        return kyzmatkerlerService.deleteById(id);
    }
}

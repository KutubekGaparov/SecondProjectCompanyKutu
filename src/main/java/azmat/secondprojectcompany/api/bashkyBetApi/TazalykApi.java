package azmat.secondprojectcompany.api.bashkyBetApi;

import azmat.secondprojectcompany.db.servise.bashkyBet.TazalykService;
import azmat.secondprojectcompany.model.Tazalyk;
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
public class TazalykApi {

    private TazalykService tazalykService;

    @Operation(summary = "Save Tazalyk by id ")
    @PostMapping("/save")
    public Tazalyk saveTazalykService(@RequestBody Tazalyk tazalyk) {
        return tazalykService.saveTazalyk(tazalyk);
    }

    @Operation(summary = "Update Tazalyk by id")
    @PatchMapping("/{id}")
    public Tazalyk update(@RequestBody Tazalyk tazalyk,@PathVariable Long id) {
        return tazalykService.update(tazalyk,id);
    }

    @Operation(summary = "Delete Tazalyk by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveTazalykService(@PathVariable Long id) {
        return tazalykService.deleteById(id);
    }
}

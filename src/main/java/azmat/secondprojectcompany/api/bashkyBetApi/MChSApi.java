package azmat.secondprojectcompany.api.bashkyBetApi;

import azmat.secondprojectcompany.db.servise.bashkyBet.MChSService;
import azmat.secondprojectcompany.model.MChS;
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
public class MChSApi {

    private MChSService mChSService;

    @Operation(summary = "Save MChS by id ")
    @PostMapping("/save")
    public MChS saveMChSService(@RequestBody MChS mChS) {
        return mChSService.saveEvent(mChS);
    }

    @Operation(summary = "Update MChS by id")
    @PatchMapping("/{id}")
    public MChS update(@RequestBody MChS mChS,@PathVariable Long id) {
        return mChSService.update(mChS,id);
    }

    @Operation(summary = "Delete MChS by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveMChSService(@PathVariable Long id) {
        return mChSService.deleteById(id);
    }
}

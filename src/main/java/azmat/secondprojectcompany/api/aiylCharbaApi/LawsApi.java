package azmat.secondprojectcompany.api.aiylCharbaApi;

import azmat.secondprojectcompany.db.servise.aiylCharba.LawsService;
import azmat.secondprojectcompany.model.entity.aiylCharba.Laws;
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
@Tag(name = "AiylCharba", description = "crud operations")
public class LawsApi {

    private LawsService lawsService;

    @Operation(summary = "Save Laws by id ")
    @PostMapping("/save")
    public Laws saveLawsService(@RequestBody Laws laws) {
        return lawsService.saveLaws(laws);
    }

    @Operation(summary = "Update Laws by id")
    @PatchMapping("/{id}")
    public Laws update(@RequestBody Laws laws,@PathVariable Long id) {
        return lawsService.update(laws,id);
    }

    @Operation(summary = "Delete Laws by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveLawsService(@PathVariable Long id) {
        return lawsService.deleteById(id);
    }
}

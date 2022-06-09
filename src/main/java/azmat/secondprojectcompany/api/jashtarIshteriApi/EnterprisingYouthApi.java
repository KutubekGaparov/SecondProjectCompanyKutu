package azmat.secondprojectcompany.api.jashtarIshteriApi;

import azmat.secondprojectcompany.db.servise.jashtarIshteri.EnterprisingYouthService;
import azmat.secondprojectcompany.model.entity.din.Ait;
import azmat.secondprojectcompany.model.entity.jashtarIshteri.EnterprisingYouth;
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
@Tag(name = "JashtarIshteri", description = "crud operations")
public class EnterprisingYouthApi {

    private EnterprisingYouthService youthService;

    @Operation(summary = "Save EnterprisingYouth by id ")
    @PostMapping("/save")
    public EnterprisingYouth saveEnterprisingYouthService(@RequestBody EnterprisingYouth enterprisingYouth) {
        return youthService.saveEnterprisingYouth(enterprisingYouth);
    }

    @Operation(summary = "Update EnterprisingYouth by id")
    @PatchMapping("/{id}")
    public EnterprisingYouth update(@RequestBody EnterprisingYouth enterprisingYouth,@PathVariable Long id) {
        return youthService.update(enterprisingYouth,id);
    }

    @Operation(summary = "Delete EnterprisingYouth by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveEnterprisingYouthService(@PathVariable Long id) {
        return youthService.deleteById(id);
    }
}

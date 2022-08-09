package azamat.api.bilimBeruuApi;

import azamat.db.servise.bilimBeruu.SchoolsService;
import azamat.model.entity.bilimBeruu.Schools;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/education/schools")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "BilimBeruu Schools", description = "crud operations")
public class SchoolsApi {

    private SchoolsService schoolsService;

    @Operation(summary = "Save Schools by id ")
    @PostMapping("/save")
    public Schools saveSchoolsService(@RequestBody Schools schools) {
        return schoolsService.saveSchools(schools);
    }

    @Operation(summary = "Update Schools by id")
    @PatchMapping("/{id}")
    public Schools update(@RequestBody Schools schools,@PathVariable Long id) {
        return schoolsService.update(schools,id);
    }

    @Operation(summary = "Delete Schools by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveSchoolsService(@PathVariable Long id) {
        return schoolsService.deleteById(id);
    }
}

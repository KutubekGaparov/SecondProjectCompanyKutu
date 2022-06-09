package azmat.secondprojectcompany.api.dinApi;

import azmat.secondprojectcompany.db.servise.dinService.ReligionSchoolService;
import azmat.secondprojectcompany.model.entity.bilimBeruu.Schools;
import azmat.secondprojectcompany.model.entity.din.ReligionSchool;
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
@Tag(name = "Din", description = "crud operations")
public class ReligionSchoolApi {

    private ReligionSchoolService religionSchoolService;

    @Operation(summary = "Save ReligionSchool by id ")
    @PostMapping("/save")
    public ReligionSchool saveReligionSchoolService(@RequestBody ReligionSchool religionSchool) {
        return religionSchoolService.saveReligionSchool(religionSchool);
    }

    @Operation(summary = "Update ReligionSchool by id")
    @PatchMapping("/{id}")
    public ReligionSchool update(@RequestBody ReligionSchool religionSchool,@PathVariable Long id) {
        return religionSchoolService.update(religionSchool,id);
    }

    @Operation(summary = "Delete ReligionSchool by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveReligionSchoolService(@PathVariable Long id) {
        return religionSchoolService.deleteById(id);
    }
}

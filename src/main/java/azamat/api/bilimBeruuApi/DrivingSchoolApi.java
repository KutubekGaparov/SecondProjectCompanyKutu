package azamat.api.bilimBeruuApi;

import azamat.db.servise.bilimBeruu.DrivingSchoolService;
import azamat.db.model.entity.bilimBeruu.DrivingSchool;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/education/drivingSchool")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "BilimBeruu DrivingSchool", description = "crud operations")
public class DrivingSchoolApi {

    private DrivingSchoolService drivingSchoolService;

    @Operation(summary = "Save DrivingSchool by id ")
    @PostMapping("/save")
    public DrivingSchool saveDrivingSchoolService(@RequestBody DrivingSchool drivingSchool) {
        return drivingSchoolService.saveDrivingSchool(drivingSchool);
    }

    @Operation(summary = "Update DrivingSchool by id")
    @PatchMapping("/{id}")
    public DrivingSchool update(@RequestBody DrivingSchool drivingSchool,@PathVariable Long id) {
        return drivingSchoolService.update(drivingSchool,id);
    }

    @Operation(summary = "Delete DrivingSchool by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveDrivingSchoolService(@PathVariable Long id) {
        return drivingSchoolService.deleteById(id);
    }
    @Operation(summary = "Upload files", description = "Upload files to aws")
    @PostMapping("/upload-file/{id}")
    public LinkedHashMap<String, String> uploadFile(@RequestBody MultipartFile firstPhoto,
                                                    @PathVariable Long id) {
        return drivingSchoolService.uploadFile(firstPhoto, id);
    }
}

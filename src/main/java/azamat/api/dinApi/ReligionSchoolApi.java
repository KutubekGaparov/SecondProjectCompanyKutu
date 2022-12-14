package azamat.api.dinApi;

import azamat.db.servise.dinService.ReligionSchoolService;
import azamat.db.model.entity.din.ReligionSchool;
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
@RequestMapping("/api/din/religionSchool")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "Din ReligionSchool", description = "crud operations")
public class ReligionSchoolApi {

    private ReligionSchoolService religionSchoolService;

    @Operation(summary = "Save ReligionSchool by id ")
    @PostMapping("/save")
    public ReligionSchool saveReligionSchoolService(@RequestBody ReligionSchool religionSchool) {
        return religionSchoolService.saveReligionSchool(religionSchool);
    }

    @Operation(summary = "Upload files", description = "Upload files to aws")
    @PostMapping("/upload-file/{id}")
    public LinkedHashMap<String, String> uploadFile(@RequestBody MultipartFile firstPhoto,
                                                    @PathVariable Long id) {
        return religionSchoolService.uploadFile(firstPhoto, id);
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

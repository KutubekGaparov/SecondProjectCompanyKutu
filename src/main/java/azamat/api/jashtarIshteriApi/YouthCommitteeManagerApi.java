package azamat.api.jashtarIshteriApi;

import azamat.db.servise.jashtarIshteri.YouthCommitteeManagerService;
import azamat.db.model.entity.jashtarIshteri.YouthCommitteeManager;
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
@RequestMapping("/api/youthAffairs/YouthCommitteeManager")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "JashtarIshteri YouthCommitteeManager", description = "crud operations")
public class YouthCommitteeManagerApi {

    private YouthCommitteeManagerService youthCommitteeManagerService;

    @Operation(summary = "Save YouthCommitteeManager by id ")
    @PostMapping("/save")
    public YouthCommitteeManager saveYouthCommitteeManagerService(@RequestBody YouthCommitteeManager committeeManager) {
        return youthCommitteeManagerService.saveYouthCommitteeManager(committeeManager);
    }

    @Operation(summary = "Upload files", description = "Upload files to aws")
    @PostMapping("/upload-file/{id}")
    public LinkedHashMap<String, String> uploadFile(@RequestBody MultipartFile firstPhoto,
                                                    @PathVariable Long id) {
        return youthCommitteeManagerService.uploadFile(firstPhoto, id);
    }

    @Operation(summary = "Update YouthCommitteeManager by id")
    @PatchMapping("/{id}")
    public YouthCommitteeManager update(@RequestBody YouthCommitteeManager committeeManager,@PathVariable Long id) {
        return youthCommitteeManagerService.update(committeeManager,id);
    }

    @Operation(summary = "Delete YouthCommitteeManager by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveYouthCommitteeManagerYouthInitiativesService(@PathVariable Long id) {
        return youthCommitteeManagerService.deleteById(id);
    }
}

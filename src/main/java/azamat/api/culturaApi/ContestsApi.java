package azamat.api.culturaApi;

import azamat.db.servise.kultura.ContestsService;
import azamat.db.model.entity.Kultura.Contests;
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
@RequestMapping("/api/culture/contests")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "Cultura Contests", description = "crud operations")
public class ContestsApi {

    private ContestsService contestsService;

    @Operation(summary = "Save Contests by id ")
    @PostMapping("/save")
    public Contests saveContestsService(@RequestBody Contests contests) {
        return contestsService.saveContests(contests);
    }
    @Operation(summary = "Upload files", description = "Upload files to aws")
    @PostMapping("/upload-file/{id}")
    public LinkedHashMap<String, String> uploadFile(@RequestBody MultipartFile firstPhoto,
                                                    @PathVariable Long id) {
        return contestsService.uploadFile(firstPhoto, id);
    }

    @Operation(summary = "Update Contests by id")
    @PatchMapping("/{id}")
    public Contests update(@RequestBody Contests contests,@PathVariable Long id) {
        return contestsService.update(contests,id);
    }

    @Operation(summary = "Delete Contests by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveContestsService(@PathVariable Long id) {
        return contestsService.deleteById(id);
    }
}

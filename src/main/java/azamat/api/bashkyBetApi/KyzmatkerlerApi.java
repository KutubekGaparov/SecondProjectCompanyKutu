package azamat.api.bashkyBetApi;

import azamat.db.servise.bashkyBet.KyzmatkerlerService;
import azamat.db.model.Kyzmatkerler;
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
@RequestMapping("/api/homePage/employees")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "BashkyBet Kyzmatkerler", description = "crud operations")
public class KyzmatkerlerApi {

    private KyzmatkerlerService kyzmatkerlerService;

    @Operation(summary = "Save Kyzmatkerler by id ")
    @PostMapping("/save")
    public Kyzmatkerler saveKyzmatkerlerService(@RequestBody Kyzmatkerler kyzmatkerler) {
        return kyzmatkerlerService.saveKyzmatkerler(kyzmatkerler);
    }

    @Operation(summary = "Update Kyzmatkerler by id")
    @PatchMapping("/{id}")
    public Kyzmatkerler update(@RequestBody Kyzmatkerler kyzmatkerler,@PathVariable Long id) {
        return kyzmatkerlerService.update(kyzmatkerler,id);
    }

    @Operation(summary = "Delete Kyzmatkerler by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveKyzmatkerlerService(@PathVariable Long id) {
        return kyzmatkerlerService.deleteById(id);
    }
    @Operation(summary = "Upload files", description = "Upload files to aws")
    @PostMapping("/upload-file/{id}")
    public LinkedHashMap<String, String> uploadFile(@RequestBody MultipartFile firstPhoto,
                                                    @PathVariable Long id) {
        return kyzmatkerlerService.uploadFile(firstPhoto, id);
    }
}

package azamat.api.bashkyBetApi;

import azamat.db.model.MChS;
import azamat.db.servise.bashkyBet.MChSService;
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
@RequestMapping("/api/homePage/mChs")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "BashkyBet MChS", description = "crud operations")
public class MChSApi {

    private MChSService mChSService;

    @Operation(summary = "Save MChS by id ")
    @PostMapping("/save")
    public MChS saveMChSService(@RequestBody MChS mChS) {
        return mChSService.saveEvent(mChS);
    }

    @Operation(summary = "Upload files", description = "Upload files to aws")
    @PostMapping("/upload-file/{id}")
    public LinkedHashMap<String, String> uploadFile(@RequestBody MultipartFile firstPhoto,
                                                    @PathVariable Long id) {
        return mChSService.uploadFile(firstPhoto, id);
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

package azamat.api.aiylCharbaApi;

import azamat.db.servise.aiylCharba.TipsService;
import azamat.db.model.entity.aiylCharba.Tips;
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
@RequestMapping("/api/agriculture/tips")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "AiylCharba Tips", description = "crud operations")
public class TipsApi {

    private TipsService tipsService;

    @Operation(summary = "Save Tips by id ")
    @PostMapping("/save")
    public Tips saveTipsService(@RequestBody Tips tips) {
        return tipsService.saveTips(tips);
    }

    @Operation(summary = "Upload files", description = "Upload files to aws")
    @PostMapping("/upload-file/{id}")
    public LinkedHashMap<String, String> uploadFile(@RequestBody MultipartFile firstPhoto,
                                                    @PathVariable Long id) {
        return tipsService.uploadFile(firstPhoto, id);
    }
    @Operation(summary = "Update Tips by id")
    @PatchMapping("/{id}")
    public Tips update(@RequestBody Tips tips,@PathVariable Long id) {
        return tipsService.update(tips,id);
    }

    @Operation(summary = "Delete Tips by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveTipsService(@PathVariable Long id) {
        return tipsService.deleteById(id);
    }
}

package azamat.api.jashtarIshteriApi;

import azamat.db.servise.jashtarIshteri.OfferForYouthService;
import azamat.db.model.entity.jashtarIshteri.OfferForYouth;
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
@RequestMapping("/api/youthAffairs/offerForYouth")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "JashtarIshteri OfferForYouth", description = "crud operations")
public class OfferForYouthApi {

    private OfferForYouthService offerForYouthService;

    @Operation(summary = "Save OfferForYouth by id ")
    @PostMapping("/save")
    public OfferForYouth saveOfferForYouthService(@RequestBody OfferForYouth offerForYouth) {
        return offerForYouthService.saveOfferForYouth(offerForYouth);
    }

    @Operation(summary = "Upload files", description = "Upload files to aws")
    @PostMapping("/upload-file/{id}")
    public LinkedHashMap<String, String> uploadFile(@RequestBody MultipartFile firstPhoto,
                                                    @PathVariable Long id) {
        return offerForYouthService.uploadFile(firstPhoto, id);
    }

    @Operation(summary = "Update OfferForYouth by id")
    @PatchMapping("/{id}")
    public OfferForYouth update(@RequestBody OfferForYouth offerForYouth,@PathVariable Long id) {
        return offerForYouthService.update(offerForYouth,id);
    }

    @Operation(summary = "Delete OfferForYouth by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveOfferForYouthService(@PathVariable Long id) {
        return offerForYouthService.deleteById(id);
    }
}

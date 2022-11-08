package azamat.api.aiylCharbaApi;

import azamat.db.servise.aiylCharba.AnimalHusbandryService;
import azamat.db.model.entity.aiylCharba.AnimalHusbandry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/agriculture/animalHusbandry")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "AiylCharba AnimalHusbandry", description = "crud operations")
public class AnimalHusbandryApi {

    private AnimalHusbandryService animalHusbandryService;

    @Operation(summary = "Save AnimalHusbandry by id ")
    @PostMapping("/save")
    public AnimalHusbandry saveAnimalHusbandryService(@RequestBody AnimalHusbandry animalHusbandry) {
        return animalHusbandryService.saveAsEvent(animalHusbandry);
    }

    @Operation(summary = "Update ACEvent by id")
    @PatchMapping("/{id}")
    public AnimalHusbandry update(@RequestBody AnimalHusbandry animalHusbandry, @PathVariable Long id) {
        return animalHusbandryService.update(animalHusbandry,id);
    }

    @Operation(summary = "Delete ACEvent by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveAnimalHusbandryService(@PathVariable Long id) {
        return animalHusbandryService.deleteById(id);
    }

    @Operation(summary = "Upload files", description = "Upload files to aws")
    @PostMapping("/upload-file/{id}")
    public LinkedHashMap<String, String> uploadFile(@RequestBody MultipartFile firstPhoto,
                                                    @PathVariable Long id) {
        return animalHusbandryService.uploadFile(firstPhoto, id);
    }
}

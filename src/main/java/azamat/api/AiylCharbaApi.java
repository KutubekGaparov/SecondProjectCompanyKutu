package azamat.api;

import azamat.db.model.entity.aiylCharba.*;
import azamat.db.servise.aiylCharba.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/agriculture")
@AllArgsConstructor
@Tag(name = "AiylCharba Client GetApi")
public class AiylCharbaApi {

    private ACEventService acEventService;
    private AnimalHusbandryService animalHusbandryService;
    private GrainGrowingService grainGrowingService;
    private LawsService lawsService;
    private PastureServise pastureServise;
    private TipsService tipsService;

    @Operation(summary = "Get all ACEvent")
    @GetMapping("/acEvent")
    public List<ACEvent> getAllAcEvent() {
        return acEventService.getAll();
    }

    @Operation(summary = "Get all animal husbandry")
    @GetMapping("/animalHusbandry")
    public List<AnimalHusbandry> getAll() {
        return animalHusbandryService.getAll();
    }

    @Operation(summary = "Get all grainGrowing")
    @GetMapping("/grainGrowing")
    public List<GrainGrowing> getAllGrainGrowing() {
        return grainGrowingService.getAll();
    }

    @Operation(summary = "Get all grainGrowing")
    @GetMapping("/laws")
    public List<Laws> getAllLaws() {
        return lawsService.getAll();
    }

    @Operation(summary = "Get all grainGrowing")
    @GetMapping("/pasture")
    public List<Pasture> getAllPasture(){
        return pastureServise.getAll();
    }

    @Operation(summary = "Get all grainGrowing")
    @GetMapping("/tips")
    public List<Tips> getAllTips() {
        return tipsService.getAll();
    }
}

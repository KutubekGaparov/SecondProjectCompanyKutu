package azamat.api;

import azamat.db.servise.kultura.*;
import azamat.model.entity.Kultura.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/agriculture/acEvent")
@AllArgsConstructor
@Tag(name = "Cultura GetApi")
public class CulturaApi {

    private ContestsService contestsService;
    private CulturalFiguresService culturalFiguresService;
    private CultureEventsService cultureEventsService;
    private HousesOfCultureService housesOfCultureService;
    private MuseumsService museumsService;

    @Operation(summary = "Get all contests")
    @GetMapping("/contests")
    public List<Contests> getAllContests() {
        return contestsService.getAll();
    }

    @Operation(summary = "Get all culturalFigures")
    @GetMapping("/culturalFigures")
    public List<CulturalFigures> getAllCulturalFigures() {
        return culturalFiguresService.getAll();
    }

    @Operation(summary = "Get all CultureEvents")
    @GetMapping("/cultureEvents")
    public List<CultureEvents> getAllCultureEvents() {
        return cultureEventsService.getAll();
    }

    @Operation(summary = "Get all housesOfCultures")
    @GetMapping("/housesOfCultures")
    public List<HousesOfCulture> getAllHousesOfCulture() {
        return housesOfCultureService.getAll();
    }

    @Operation(summary = "Get all museums")
    @GetMapping("/museums")
    public List<Museums> getAllMoeEvent() {
        return museumsService.getAll();
    }

}

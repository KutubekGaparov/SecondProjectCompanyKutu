package azamat.api;

import azamat.db.servise.bilimBeruu.*;
import azamat.model.entity.bilimBeruu.*;
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
@Tag(name = "BilimBeruu GetApi")
public class BilimBeruuApi {

    private MOEEventService moeEventService;
    private CirclesService circlesService;
    private DrivingSchoolService drivingSchoolService;
    private KindergartensService kindergartensService;
    private OlympiansService olympiansService;
    private ORTService ortService;
    private SchoolsService schoolsService;

    @Operation(summary = "Get all moeEvent")
    @GetMapping("/moeEvent")
    public List<MOEEvent> getAllMoeEvent() {
        return moeEventService.getAll();
    }

    @Operation(summary = "Get all circles")
    @GetMapping("/circles")
    public List<Circles> getAllCircles() {
        return circlesService.getAll();
    }

    @Operation(summary = "Get all drivingSchool")
    @GetMapping("/drivingSchool")
    public List<DrivingSchool> getAllDrivingSchool() {
        return drivingSchoolService.getAll();
    }

    @Operation(summary = "Get all kindergartens")
    @GetMapping("/kindergartens")
    public List<Kindergartens> getAllKindergartens() {
        return kindergartensService.getAll();
    }

    @Operation(summary = "Get all olympians")
    @GetMapping("/olympians")
    public List<Olympians> getAllOlympians() {
        return olympiansService.getAll();
    }

    @Operation(summary = "Get all ORT")
    @GetMapping("/ort")
    public List<ORT> getAllORT() {
        return ortService.getAll();
    }

    @Operation(summary = "Get all schools")
    @GetMapping("/schools")
    public List<Schools> getAllSchools() {
        return schoolsService.getAll();
    }

}

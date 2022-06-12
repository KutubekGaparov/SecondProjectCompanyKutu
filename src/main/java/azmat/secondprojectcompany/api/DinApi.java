package azmat.secondprojectcompany.api;

import azmat.secondprojectcompany.db.servise.dinService.*;
import azmat.secondprojectcompany.model.entity.Kultura.Museums;
import azmat.secondprojectcompany.model.entity.din.*;
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
@Tag(name = "Din GetApi")
public class DinApi {

    private AitService aitService;
    private DEventService dEventService;
    private EthicsService ethicsService;
    private HadjService hadjService;
    private MechitterService mechitterService;
    private PrayerService prayerService;
    private RamazanService ramazanService;
    private ReligionSchoolService religionSchoolService;


    @Operation(summary = "Get all Ait")
    @GetMapping("/ait")
    public List<Ait> getAllAit() {
        return aitService.getAll();
    }

    @Operation(summary = "Get all dEvent")
    @GetMapping("/dEvent")
    public List<DEvents> getAllDEvent() {
        return dEventService.getAll();
    }

    @Operation(summary = "Get all Ethics")
    @GetMapping("/ethics")
    public List<Ethics> getAllEthics() {
        return ethicsService.getAll();
    }

    @Operation(summary = "Get all hadj")
    @GetMapping("/hadj")
    public List<Hadj> getAllHadj() {
        return hadjService.getAll();
    }

    @Operation(summary = "Get all mechitter")
    @GetMapping("/mechitter")
    public List<Mechitter> getAllMechitter() {
        return mechitterService.getAll();
    }

    @Operation(summary = "Get all prayer")
    @GetMapping("/prayer")
    public List<Prayer> getAllPrayer() {
        return prayerService.getAll();
    }

    @Operation(summary = "Get all ramazan")
    @GetMapping("/ramazan")
    public List<Ramazan> getAllRamazan() {
        return ramazanService.getAll();
    }

    @Operation(summary = "Get all religionSchool")
    @GetMapping("/religionSchool")
    public List<ReligionSchool> getAllReligionSchool() {
        return religionSchoolService.getAll();
    }


}

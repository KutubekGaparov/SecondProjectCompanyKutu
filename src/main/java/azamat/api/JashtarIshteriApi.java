package azamat.api;

import azamat.db.servise.jashtarIshteri.*;
import azamat.model.entity.jashtarIshteri.*;
import azamat.secondprojectcompany.model.entity.jashtarIshteri.*;
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
@Tag(name = "JashtarIshteri GetApi")
public class JashtarIshteriApi {
    private EnterprisingYouthService enterprisingYouthService;
    private OfferForYouthService offerForYouthService;
    private SportsEventsService sportsEventsService;
    private YouthCommitteeManagerService youthCommitteeManagerService;
    private YouthInitiativesService youthInitiativesService;

    @Operation(summary = "Get all enterprisingYouth")
    @GetMapping("/enterprisingYouth")
    public List<EnterprisingYouth> getAllEnter() {
        return enterprisingYouthService.getAll();
    }

    @Operation(summary = "Get all offerForYouth")
    @GetMapping("/offerForYouth")
    public List<OfferForYouth> getAllOfferForYouth() {
        return offerForYouthService.getAll();
    }

    @Operation(summary = "Get all sportsEvents")
    @GetMapping("/sportsEvents")
    public List<SportsEvents> getAllSportsEvents() {
        return sportsEventsService.getAll();
    }

    @Operation(summary = "Get all youthCommitteeManager")
    @GetMapping("/youthCommitteeManager")
    public List<YouthCommitteeManager> getAllYouthCommitteeManager() {
        return youthCommitteeManagerService.getAll();
    }

    @Operation(summary = "Get all youthInitiatives")
    @GetMapping("/youthInitiatives")
    public List<YouthInitiatives> getAllYouthInitiatives() {
        return youthInitiativesService.getAll();
    }


}

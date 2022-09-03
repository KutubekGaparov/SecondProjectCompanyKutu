package azamat.api;

import azamat.db.servise.bashkyBet.NewsAnnouncementService;
import azamat.db.servise.bashkyBet.TazalykService;
import azamat.db.model.Kyzmatkerler;
import azamat.db.model.MChS;
import azamat.db.model.NewsAnnouncement;
import azamat.db.model.Tazalyk;
import azamat.db.servise.bashkyBet.KyzmatkerlerService;
import azamat.db.servise.bashkyBet.MChSService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/agriculture/acEvent")
@AllArgsConstructor
@Tag(name = "BashkyBet Client GetApi")
public class BashkyBetApi {

    private KyzmatkerlerService kyzmatkerlerService;
    private MChSService mChSService;
    private NewsAnnouncementService newsAnnouncementService;
    private TazalykService tazalykService;

    @Operation(summary = "Get all employees")
    @GetMapping("/employees")
    public List<Kyzmatkerler> getAllKyzmatkerler() {
        return kyzmatkerlerService.getAll();
    }

    @Operation(summary = "Get all MChS")
    @GetMapping("/mchs")
    public List<MChS> getAllMChs() {
        return mChSService.getAll();
    }

    @Operation(summary = "Get all newsAnnouncement")
    @GetMapping("/newsAnnouncement")
    public List<NewsAnnouncement> getAll() {
        return newsAnnouncementService.getAll();
    }

    @Operation(summary = "Get all Cleanliness")
    @GetMapping("/cleanliness")
    public List<Tazalyk> getAllCleanliness() {
        return tazalykService.getAll();
    }
}

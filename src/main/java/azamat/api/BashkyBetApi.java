package azamat.api;

import azamat.FileInformation.CountOfPage;
import azamat.db.model.*;
import azamat.db.servise.bashkyBet.*;
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
    private AtaktuularService ataktuularService;

    @Operation(summary = "Get all employees")
    @GetMapping("/employees")
    public List<Kyzmatkerler> getAllKyzmatkerler() {
        return kyzmatkerlerService.getAll();
    }
    @Operation(summary = "Get all Ataktuular")
    @GetMapping("/celebrities")
    public List<Ataktuular> getAllAtaktuular() {
        return ataktuularService.getAll();
    }

    @Operation(summary = "Get all MChS")
    @GetMapping("/mchs")
    public List<MChS> getAllMChs() {
        return mChSService.getAll();
    }

    @Operation(summary = "Get all newsOfTheWorldAnnouncement")
    @GetMapping("/newsOfTheWorldAnnouncement/{offset}")
    public List<NewsAnnouncement> getAll(@PathVariable Integer offset) {
        return newsAnnouncementService.getAllNewsOfTheWorld(--offset,8);
    }
    @Operation(summary = "Get count of page")
    @GetMapping("/count-page")
    public CountOfPage getAllCount() {
        return newsAnnouncementService.getCountOfPage();
    }

    @Operation(summary = "Get all stateNewsAnnouncement")
    @GetMapping("/stateNewsAnnouncement/{offset}")
    public List<NewsAnnouncement> getAllStateNews(@PathVariable Integer offset) {
        return newsAnnouncementService.getAllStateNews(--offset,8);
    }

    @Operation(summary = "Get all Cleanliness")
    @GetMapping("/cleanliness")
    public List<Tazalyk> getAllCleanliness() {
        return tazalykService.getAll();
    }
}

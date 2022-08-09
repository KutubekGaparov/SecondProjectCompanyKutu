package azamat.api.bashkyBetApi;

import azamat.db.servise.bashkyBet.NewsAnnouncementService;
import azamat.model.NewsAnnouncement;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/homePage/newsAnnouncement")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Tag(name = "BashkyBet NewsAnnouncement", description = "crud operations")
public class NewsAnnouncementApi {

    private NewsAnnouncementService announcementService;

    @Operation(summary = "Save NewsAnnouncement by id ")
    @PostMapping("/save")
    public NewsAnnouncement saveNewsAnnouncementService(@RequestBody NewsAnnouncement newsAnnouncement) {
        return announcementService.saveNewsAnnouncement(newsAnnouncement);
    }

    @Operation(summary = "Update NewsAnnouncement by id")
    @PatchMapping("/{id}")
    public NewsAnnouncement update(@RequestBody NewsAnnouncement newsAnnouncement,@PathVariable Long id) {
        return announcementService.update(newsAnnouncement,id);
    }

    @Operation(summary = "Delete BEEvent by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> saveNewsAnnouncementService(@PathVariable Long id) {
        return announcementService.deleteById(id);
    }
}

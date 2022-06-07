package azmat.secondprojectcompany.api;

import azmat.secondprojectcompany.db.servise.aiylCharba.*;
import azmat.secondprojectcompany.model.entity.aiylCharba.ACEvent;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
@AllArgsConstructor
@Tag(name = "AiylCharba", description = "crud operations")
public class AiylCharbaApi {

    private ACEventService acEventService;

    @Operation(summary = "Get")
    @PostMapping("/getAll")
    public List<ACEvent> getAll() {
        return acEventService.getAll();
    }

}

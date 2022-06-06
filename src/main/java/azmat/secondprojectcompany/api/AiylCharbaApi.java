package azmat.secondprojectcompany.api;

import azmat.secondprojectcompany.db.servise.aiylCharba.AiylCharbaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
@AllArgsConstructor
@Tag(name = "AiylCharba", description = "crud operations")
public class AiylCharbaApi {

    private final AiylCharbaService aiylCharbaService;

    @Operation(summary = "Get")
    @GetMapping("/save")
    public String get() {
        return "aiylCharbaService.save()";
    }

}

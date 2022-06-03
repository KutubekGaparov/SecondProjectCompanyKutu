package azmat.secondprojectcompany.api;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@PreAuthorize("hasRole('ROLE_VENDOR')")
@AllArgsConstructor
public class Api {

    @Operation(summary = "Get")
    @GetMapping("/get")
    public String get() {
        return "Hello world";
    }
}

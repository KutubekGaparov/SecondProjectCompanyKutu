package azamat.api;

import azamat.config.security.jwt.JwtUtils;
import azamat.config.security.model.JwtResponse;
import azamat.config.security.model.LoginRequest;
import azamat.config.services.S3Service;
import azamat.config.services.UserDetailsImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
@AllArgsConstructor
@Tag(name = " AuthController ", description = " jwt token, and delete file s3")
public class AuthApi {

    AuthenticationManager authenticationManager;
    JwtUtils jwtUtils;
    S3Service service;

    @Operation(summary = "Sign in", description = "Signing in for all users: admin, client, vendor")
    @PostMapping("/sign-in/auth")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt, roles, loginRequest.getEmail()));
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @Operation(summary = "Delete files", description = "Delete files with key name")
    @PostMapping("/delete-file/{keyName}")
    public ResponseEntity<?> deleteFile(@PathVariable String keyName) {
        service.deleteFile(keyName);
        return ResponseEntity.ok("File successfully deleted");
    }
}

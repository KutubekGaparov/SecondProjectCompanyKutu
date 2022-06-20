package azmat.secondprojectcompany;

import azmat.secondprojectcompany.config.model.ERole;
import azmat.secondprojectcompany.config.model.Role;
import azmat.secondprojectcompany.config.model.User;
import azmat.secondprojectcompany.db.repository.RoleRepository;
import azmat.secondprojectcompany.db.repository.UserRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@RestController
@SpringBootApplication
@OpenAPIDefinition
@AllArgsConstructor
public class SecondProjectCompanyApplication {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public static void main(String[] args) {
        SpringApplication.run(SecondProjectCompanyApplication.class, args);
        System.out.println("Hello world");
    }
    @GetMapping("/")
    public String greetingPage(){
        return "<h1>Welcome to Mady application!!!<h1/>";
    }

    @PostConstruct
    public void init() {
        Role client = new Role();
        client.setId(1L);
        client.setName(ERole.ROLE_ADMIN);
        Role vendor = new Role();
        vendor.setId(2L);
        vendor.setName(ERole.ROLE_VENDOR);
        Role admin = new Role();
        admin.setId(3L);
        admin.setName(ERole.ROLE_CLIENT);
        roleRepository.save(client);
        roleRepository.save(vendor);
        roleRepository.save(admin);

        User c = new User();
        c.setEmail("admin@gmail.com");
        c.setFullName("Admin");
        c.setPassword(encoder.encode("admin"));
        c.setRole(roleRepository.getByIdRole(1L));
        userRepository.save(c);

        User v = new User();
        v.setEmail("vendor@gmail.com");
        v.setFullName("Vendor");
        v.setPassword(encoder.encode("vendor"));
        v.setRole(roleRepository.getByIdRole(2L));

        userRepository.save(v);

        User a = new User();
        a.setEmail("client@gmail.com");
        a.setFullName("Client");
        a.setPassword(encoder.encode("client"));
        a.setRole(roleRepository.getByIdRole(3L));

        userRepository.save(a);
    }
}
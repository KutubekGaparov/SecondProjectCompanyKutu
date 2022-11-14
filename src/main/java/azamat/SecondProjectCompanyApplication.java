package azamat;

import azamat.config.security.model.ERole;
import azamat.config.security.model.Role;
import azamat.config.security.model.User;
import azamat.db.repository.RoleRepository;
import azamat.db.repository.UserRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.PostConstruct;

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
        return " Welcome to Mady application!!! ";
    }

//    @PostConstruct
    public void init() {
        Role admin = new Role();
        admin.setId(1L);
        admin.setName(ERole.ROLE_ADMIN);

        Role client = new Role();
        client.setId(2L);
        client.setName(ERole.ROLE_CLIENT);

        roleRepository.save(client);
        roleRepository.save(admin);

        User c = new User();
        c.setEmail("admin@gmail.com");
        c.setFullName("Admin");
        c.setPassword(encoder.encode("admin"));
        c.setRole(roleRepository.getByIdRole(1L));
        userRepository.save(c);

        User a = new User();
        a.setEmail("client@gmail.com");
        a.setFullName("Client");
        a.setPassword(encoder.encode("client"));
        a.setRole(roleRepository.getByIdRole(2L));

        userRepository.save(a);
    }

}
package se.sara.javaproject4springapp.initializer;

import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se.sara.javaproject4springapp.model.ApplicationUser;
import se.sara.javaproject4springapp.repository.ApplicationUserRepository;

@Component
public class DataInitializer {

    private final ApplicationUserRepository applicationUserRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(ApplicationUserRepository applicationUserRepository, PasswordEncoder passwordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @PostConstruct
    public void init() {
        if (applicationUserRepository.count() == 0) {
            applicationUserRepository.save(new ApplicationUser("admin", passwordEncoder.encode ("admin123"), "ADMIN"));
            applicationUserRepository.save(new ApplicationUser("user", passwordEncoder.encode ("user123"), "USER"));
            applicationUserRepository.save(new ApplicationUser("manager", passwordEncoder.encode ("manager123"), "MANAGER"));
        }
    }
}

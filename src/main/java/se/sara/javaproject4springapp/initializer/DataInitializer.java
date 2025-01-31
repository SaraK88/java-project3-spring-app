package se.sara.javaproject4springapp.initializer;

import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se.sara.javaproject4springapp.model.ApplicationUser;
import se.sara.javaproject4springapp.repository.UserRepository;

@Component
public class DataInitializer {

    private final UserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository applicationUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = applicationUserRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @PostConstruct
    public void init() {
        if (appUserRepository.findAll().isEmpty()){
            ApplicationUser user = new ApplicationUser();
            user.setPassword(passwordEncoder.encode("password1"));
            user.setUsername("admin");
            user.setRole("ADMIN");
            appUserRepository.save(user);

            ApplicationUser user2 = new ApplicationUser();
            user2.setPassword(passwordEncoder.encode("password2"));
            user2.setUsername("user");
            user2.setRole("USER");
            appUserRepository.save(user2);

            ApplicationUser user3 = new ApplicationUser();
            user3.setPassword(passwordEncoder.encode("password3"));
            user3.setUsername("manager");
            user3.setRole("MANAGER");
            appUserRepository.save(user3);
        }
    }
}

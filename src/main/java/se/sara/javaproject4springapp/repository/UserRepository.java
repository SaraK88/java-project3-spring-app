package se.sara.javaproject4springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.sara.javaproject4springapp.model.ApplicationUser;

public interface UserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}

package se.sara.javaproject4springapp.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.sara.javaproject4springapp.model.ApplicationUser;
import se.sara.javaproject4springapp.repository.ApplicationUserRepository;

import java.util.Collections;


@Service
public class ApplicationUserDetailService implements UserDetailsService {
    private final ApplicationUserDetailService applicationUserDetailService;
    private final ApplicationUserRepository applicationUserRepository;

    public ApplicationUserDetailService(ApplicationUserDetailService applicationUserDetailService, ApplicationUserRepository applicationUserRepository) {
        this.applicationUserDetailService = applicationUserDetailService;
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(
                applicationUser.getUsername(),
                applicationUser.getPassword(),
                true, true, true, true,
                Collections.emptyList()
        );
    }
}

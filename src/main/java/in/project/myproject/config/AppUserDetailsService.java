package in.project.myproject.config;

import in.project.myproject.modal.AuthUserModal;
import in.project.myproject.service.AuthUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {
    private final AuthUserService authUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // User user = new User("admin", "admin", new ArrayList<>());
        // return user;

        AuthUserModal authUser = authUserService.findByUsername(username);

        if(authUser != null) {
            return new User(authUser.getUsername(), authUser.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User doest not exist");
        }
    }
}
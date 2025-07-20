package in.project.myproject.config;

import in.project.myproject.modal.AuthUserModal;
import in.project.myproject.service.AuthUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AppUserDetailsServiceTest {

    @InjectMocks
    AppUserDetailsService appUserDetailsService;

    @Mock
    AuthUserService authUserService;


    @Test
    void testLloadUserByUsername() {
        AuthUserModal authUserModal = new AuthUserModal("admin", "null", "admin");
        Mockito.when(authUserService.findByUsername(Mockito.anyString())).thenReturn(authUserModal);

        UserDetails userDetails = appUserDetailsService.loadUserByUsername("admin");
        Assertions.assertNotNull(userDetails);
    }


    @Test
    void testLloadUserByUsernameWhenReturnNull() {
        Mockito.when(authUserService.findByUsername(Mockito.anyString())).thenReturn(null);
        Assertions.assertThrows(UsernameNotFoundException.class, () -> appUserDetailsService.loadUserByUsername("admin"));
    }
}
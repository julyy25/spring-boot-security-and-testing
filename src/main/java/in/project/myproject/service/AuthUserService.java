package in.project.myproject.service;

import in.project.myproject.config.JwtUtil;
import in.project.myproject.modal.AuthUserModal;
import in.project.myproject.modal.FirstModal;
import in.project.myproject.repository.AuthUserRepository;
import in.project.myproject.repository.FirstRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthUserService {
    private final JwtUtil jwtUtil;
    private final AuthUserRepository authUserRepository;

    public Map create(AuthUserModal authUserModal) {
        log.info("{}", authUserModal);
        authUserRepository.save(authUserModal);
        var token = jwtUtil.generateToken(authUserModal.getUsername());
        return Map.of("access_token", token);
    }

    public Map validate(AuthUserModal authUserModal) {
        log.info("{}", authUserModal);
        AuthUserModal dbUser = authUserRepository.findByUsernameAndPassword(authUserModal.getUsername(), authUserModal.getPassword());
        if (dbUser != null) {
            var token = jwtUtil.generateToken(dbUser.getUsername());
            return Map.of("access_token", token);
        } else {
            throw new RuntimeException("Validatoin Failed");
        }
    }


    public AuthUserModal findByUsername(String username) {
        log.info("{}", username);
        return authUserRepository.findByUsername(username);
    }
}

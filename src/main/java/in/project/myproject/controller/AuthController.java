package in.project.myproject.controller;

import in.project.myproject.config.JwtUtil;
import in.project.myproject.modal.AuthUserModal;
import in.project.myproject.service.AuthUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthUserService authUserService;

    @PostMapping("/user")
    public Map create(@RequestBody AuthUserModal authUserModal) {
        return authUserService.create(authUserModal);
    }

    @PostMapping("/validate")
    public Map validate(@RequestBody AuthUserModal authUserModal) {
        return authUserService.validate(authUserModal);
    }

}

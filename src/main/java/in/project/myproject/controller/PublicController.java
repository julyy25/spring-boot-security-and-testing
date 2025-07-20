package in.project.myproject.controller;

import in.project.myproject.config.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
public class PublicController {
    private final JwtUtil jwtUtil;

    @PostMapping("/token")
    public Map create(@RequestParam String username) {
        var token = jwtUtil.generateToken(username);
        return Map.of("access_token", token);
    }

}

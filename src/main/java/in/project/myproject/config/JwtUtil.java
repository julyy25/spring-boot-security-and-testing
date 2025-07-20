package in.project.myproject.config;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class JwtUtil {
    private static final String secret = "7cda6672b3773f1d7022ecc7547ffbdd7cda6672b3773f1d7022ecc7547ffbdd";
    private SecretKey key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String username) {
        List<String> roles = "admin".equalsIgnoreCase(username) ? List.of("ADMIN") : List.of("USER");
        Map<String, Object> claimMap = Map.of("roles", roles);
        return Jwts.builder()
                .claims(claimMap)
                .claim("sub", username)
                .claim("key1", "value1")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 )) // 1 hours expiration
                .signWith(key)
                .compact();
    }

    public Claims parseToken(String token) {
        return (Claims) Jwts.parser()
                .verifyWith(key)
                .build()
                .parse(token)
                .getPayload();
    }

    public String extractUsername(String token) {
        return parseToken(token).getSubject();
    }

    public boolean isTokenExpired(String token) {
        return parseToken(token).getExpiration().before(new Date());
    }
}
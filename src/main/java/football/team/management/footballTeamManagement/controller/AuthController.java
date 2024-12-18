package football.team.management.footballTeamManagement.controller;

import football.team.management.footballTeamManagement.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        if ("test".equals(loginRequest.getUsername()) && "12345".equals(loginRequest.getPassword())) {
            String token = JwtUtil.generateToken(loginRequest.username);
            return ResponseEntity.ok().body(new JwtResponse(token));
        }
        return ResponseEntity.status(401).build();
    }

    public static class LoginRequest {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class JwtResponse {
        private String token;

        public JwtResponse(String token) {
            this.token = token;
        }

        // Getter
        public String getToken() {
            return token;
        }
    }
}
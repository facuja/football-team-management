package football.team.management.footballTeamManagement.service;

import football.team.management.footballTeamManagement.exception.ErrorCode;
import football.team.management.footballTeamManagement.exception.InvalidCredentialsException;
import football.team.management.footballTeamManagement.security.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public String authenticate(String username, String password) {
        if ("test".equals(username) && "12345".equals(password)) {
            return JwtUtil.generateToken(username);
        }
        throw new InvalidCredentialsException(
                ErrorCode.INVALID_CREDENTIALS.getDescription(),
                ErrorCode.INVALID_CREDENTIALS.getCode()
        );
    }
}

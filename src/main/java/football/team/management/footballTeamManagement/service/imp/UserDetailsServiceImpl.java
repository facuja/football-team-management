package football.team.management.footballTeamManagement.service.imp;

import football.team.management.footballTeamManagement.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Usuario por defecto con contraseña codificada
        if ("test".equals(username)) {
            return new User(
                    "test",
                    "{bcrypt}$2a$10$XwR2d8E1f6g6lG0gK6j9D8lAdFw9oD.GHpOa0.kLhxGpXdcPpQ.yS");
        }
        throw new UsernameNotFoundException("User not found");
    }
}

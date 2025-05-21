package be.iccbxl.pid.reservations_springboot.service;

import be.iccbxl.pid.reservations_springboot.model.User;
import be.iccbxl.pid.reservations_springboot.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository repo;

    public CustomUserDetailsService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User u = repo.findByLogin(login);
        if (u == null) {
            throw new UsernameNotFoundException("Utilisateur introuvable : " + login);
        }

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + u.getRole());
        return new org.springframework.security.core.userdetails.User(
                u.getLogin(),
                u.getPassword(),
                Collections.singletonList(authority)
        );
    }
}

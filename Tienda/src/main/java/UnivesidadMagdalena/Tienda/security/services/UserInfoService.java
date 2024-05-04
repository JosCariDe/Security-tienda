package UnivesidadMagdalena.Tienda.security.services;

import UnivesidadMagdalena.Tienda.entities.Role;
import UnivesidadMagdalena.Tienda.entities.User;
import UnivesidadMagdalena.Tienda.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class UserInfoService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserInfoService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userDetail = userRepository.findByUsername(username);
        return userDetail.map(UserInfoDetail::new)
                .orElseThrow( () -> new UsernameNotFoundException("User not found"));
    }
}

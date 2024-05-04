package UnivesidadMagdalena.Tienda.repository;

import UnivesidadMagdalena.Tienda.entities.User;
import org.mapstruct.control.MappingControl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

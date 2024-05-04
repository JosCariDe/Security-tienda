package UnivesidadMagdalena.Tienda.dto.user;

import UnivesidadMagdalena.Tienda.dto.role.RoleInfo;
import UnivesidadMagdalena.Tienda.enumClass.RolesTipos;
import lombok.Builder;

import java.util.Set;

@Builder
public record UserInfo(Long id,
                       String username,
                       String email,
                       String password,
                       Set<RoleInfo> roles) {
}

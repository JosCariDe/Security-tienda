package UnivesidadMagdalena.Tienda.dto.role;

import UnivesidadMagdalena.Tienda.enumClass.RolesTipos;
import lombok.Builder;

@Builder
public record RoleInfo(Long id,
                       RolesTipos rol) {
}

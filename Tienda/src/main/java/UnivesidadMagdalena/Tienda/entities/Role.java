package UnivesidadMagdalena.Tienda.entities;

import UnivesidadMagdalena.Tienda.enumClass.RolesTipos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="roles")
@AllArgsConstructor
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private RolesTipos rol;
    public Role() {
    }
    public Role(RolesTipos rol) {
        this.rol = rol;
    }


}
package UnivesidadMagdalena.Tienda.dto.itemPedido;

import UnivesidadMagdalena.Tienda.dto.pedido.PedidoDto;
import UnivesidadMagdalena.Tienda.dto.producto.ProductoDto;
import UnivesidadMagdalena.Tienda.entities.Pedido;
import lombok.Builder;

@Builder
public record ItemPedidoDto(Long id,
                            PedidoDto pedido,
                            ProductoDto producto,
                            Integer cantidad,
                            Integer precioUnitario) {
}

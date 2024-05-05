package UnivesidadMagdalena.Tienda.dto.pedido;

import UnivesidadMagdalena.Tienda.dto.cliente.ClienteDto;
import UnivesidadMagdalena.Tienda.dto.detalleEnvio.DetalleEnvioDto;
import UnivesidadMagdalena.Tienda.dto.itemPedido.ItemPedidoDto;
import UnivesidadMagdalena.Tienda.dto.pago.PagoDto;
import UnivesidadMagdalena.Tienda.dto.producto.ProductoDto;
import UnivesidadMagdalena.Tienda.entities.Cliente;
import UnivesidadMagdalena.Tienda.entities.DetalleEnvio;
import UnivesidadMagdalena.Tienda.entities.ItemPedido;
import UnivesidadMagdalena.Tienda.entities.Pago;
import UnivesidadMagdalena.Tienda.entities.Pedido;
import UnivesidadMagdalena.Tienda.entities.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-05T13:16:51-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class PedidoMapperImpl implements PedidoMapper {

    @Override
    public PedidoDto pedidoToPedidoDto(Pedido pedido) {
        if ( pedido == null ) {
            return null;
        }

        PedidoDto.PedidoDtoBuilder pedidoDto = PedidoDto.builder();

        pedidoDto.id( pedido.getId() );
        pedidoDto.cliente( clienteToClienteDto( pedido.getCliente() ) );
        pedidoDto.fechaPedido( pedido.getFechaPedido() );
        pedidoDto.status( pedido.getStatus() );
        pedidoDto.itemPedidos( itemPedidoListToItemPedidoDtoList( pedido.getItemPedidos() ) );
        pedidoDto.pago( pagoToPagoDto( pedido.getPago() ) );
        pedidoDto.detalleEnvio( detalleEnvioToDetalleEnvioDto( pedido.getDetalleEnvio() ) );

        return pedidoDto.build();
    }

    @Override
    public Pedido pedidoDtoToPedido(PedidoDto pedidoDto) {
        if ( pedidoDto == null ) {
            return null;
        }

        Pedido.PedidoBuilder pedido = Pedido.builder();

        pedido.id( pedidoDto.id() );
        pedido.cliente( clienteDtoToCliente( pedidoDto.cliente() ) );
        pedido.fechaPedido( pedidoDto.fechaPedido() );
        pedido.status( pedidoDto.status() );
        pedido.itemPedidos( itemPedidoDtoListToItemPedidoList( pedidoDto.itemPedidos() ) );
        pedido.pago( pagoDtoToPago( pedidoDto.pago() ) );
        pedido.detalleEnvio( detalleEnvioDtoToDetalleEnvio( pedidoDto.detalleEnvio() ) );

        return pedido.build();
    }

    @Override
    public Pedido pedidoToSaveDtoToPedido(PedidoToSaveDto pedidoToSaveDto) {
        if ( pedidoToSaveDto == null ) {
            return null;
        }

        Pedido.PedidoBuilder pedido = Pedido.builder();

        pedido.id( pedidoToSaveDto.id() );
        pedido.fechaPedido( pedidoToSaveDto.fechaPedido() );
        pedido.status( pedidoToSaveDto.status() );

        return pedido.build();
    }

    @Override
    public List<PedidoDto> pedidosToPedidosDto(List<Pedido> pedidoList) {
        if ( pedidoList == null ) {
            return null;
        }

        List<PedidoDto> list = new ArrayList<PedidoDto>( pedidoList.size() );
        for ( Pedido pedido : pedidoList ) {
            list.add( pedidoToPedidoDto( pedido ) );
        }

        return list;
    }

    @Override
    public List<Pedido> pedidosDtoToPedidos(List<PedidoDto> pedidoDtoList) {
        if ( pedidoDtoList == null ) {
            return null;
        }

        List<Pedido> list = new ArrayList<Pedido>( pedidoDtoList.size() );
        for ( PedidoDto pedidoDto : pedidoDtoList ) {
            list.add( pedidoDtoToPedido( pedidoDto ) );
        }

        return list;
    }

    protected ClienteDto clienteToClienteDto(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteDto.ClienteDtoBuilder clienteDto = ClienteDto.builder();

        clienteDto.id( cliente.getId() );
        clienteDto.nombre( cliente.getNombre() );
        clienteDto.email( cliente.getEmail() );
        clienteDto.direccion( cliente.getDireccion() );
        clienteDto.pedidos( pedidosToPedidosDto( cliente.getPedidos() ) );

        return clienteDto.build();
    }

    protected List<ItemPedidoDto> itemPedidoListToItemPedidoDtoList(List<ItemPedido> list) {
        if ( list == null ) {
            return null;
        }

        List<ItemPedidoDto> list1 = new ArrayList<ItemPedidoDto>( list.size() );
        for ( ItemPedido itemPedido : list ) {
            list1.add( itemPedidoToItemPedidoDto( itemPedido ) );
        }

        return list1;
    }

    protected ProductoDto productoToProductoDto(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        ProductoDto.ProductoDtoBuilder productoDto = ProductoDto.builder();

        productoDto.id( producto.getId() );
        productoDto.nombre( producto.getNombre() );
        productoDto.price( producto.getPrice() );
        productoDto.stock( producto.getStock() );
        productoDto.pedidos( pedidosToPedidosDto( producto.getPedidos() ) );
        productoDto.itemPedidos( itemPedidoListToItemPedidoDtoList( producto.getItemPedidos() ) );

        return productoDto.build();
    }

    protected ItemPedidoDto itemPedidoToItemPedidoDto(ItemPedido itemPedido) {
        if ( itemPedido == null ) {
            return null;
        }

        ItemPedidoDto.ItemPedidoDtoBuilder itemPedidoDto = ItemPedidoDto.builder();

        itemPedidoDto.id( itemPedido.getId() );
        itemPedidoDto.pedido( pedidoToPedidoDto( itemPedido.getPedido() ) );
        itemPedidoDto.producto( productoToProductoDto( itemPedido.getProducto() ) );
        itemPedidoDto.cantidad( itemPedido.getCantidad() );
        itemPedidoDto.precioUnitario( itemPedido.getPrecioUnitario() );

        return itemPedidoDto.build();
    }

    protected PagoDto pagoToPagoDto(Pago pago) {
        if ( pago == null ) {
            return null;
        }

        PagoDto.PagoDtoBuilder pagoDto = PagoDto.builder();

        pagoDto.id( pago.getId() );
        pagoDto.pedido( pedidoToPedidoDto( pago.getPedido() ) );
        pagoDto.totalPago( pago.getTotalPago() );
        pagoDto.fechaPago( pago.getFechaPago() );
        pagoDto.metodoPago( pago.getMetodoPago() );

        return pagoDto.build();
    }

    protected DetalleEnvioDto detalleEnvioToDetalleEnvioDto(DetalleEnvio detalleEnvio) {
        if ( detalleEnvio == null ) {
            return null;
        }

        DetalleEnvioDto.DetalleEnvioDtoBuilder detalleEnvioDto = DetalleEnvioDto.builder();

        detalleEnvioDto.id( detalleEnvio.getId() );
        detalleEnvioDto.pedido( pedidoToPedidoDto( detalleEnvio.getPedido() ) );
        detalleEnvioDto.direccion( detalleEnvio.getDireccion() );
        detalleEnvioDto.transportadora( detalleEnvio.getTransportadora() );
        detalleEnvioDto.numeroGuia( detalleEnvio.getNumeroGuia() );

        return detalleEnvioDto.build();
    }

    protected Cliente clienteDtoToCliente(ClienteDto clienteDto) {
        if ( clienteDto == null ) {
            return null;
        }

        Cliente.ClienteBuilder cliente = Cliente.builder();

        cliente.id( clienteDto.id() );
        cliente.nombre( clienteDto.nombre() );
        cliente.email( clienteDto.email() );
        cliente.direccion( clienteDto.direccion() );
        cliente.pedidos( pedidosDtoToPedidos( clienteDto.pedidos() ) );

        return cliente.build();
    }

    protected List<ItemPedido> itemPedidoDtoListToItemPedidoList(List<ItemPedidoDto> list) {
        if ( list == null ) {
            return null;
        }

        List<ItemPedido> list1 = new ArrayList<ItemPedido>( list.size() );
        for ( ItemPedidoDto itemPedidoDto : list ) {
            list1.add( itemPedidoDtoToItemPedido( itemPedidoDto ) );
        }

        return list1;
    }

    protected Producto productoDtoToProducto(ProductoDto productoDto) {
        if ( productoDto == null ) {
            return null;
        }

        Producto.ProductoBuilder producto = Producto.builder();

        producto.id( productoDto.id() );
        producto.nombre( productoDto.nombre() );
        producto.price( productoDto.price() );
        producto.stock( productoDto.stock() );
        producto.pedidos( pedidosDtoToPedidos( productoDto.pedidos() ) );
        producto.itemPedidos( itemPedidoDtoListToItemPedidoList( productoDto.itemPedidos() ) );

        return producto.build();
    }

    protected ItemPedido itemPedidoDtoToItemPedido(ItemPedidoDto itemPedidoDto) {
        if ( itemPedidoDto == null ) {
            return null;
        }

        ItemPedido.ItemPedidoBuilder itemPedido = ItemPedido.builder();

        itemPedido.id( itemPedidoDto.id() );
        itemPedido.pedido( pedidoDtoToPedido( itemPedidoDto.pedido() ) );
        itemPedido.producto( productoDtoToProducto( itemPedidoDto.producto() ) );
        itemPedido.cantidad( itemPedidoDto.cantidad() );
        itemPedido.precioUnitario( itemPedidoDto.precioUnitario() );

        return itemPedido.build();
    }

    protected Pago pagoDtoToPago(PagoDto pagoDto) {
        if ( pagoDto == null ) {
            return null;
        }

        Pago.PagoBuilder pago = Pago.builder();

        pago.id( pagoDto.id() );
        pago.pedido( pedidoDtoToPedido( pagoDto.pedido() ) );
        pago.totalPago( pagoDto.totalPago() );
        pago.fechaPago( pagoDto.fechaPago() );
        pago.metodoPago( pagoDto.metodoPago() );

        return pago.build();
    }

    protected DetalleEnvio detalleEnvioDtoToDetalleEnvio(DetalleEnvioDto detalleEnvioDto) {
        if ( detalleEnvioDto == null ) {
            return null;
        }

        DetalleEnvio.DetalleEnvioBuilder detalleEnvio = DetalleEnvio.builder();

        detalleEnvio.id( detalleEnvioDto.id() );
        detalleEnvio.pedido( pedidoDtoToPedido( detalleEnvioDto.pedido() ) );
        detalleEnvio.direccion( detalleEnvioDto.direccion() );
        detalleEnvio.transportadora( detalleEnvioDto.transportadora() );
        detalleEnvio.numeroGuia( detalleEnvioDto.numeroGuia() );

        return detalleEnvio.build();
    }
}

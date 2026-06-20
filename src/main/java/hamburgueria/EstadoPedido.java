package hamburgueria;

public interface EstadoPedido {
    void avancar(PedidoFluxo pedido);
    String getNome();
}
package hamburgueria;

public class EstadoPronto implements EstadoPedido {

    @Override
    public void avancar(PedidoFluxo pedido) {
    }

    @Override
    public String getNome() {
        return "Pronto";
    }
}
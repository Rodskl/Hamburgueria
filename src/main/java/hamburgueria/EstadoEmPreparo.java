package hamburgueria;

public class EstadoEmPreparo implements EstadoPedido {

    @Override
    public void avancar(PedidoFluxo pedido) {
        if (pedido != null) {
            pedido.setEstado(new EstadoPronto());
        }
    }

    @Override
    public String getNome() {
        return "Em Preparo";
    }
}
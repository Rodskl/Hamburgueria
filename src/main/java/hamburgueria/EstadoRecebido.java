package hamburgueria;

public class EstadoRecebido implements EstadoPedido {

    @Override
    public void avancar(PedidoFluxo pedido) {
        if (pedido != null) {
            pedido.setEstado(new EstadoEmPreparo());
        }
    }

    @Override
    public String getNome() {
        return "Recebido";
    }
}
package hamburgueria;

public class Atendente extends AprovadorDesconto {
    @Override
    public String aprovar(PedidoDesconto pedido) {
        if (pedido == null) {
            return "Pedido invalido";
        }
        if (pedido.getValor() <= 10.0) {
            return "Desconto de R$" + pedido.getValor() + " aprovado pelo Atendente";
        }
        if (proximo != null) {
            return proximo.aprovar(pedido);
        }
        return "Desconto negado";
    }
}
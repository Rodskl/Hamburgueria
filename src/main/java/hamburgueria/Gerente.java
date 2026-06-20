package hamburgueria;

public class Gerente extends AprovadorDesconto {
    @Override
    public String aprovar(PedidoDesconto pedido) {
        if (pedido == null) {
            return "Pedido invalido";
        }
        if (pedido.getValor() <= 50.0) {
            return "Desconto de R$" + pedido.getValor() + " aprovado pelo Gerente";
        }
        if (proximo != null) {
            return proximo.aprovar(pedido);
        }
        return "Desconto negado";
    }
}
package hamburgueria;

public class Dono extends AprovadorDesconto {
    @Override
    public String aprovar(PedidoDesconto pedido) {
        if (pedido == null) {
            return "Pedido invalido";
        }
        if (pedido.getValor() <= 500.0) {
            return "Desconto de R$" + pedido.getValor() + " aprovado pelo Dono";
        }
        return "Desconto de R$" + pedido.getValor() + " negado pelo Dono: valor excessivo";
    }
}
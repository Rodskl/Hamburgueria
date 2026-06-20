package hamburgueria;

public abstract class AprovadorDesconto {
    protected AprovadorDesconto proximo;

    public void setProximo(AprovadorDesconto proximo) {
        this.proximo = proximo;
    }

    public abstract String aprovar(PedidoDesconto pedido);
}
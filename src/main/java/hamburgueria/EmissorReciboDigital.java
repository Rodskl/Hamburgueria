package hamburgueria;

public class EmissorReciboDigital implements EmissorRecibo {
    @Override
    public String emitir(String pedido, double valor) {
        return "Enviando recibo digital: " + pedido + " - R$" + valor;
    }
}
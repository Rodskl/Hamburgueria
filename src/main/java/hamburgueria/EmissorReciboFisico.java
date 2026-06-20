package hamburgueria;

public class EmissorReciboFisico implements EmissorRecibo {
    @Override
    public String emitir(String pedido, double valor) {
        return "Imprimindo recibo fisico: " + pedido + " - R$" + valor;
    }
}
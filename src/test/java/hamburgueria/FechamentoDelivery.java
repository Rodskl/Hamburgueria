package hamburgueria;

public class FechamentoDelivery extends FechamentoConta {
    
    public FechamentoDelivery(EmissorRecibo emissor) {
        super(emissor);
    }

    @Override
    public String fechar(String pedido, double valor) {
        if (emissor == null) {
            return "Erro no fechamento";
        }
        double valorComTaxa = valor + 5.00;
        return "Fechamento Delivery (+Taxa) -> " + emissor.emitir(pedido, valorComTaxa);
    }
}
package hamburgueria;

public class FechamentoBalcao extends FechamentoConta {

    public FechamentoBalcao(EmissorRecibo emissor) {
        super(emissor);
    }

    @Override
    public String fechar(String pedido, double valor) {
        if (emissor == null) {
            return "Erro no fechamento";
        }
        return "Fechamento Balcao -> " + emissor.emitir(pedido, valor);
    }
}
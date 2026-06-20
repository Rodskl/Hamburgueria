package hamburgueria;

public abstract class FechamentoConta {
    protected EmissorRecibo emissor;

    public FechamentoConta(EmissorRecibo emissor) {
        this.emissor = emissor;
    }

    public abstract String fechar(String pedido, double valor);
}
package hamburgueria;

public class ExpressaoTerminal implements Expressao {
    private String dado;

    public ExpressaoTerminal(String dado) {
        this.dado = dado;
    }

    @Override
    public boolean interpretar(String contexto) {
        if (contexto == null || dado == null) {
            return false;
        }
        return contexto.contains(dado);
    }
}
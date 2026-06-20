package hamburgueria;

public class MediadorCentral implements Mediador {
    private SetorHamburgueria cozinha;
    private SetorHamburgueria painel;

    public void setCozinha(SetorHamburgueria cozinha) {
        this.cozinha = cozinha;
    }

    public void setPainel(SetorHamburgueria painel) {
        this.painel = painel;
    }

    @Override
    public void enviarMensagem(String mensagem, SetorHamburgueria remetente) {
        if (remetente == cozinha && painel != null) {
            painel.receber(mensagem);
        } else if (remetente == painel && cozinha != null) {
            cozinha.receber(mensagem);
        }
    }
}
package hamburgueria;

public abstract class SetorHamburgueria {
    protected Mediador mediador;
    protected String ultimaMensagem;

    public SetorHamburgueria(Mediador mediador) {
        this.mediador = mediador;
    }

    public void enviar(String mensagem) {
        if (this.mediador != null) {
            this.mediador.enviarMensagem(mensagem, this);
        }
    }

    public abstract void receber(String mensagem);

    public String getUltimaMensagem() {
        return this.ultimaMensagem;
    }
}
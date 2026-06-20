package hamburgueria;

public class PainelSetor extends SetorHamburgueria {

    public PainelSetor(Mediador mediador) {
        super(mediador);
    }

    @Override
    public void receber(String mensagem) {
        this.ultimaMensagem = "Painel exibe: " + mensagem;
    }
}
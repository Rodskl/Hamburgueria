package hamburgueria;

public class CozinhaSetor extends SetorHamburgueria {

    public CozinhaSetor(Mediador mediador) {
        super(mediador);
    }

    @Override
    public void receber(String mensagem) {
        this.ultimaMensagem = "Cozinha recebeu: " + mensagem;
    }
}
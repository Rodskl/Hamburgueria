package hamburgueria;

public class ComandoPrepararHamburguer implements Comando {
    private Cozinha cozinha;
    private String lanche;

    public ComandoPrepararHamburguer(Cozinha cozinha, String lanche) {
        this.cozinha = cozinha;
        this.lanche = lanche;
    }

    @Override
    public void executar() {
        if (cozinha != null) {
            cozinha.prepararLanche(lanche);
        }
    }
}
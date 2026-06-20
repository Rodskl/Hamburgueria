package hamburgueria;

public class ComandoPrepararBatata implements Comando {
    private Cozinha cozinha;
    private String batata;

    public ComandoPrepararBatata(Cozinha cozinha, String batata) {
        this.cozinha = cozinha;
        this.batata = batata;
    }

    @Override
    public void executar() {
        if (cozinha != null) {
            cozinha.fritarAcompanhamento(batata);
        }
    }
}
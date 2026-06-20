package hamburgueria;

public class MontagemArtesanal extends MontagemTemplate {

    @Override
    protected void prepararPao() {
        passos.add("Selando pao brioche na manteiga");
    }

    @Override
    protected void adicionarCarne() {
        passos.add("Grelhando blend de 180g ao ponto");
    }

    @Override
    protected void adicionarAcompanhamentos() {
        passos.add("Adicionando cheddar e cebola caramelizada");
    }
}
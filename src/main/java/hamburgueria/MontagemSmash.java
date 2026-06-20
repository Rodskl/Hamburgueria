package hamburgueria;

public class MontagemSmash extends MontagemTemplate {

    @Override
    protected void prepararPao() {
        passos.add("Aquecendo pao de batata");
    }

    @Override
    protected void adicionarCarne() {
        passos.add("Fazendo smash de duas carnes de 90g com crosta");
    }

    @Override
    protected void adicionarAcompanhamentos() {
        passos.add("Adicionando american cheese e picles");
    }
}
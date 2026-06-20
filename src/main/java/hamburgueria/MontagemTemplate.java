package hamburgueria;

import java.util.ArrayList;
import java.util.List;

public abstract class MontagemTemplate {
    protected List<String> passos;

    public MontagemTemplate() {
        this.passos = new ArrayList<>();
    }

    public final void montarLanche() {
        passos.clear();
        prepararPao();
        adicionarCarne();
        adicionarAcompanhamentos();
        finalizarLanche();
    }

    protected abstract void prepararPao();
    protected abstract void adicionarCarne();
    protected abstract void adicionarAcompanhamentos();

    protected void finalizarLanche() {
        passos.add("Lanche embalado e pronto");
    }

    public List<String> getPassos() {
        return new ArrayList<>(passos);
    }
}
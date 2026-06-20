package hamburgueria;

import java.util.ArrayList;
import java.util.List;

public class Cozinha {
    private List<String> preparados;

    public Cozinha() {
        this.preparados = new ArrayList<>();
    }

    public void prepararLanche(String lanche) {
        if (lanche != null && !lanche.trim().isEmpty()) {
            preparados.add("Lanche: " + lanche);
        }
    }

    public void fritarAcompanhamento(String acompanhamento) {
        if (acompanhamento != null && !acompanhamento.trim().isEmpty()) {
            preparados.add("Acompanhamento: " + acompanhamento);
        }
    }

    public List<String> getPreparados() {
        return new ArrayList<>(preparados);
    }

    public void limparCozinha() {
        preparados.clear();
    }
}
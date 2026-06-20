package hamburgueria;

import java.util.ArrayList;
import java.util.List;

public class MontadorLanche {
    private List<String> ingredientesAtuais;

    public MontadorLanche() {
        this.ingredientesAtuais = new ArrayList<>();
    }

    public void adicionarIngrediente(String ingrediente) {
        if (ingrediente != null && !ingrediente.trim().isEmpty()) {
            this.ingredientesAtuais.add(ingrediente);
        }
    }

    public EstadoLanche salvarEstado() {
        return new EstadoLanche(this.ingredientesAtuais);
    }

    public void restaurarEstado(EstadoLanche estado) {
        if (estado != null) {
            this.ingredientesAtuais = estado.getIngredientes();
        }
    }

    public List<String> getIngredientes() {
        return new ArrayList<>(this.ingredientesAtuais);
    }
}
package hamburgueria;

import java.util.ArrayList;
import java.util.List;

public class EstadoLanche {
    private final List<String> ingredientes;

    public EstadoLanche(List<String> ingredientes) {
        if (ingredientes != null) {
            this.ingredientes = new ArrayList<>(ingredientes);
        } else {
            this.ingredientes = new ArrayList<>();
        }
    }

    public List<String> getIngredientes() {
        return new ArrayList<>(this.ingredientes);
    }
}
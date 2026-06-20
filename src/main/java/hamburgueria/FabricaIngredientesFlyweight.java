package hamburgueria;

import java.util.HashMap;
import java.util.Map;

public class FabricaIngredientesFlyweight {
    private Map<String, IngredienteFlyweight> cacheIngredientes;

    public FabricaIngredientesFlyweight() {
        this.cacheIngredientes = new HashMap<>();
    }

    public IngredienteFlyweight getIngrediente(String nome, double custo) {
        if (nome == null || nome.trim().isEmpty()) {
            return null;
        }

        String chave = nome.toLowerCase();
        
        if (!cacheIngredientes.containsKey(chave)) {
            cacheIngredientes.put(chave, new IngredienteBase(nome, custo));
        }
        
        return cacheIngredientes.get(chave);
    }

    public int getTamanhoCache() {
        return cacheIngredientes.size();
    }
}
package hamburgueria;

import java.util.HashMap;
import java.util.Map;

public class GerenciadorPrototipos {
    private Map<String, PrototipoLanche> registro;

    public GerenciadorPrototipos() {
        this.registro = new HashMap<>();
    }

    public void adicionarPrototipo(String chave, PrototipoLanche prototipo) {
        if (chave != null && prototipo != null) {
            registro.put(chave, prototipo);
        }
    }

    public PrototipoLanche obterClone(String chave) {
        PrototipoLanche prototipo = registro.get(chave);
        if (prototipo != null) {
            return prototipo.clonar();
        }
        return null;
    }

    public int getQuantidade() {
        return registro.size();
    }
}
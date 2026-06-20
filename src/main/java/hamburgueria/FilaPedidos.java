package hamburgueria;

import java.util.ArrayList;
import java.util.List;

public class FilaPedidos {
    private List<Comando> fila;

    public FilaPedidos() {
        this.fila = new ArrayList<>();
    }

    public void adicionarPedido(Comando comando) {
        if (comando != null) {
            fila.add(comando);
        }
    }

    public void processarFila() {
        for (Comando comando : fila) {
            comando.executar();
        }
        fila.clear();
    }

    public int getTamanho() {
        return fila.size();
    }

    public void cancelarTodos() {
        fila.clear();
    }
}
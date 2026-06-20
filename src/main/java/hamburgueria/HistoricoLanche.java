package hamburgueria;

import java.util.Stack;

public class HistoricoLanche {
    private Stack<EstadoLanche> historico;

    public HistoricoLanche() {
        this.historico = new Stack<>();
    }

    public void salvar(EstadoLanche estado) {
        if (estado != null) {
            this.historico.push(estado);
        }
    }

    public EstadoLanche desfazer() {
        if (!this.historico.isEmpty()) {
            return this.historico.pop();
        }
        return null;
    }

    public void limparHistorico() {
        this.historico.clear();
    }

    public int getTamanho() {
        return this.historico.size();
    }
}
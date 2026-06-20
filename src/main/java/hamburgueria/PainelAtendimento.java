package hamburgueria;

import java.util.ArrayList;
import java.util.List;

public class PainelAtendimento implements SubjectPedido {
    private List<ObserverPedido> observers;

    public PainelAtendimento() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void adicionarObserver(ObserverPedido o) {
        if (o != null && !observers.contains(o)) {
            observers.add(o);
        }
    }

    @Override
    public void removerObserver(ObserverPedido o) {
        observers.remove(o);
    }

    @Override
    public void notificarObservers(String mensagem) {
        for (ObserverPedido o : observers) {
            o.atualizar(mensagem);
        }
    }

    public int getQuantidadeObservers() {
        return observers.size();
    }
}
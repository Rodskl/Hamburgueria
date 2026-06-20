package hamburgueria;

public interface SubjectPedido {
    void adicionarObserver(ObserverPedido o);
    void removerObserver(ObserverPedido o);
    void notificarObservers(String mensagem);
}
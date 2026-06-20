package hamburgueria;

public class Cliente implements ObserverPedido {
    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    @Override
    public void atualizar(String mensagem) {
        this.ultimaNotificacao = mensagem;
    }
}
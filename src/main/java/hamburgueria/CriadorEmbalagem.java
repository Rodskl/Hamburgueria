package hamburgueria;

public abstract class CriadorEmbalagem {
    
    public abstract Embalagem criarEmbalagem();

    public String empacotarPedido() {
        Embalagem embalagem = criarEmbalagem();
        if (embalagem == null || embalagem.getTipo() == null) {
            return "Falha no empacotamento";
        }
        return "Pedido empacotado em: " + embalagem.getTipo();
    }
}
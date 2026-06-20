package hamburgueria;

public interface PrototipoLanche {
    PrototipoLanche clonar();
    String getDescricao();
    void setDescricao(String descricao);
}
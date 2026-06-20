package hamburgueria;

public class CriadorBalcao extends CriadorEmbalagem {
    @Override
    public Embalagem criarEmbalagem() {
        return new EmbalagemBalcao();
    }
}
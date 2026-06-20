package hamburgueria;

public class CriadorViagem extends CriadorEmbalagem {
    @Override
    public Embalagem criarEmbalagem() {
        return new EmbalagemViagem();
    }
}
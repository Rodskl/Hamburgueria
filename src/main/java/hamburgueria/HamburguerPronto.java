package hamburgueria;

public class HamburguerPronto implements PrototipoLanche {
    private String descricao;
    private double precoBase;

    public HamburguerPronto(String descricao, double precoBase) {
        this.descricao = descricao;
        this.precoBase = precoBase;
    }

    public HamburguerPronto(HamburguerPronto origem) {
        if (origem != null) {
            this.descricao = origem.descricao;
            this.precoBase = origem.precoBase;
        }
    }

    @Override
    public PrototipoLanche clonar() {
        return new HamburguerPronto(this);
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoBase() {
        return this.precoBase;
    }
}
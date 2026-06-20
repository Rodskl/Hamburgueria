package hamburgueria;

import java.math.BigDecimal;

public class HamburguerBase implements Pedido {
    private String nome;
    private BigDecimal precoBase;

    public HamburguerBase(String nome, BigDecimal precoBase) {
        this.nome = nome;
        this.precoBase = precoBase;
    }

    @Override
    public String getDescricao() {
        if (nome == null) return "Hamburguer Indefinido";
        return nome;
    }

    @Override
    public BigDecimal getPreco() {
        if (precoBase == null) return BigDecimal.ZERO;
        return precoBase;
    }
}
package hamburgueria;

import java.math.BigDecimal;

public class PagamentoDinheiro implements PagamentoStrategy {
    private BigDecimal valorEntregue;

    public PagamentoDinheiro(BigDecimal valorEntregue) {
        this.valorEntregue = valorEntregue;
    }

    @Override
    public boolean pagar(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }
        if (valorEntregue == null) {
            return false;
        }
        return valorEntregue.compareTo(valor) >= 0;
    }

    public BigDecimal getTroco(BigDecimal valor) {
        if (pagar(valor)) {
            return valorEntregue.subtract(valor);
        }
        return BigDecimal.ZERO;
    }
}
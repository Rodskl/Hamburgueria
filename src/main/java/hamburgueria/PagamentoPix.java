package hamburgueria;

import java.math.BigDecimal;

public class PagamentoPix implements PagamentoStrategy {
    private String chavePix;

    public PagamentoPix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public boolean pagar(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }
        if (chavePix == null || chavePix.trim().isEmpty()) {
            return false;
        }
        return true;
    }
}
package hamburgueria;

import java.math.BigDecimal;

public class PagamentoCartao implements PagamentoStrategy {
    private String numeroCartao;
    private String cvv;

    public PagamentoCartao(String numeroCartao, String cvv) {
        this.numeroCartao = numeroCartao;
        this.cvv = cvv;
    }

    @Override
    public boolean pagar(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }
        if (numeroCartao == null || numeroCartao.length() != 16) {
            return false;
        }
        if (cvv == null || cvv.length() != 3) {
            return false;
        }
        return true;
    }
}
package hamburgueria;

import java.math.BigDecimal;

public interface PagamentoStrategy {
    boolean pagar(BigDecimal valor);
}
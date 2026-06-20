package hamburgueria;

import java.math.BigDecimal;

public class ProcessadorPagamento {
    private PagamentoStrategy estrategia;

    public void setEstrategia(PagamentoStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public boolean processar(BigDecimal valor) {
        if (this.estrategia == null) {
            throw new IllegalStateException();
        }
        return this.estrategia.pagar(valor);
    }
}
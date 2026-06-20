package hamburgueria;

import java.math.BigDecimal;

public class BatataFrita extends AdicionalDecorator {
    
    public BatataFrita(Pedido pedidoWrappado) {
        super(pedidoWrappado);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + Batata Frita";
    }

    @Override
    public BigDecimal getPreco() {
        return super.getPreco().add(new BigDecimal("12.50"));
    }
}
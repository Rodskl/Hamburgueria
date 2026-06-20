package hamburgueria;

import java.math.BigDecimal;

public abstract class AdicionalDecorator implements Pedido {
    protected Pedido pedidoWrappado;

    public AdicionalDecorator(Pedido pedidoWrappado) {
        this.pedidoWrappado = pedidoWrappado;
    }

    @Override
    public String getDescricao() {
        if (pedidoWrappado == null) return "";
        return pedidoWrappado.getDescricao();
    }

    @Override
    public BigDecimal getPreco() {
        if (pedidoWrappado == null) return BigDecimal.ZERO;
        return pedidoWrappado.getPreco();
    }
}
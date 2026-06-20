package hamburgueria;

public class PedidoFluxo {
    private EstadoPedido estado;

    public PedidoFluxo() {
        this.estado = new EstadoRecebido();
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public EstadoPedido getEstado() {
        return this.estado;
    }

    public void avancar() {
        if (this.estado != null) {
            this.estado.avancar(this);
        }
    }

    public String getStatus() {
        if (this.estado != null) {
            return this.estado.getNome();
        }
        return "Sem Estado";
    }
}
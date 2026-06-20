package hamburgueria;

import java.math.BigDecimal;

public class FacadeHamburgueria {
    private Cozinha cozinha;
    private FilaPedidos filaPedidos;
    private ProcessadorPagamento processadorPagamento;
    private PainelAtendimento painel;

    public FacadeHamburgueria() {
        this.cozinha = new Cozinha();
        this.filaPedidos = new FilaPedidos();
        this.processadorPagamento = new ProcessadorPagamento();
        this.painel = new PainelAtendimento();
    }

    public boolean realizarPedido(String lanche, BigDecimal valor, PagamentoStrategy strategy, Cliente cliente) {
        processadorPagamento.setEstrategia(strategy);
        
        if (processadorPagamento.processar(valor)) {
            if (cliente != null) {
                painel.adicionarObserver(cliente);
            }
            
            Comando cmd = new ComandoPrepararHamburguer(cozinha, lanche);
            filaPedidos.adicionarPedido(cmd);
            filaPedidos.processarFila();
            
            painel.notificarObservers("Pedido " + lanche + " em preparo");
            return true;
        }
        return false;
    }

    public Cozinha getCozinha() {
        return cozinha;
    }

    public FilaPedidos getFilaPedidos() {
        return filaPedidos;
    }

    public PainelAtendimento getPainel() {
        return painel;
    }
}
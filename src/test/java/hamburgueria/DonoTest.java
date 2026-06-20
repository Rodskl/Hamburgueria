package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DonoTest {

    @Test
    public void testAprovaAbaixoDoLimite() {
        Dono d = new Dono();
        assertEquals("Desconto de R$200.0 aprovado pelo Dono", d.aprovar(new PedidoDesconto(200.0)));
    }

    @Test
    public void testAprovaNoLimite() {
        Dono d = new Dono();
        assertEquals("Desconto de R$500.0 aprovado pelo Dono", d.aprovar(new PedidoDesconto(500.0)));
    }

    @Test
    public void testNegaAcimaDoLimite() {
        Dono d = new Dono();
        assertEquals("Desconto de R$600.0 negado pelo Dono: valor excessivo", d.aprovar(new PedidoDesconto(600.0)));
    }

    @Test
    public void testIgnoraProximoSeConfigurado() {
        Dono d = new Dono();
        d.setProximo(new AprovadorDesconto() {
            public String aprovar(PedidoDesconto p) { return "Nao deve chegar aqui"; }
        });
        assertEquals("Desconto de R$600.0 negado pelo Dono: valor excessivo", d.aprovar(new PedidoDesconto(600.0)));
    }

    @Test
    public void testPedidoNulo() {
        Dono d = new Dono();
        assertEquals("Pedido invalido", d.aprovar(null));
    }

    @Test
    public void testAprovaValorZero() {
        Dono d = new Dono();
        assertEquals("Desconto de R$0.0 aprovado pelo Dono", d.aprovar(new PedidoDesconto(0.0)));
    }

    @Test
    public void testAprovaValorNegativo() {
        Dono d = new Dono();
        assertEquals("Desconto de R$-50.0 aprovado pelo Dono", d.aprovar(new PedidoDesconto(-50.0)));
    }

    @Test
    public void testPolimorfismo() {
        AprovadorDesconto d = new Dono();
        assertTrue(d instanceof AprovadorDesconto);
    }

    @Test
    public void testIntegracaoPedidoRetornaValor() {
        Dono d = new Dono();
        assertTrue(d.aprovar(new PedidoDesconto(999.99)).contains("999.99"));
    }

    @Test
    public void testInstanciaNaoNula() {
        assertNotNull(new Dono());
    }
}
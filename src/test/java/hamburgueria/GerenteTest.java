package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GerenteTest {

    @Test
    public void testAprovaAbaixoDoLimite() {
        Gerente g = new Gerente();
        assertEquals("Desconto de R$30.0 aprovado pelo Gerente", g.aprovar(new PedidoDesconto(30.0)));
    }

    @Test
    public void testAprovaNoLimite() {
        Gerente g = new Gerente();
        assertEquals("Desconto de R$50.0 aprovado pelo Gerente", g.aprovar(new PedidoDesconto(50.0)));
    }

    @Test
    public void testRepassaAcimaDoLimite() {
        Gerente g = new Gerente();
        g.setProximo(new AprovadorDesconto() {
            public String aprovar(PedidoDesconto p) { return "Repassado"; }
        });
        assertEquals("Repassado", g.aprovar(new PedidoDesconto(60.0)));
    }

    @Test
    public void testNegaAcimaDoLimiteSemProximo() {
        Gerente g = new Gerente();
        assertEquals("Desconto negado", g.aprovar(new PedidoDesconto(60.0)));
    }

    @Test
    public void testPedidoNulo() {
        Gerente g = new Gerente();
        assertEquals("Pedido invalido", g.aprovar(null));
    }

    @Test
    public void testAprovaValorZero() {
        Gerente g = new Gerente();
        assertEquals("Desconto de R$0.0 aprovado pelo Gerente", g.aprovar(new PedidoDesconto(0.0)));
    }

    @Test
    public void testAprovaValorNegativo() {
        Gerente g = new Gerente();
        assertEquals("Desconto de R$-10.0 aprovado pelo Gerente", g.aprovar(new PedidoDesconto(-10.0)));
    }

    @Test
    public void testPolimorfismo() {
        AprovadorDesconto g = new Gerente();
        assertTrue(g instanceof AprovadorDesconto);
    }

    @Test
    public void testIntegracaoPedidoRetornaValor() {
        Gerente g = new Gerente();
        assertTrue(g.aprovar(new PedidoDesconto(49.99)).contains("49.99"));
    }

    @Test
    public void testInstanciaNaoNula() {
        assertNotNull(new Gerente());
    }
}
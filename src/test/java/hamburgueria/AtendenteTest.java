package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AtendenteTest {

    @Test
    public void testAprovaAbaixoDoLimite() {
        Atendente a = new Atendente();
        assertEquals("Desconto de R$5.0 aprovado pelo Atendente", a.aprovar(new PedidoDesconto(5.0)));
    }

    @Test
    public void testAprovaNoLimite() {
        Atendente a = new Atendente();
        assertEquals("Desconto de R$10.0 aprovado pelo Atendente", a.aprovar(new PedidoDesconto(10.0)));
    }

    @Test
    public void testRepassaAcimaDoLimite() {
        Atendente a = new Atendente();
        a.setProximo(new AprovadorDesconto() {
            public String aprovar(PedidoDesconto p) { return "Repassado"; }
        });
        assertEquals("Repassado", a.aprovar(new PedidoDesconto(15.0)));
    }

    @Test
    public void testNegaAcimaDoLimiteSemProximo() {
        Atendente a = new Atendente();
        assertEquals("Desconto negado", a.aprovar(new PedidoDesconto(15.0)));
    }

    @Test
    public void testPedidoNulo() {
        Atendente a = new Atendente();
        assertEquals("Pedido invalido", a.aprovar(null));
    }

    @Test
    public void testAprovaValorZero() {
        Atendente a = new Atendente();
        assertEquals("Desconto de R$0.0 aprovado pelo Atendente", a.aprovar(new PedidoDesconto(0.0)));
    }

    @Test
    public void testAprovaValorNegativo() {
        Atendente a = new Atendente();
        assertEquals("Desconto de R$-5.0 aprovado pelo Atendente", a.aprovar(new PedidoDesconto(-5.0)));
    }

    @Test
    public void testPolimorfismo() {
        AprovadorDesconto a = new Atendente();
        assertTrue(a instanceof AprovadorDesconto);
    }

    @Test
    public void testIntegracaoPedidoRetornaValor() {
        Atendente a = new Atendente();
        assertTrue(a.aprovar(new PedidoDesconto(9.99)).contains("9.99"));
    }

    @Test
    public void testInstanciaNaoNula() {
        assertNotNull(new Atendente());
    }
}
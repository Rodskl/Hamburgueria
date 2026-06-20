package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AprovadorDescontoTest {

    private class AprovadorMock extends AprovadorDesconto {
        public String aprovar(PedidoDesconto pedido) {
            if (proximo != null) return proximo.aprovar(pedido);
            return "Fim";
        }
    }

    @Test
    public void testSetProximoValido() {
        AprovadorDesconto a1 = new AprovadorMock();
        AprovadorDesconto a2 = new AprovadorMock();
        a1.setProximo(a2);
        assertEquals(a2, a1.proximo);
    }

    @Test
    public void testSetProximoNulo() {
        AprovadorDesconto a = new AprovadorMock();
        a.setProximo(null);
        assertNull(a.proximo);
    }

    @Test
    public void testProximoInicialmenteNulo() {
        AprovadorDesconto a = new AprovadorMock();
        assertNull(a.proximo);
    }

    @Test
    public void testDelegacaoParaProximo() {
        AprovadorDesconto a1 = new AprovadorMock();
        AprovadorDesconto a2 = new AprovadorDesconto() {
            public String aprovar(PedidoDesconto p) { return "Interceptado"; }
        };
        a1.setProximo(a2);
        assertEquals("Interceptado", a1.aprovar(new PedidoDesconto(10.0)));
    }

    @Test
    public void testFimDaCadeia() {
        AprovadorDesconto a = new AprovadorMock();
        assertEquals("Fim", a.aprovar(new PedidoDesconto(10.0)));
    }

    @Test
    public void testCadeiaLonga() {
        AprovadorMock a1 = new AprovadorMock();
        AprovadorMock a2 = new AprovadorMock();
        AprovadorDesconto a3 = new AprovadorDesconto() {
            public String aprovar(PedidoDesconto p) { return "Alvo"; }
        };
        a1.setProximo(a2);
        a2.setProximo(a3);
        assertEquals("Alvo", a1.aprovar(new PedidoDesconto(10.0)));
    }

    @Test
    public void testPolimorfismoDaPropriedade() {
        AprovadorDesconto a = new AprovadorMock();
        a.setProximo(new AprovadorMock());
        assertTrue(a.proximo instanceof AprovadorDesconto);
    }

    @Test
    public void testSobrescritaDeProximo() {
        AprovadorMock a1 = new AprovadorMock();
        AprovadorMock a2 = new AprovadorMock();
        AprovadorMock a3 = new AprovadorMock();
        a1.setProximo(a2);
        a1.setProximo(a3);
        assertEquals(a3, a1.proximo);
    }

    @Test
    public void testInstanciaSubclasseValida() {
        assertNotNull(new AprovadorMock());
    }

    @Test
    public void testExcecaoNaCadeia() {
        AprovadorMock a1 = new AprovadorMock();
        a1.setProximo(new AprovadorDesconto() {
            public String aprovar(PedidoDesconto p) { throw new RuntimeException(); }
        });
        assertThrows(RuntimeException.class, () -> a1.aprovar(null));
    }
}
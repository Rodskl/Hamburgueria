package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CriadorEmbalagemTest {

    private class CriadorMock extends CriadorEmbalagem {
        public Embalagem criarEmbalagem() {
            return () -> "Caixa Mock";
        }
    }

    @Test
    public void testEmpacotarPedidoComSucesso() {
        CriadorEmbalagem c = new CriadorMock();
        assertEquals("Pedido empacotado em: Caixa Mock", c.empacotarPedido());
    }

    @Test
    public void testEmpacotarPedidoComEmbalagemNula() {
        CriadorEmbalagem c = new CriadorEmbalagem() {
            public Embalagem criarEmbalagem() { return null; }
        };
        assertEquals("Falha no empacotamento", c.empacotarPedido());
    }

    @Test
    public void testEmpacotarPedidoComTipoNulo() {
        CriadorEmbalagem c = new CriadorEmbalagem() {
            public Embalagem criarEmbalagem() { return () -> null; }
        };
        assertEquals("Falha no empacotamento", c.empacotarPedido());
    }

    @Test
    public void testCriarEmbalagemRetornaInstancia() {
        CriadorEmbalagem c = new CriadorMock();
        assertNotNull(c.criarEmbalagem());
    }

    @Test
    public void testPolimorfismoAbstrato() {
        CriadorEmbalagem c = new CriadorMock();
        assertTrue(c instanceof CriadorEmbalagem);
    }

    @Test
    public void testMultiplasChamadasDeEmpacotamento() {
        CriadorEmbalagem c = new CriadorMock();
        assertEquals(c.empacotarPedido(), c.empacotarPedido());
    }

    @Test
    public void testExcecaoEmCriarEmbalagem() {
        CriadorEmbalagem c = new CriadorEmbalagem() {
            public Embalagem criarEmbalagem() { throw new RuntimeException(); }
        };
        assertThrows(RuntimeException.class, c::empacotarPedido);
    }

    @Test
    public void testInstanciaAnonimaFuncional() {
        assertNotNull(new CriadorMock());
    }

    @Test
    public void testIntegracaoCriacaoEEmpacotamento() {
        CriadorEmbalagem c = new CriadorMock();
        Embalagem e = c.criarEmbalagem();
        assertTrue(c.empacotarPedido().contains(e.getTipo()));
    }

    @Test
    public void testEmpacotarPedidoNaoRetornaNulo() {
        CriadorEmbalagem c = new CriadorMock();
        assertNotNull(c.empacotarPedido());
    }
}
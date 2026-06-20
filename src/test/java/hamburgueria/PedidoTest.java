package hamburgueria;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    @Test
    public void testContratoDescricaoValida() {
        Pedido p = new Pedido() {
            public String getDescricao() { return "Generico"; }
            public BigDecimal getPreco() { return BigDecimal.TEN; }
        };
        assertEquals("Generico", p.getDescricao());
    }

    @Test
    public void testContratoPrecoValido() {
        Pedido p = new Pedido() {
            public String getDescricao() { return "Generico"; }
            public BigDecimal getPreco() { return new BigDecimal("15.50"); }
        };
        assertEquals(new BigDecimal("15.50"), p.getPreco());
    }

    @Test
    public void testContratoDescricaoNula() {
        Pedido p = new Pedido() {
            public String getDescricao() { return null; }
            public BigDecimal getPreco() { return BigDecimal.ZERO; }
        };
        assertNull(p.getDescricao());
    }

    @Test
    public void testContratoPrecoNulo() {
        Pedido p = new Pedido() {
            public String getDescricao() { return "Vazio"; }
            public BigDecimal getPreco() { return null; }
        };
        assertNull(p.getPreco());
    }

    @Test
    public void testContratoPrecoZero() {
        Pedido p = new Pedido() {
            public String getDescricao() { return "Brinde"; }
            public BigDecimal getPreco() { return BigDecimal.ZERO; }
        };
        assertEquals(BigDecimal.ZERO, p.getPreco());
    }

    @Test
    public void testContratoPrecoNegativo() {
        Pedido p = new Pedido() {
            public String getDescricao() { return "Desconto"; }
            public BigDecimal getPreco() { return new BigDecimal("-5.00"); }
        };
        assertTrue(p.getPreco().compareTo(BigDecimal.ZERO) < 0);
    }

    @Test
    public void testContratoDescricaoVazia() {
        Pedido p = new Pedido() {
            public String getDescricao() { return ""; }
            public BigDecimal getPreco() { return BigDecimal.ONE; }
        };
        assertEquals("", p.getDescricao());
    }

    @Test
    public void testContratoMultiplasChamadasDescricao() {
        Pedido p = new Pedido() {
            public String getDescricao() { return "Fixo"; }
            public BigDecimal getPreco() { return BigDecimal.ONE; }
        };
        assertEquals(p.getDescricao(), p.getDescricao());
    }

    @Test
    public void testContratoMultiplasChamadasPreco() {
        Pedido p = new Pedido() {
            public String getDescricao() { return "Fixo"; }
            public BigDecimal getPreco() { return BigDecimal.TEN; }
        };
        assertEquals(p.getPreco(), p.getPreco());
    }

    @Test
    public void testPolimorfismoInterface() {
        Pedido p = new Pedido() {
            public String getDescricao() { return "Teste"; }
            public BigDecimal getPreco() { return BigDecimal.ONE; }
        };
        assertTrue(p instanceof Pedido);
    }
}
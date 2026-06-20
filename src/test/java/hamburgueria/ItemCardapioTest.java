package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemCardapioTest {

    @Test
    public void testContratoNomeValido() {
        ItemCardapio i = new ItemCardapio() {
            public String getNome() { return "Refrigerante"; }
            public double getPreco() { return 5.0; }
        };
        assertEquals("Refrigerante", i.getNome());
    }

    @Test
    public void testContratoPrecoValido() {
        ItemCardapio i = new ItemCardapio() {
            public String getNome() { return "Agua"; }
            public double getPreco() { return 3.5; }
        };
        assertEquals(3.5, i.getPreco());
    }

    @Test
    public void testContratoNomeNulo() {
        ItemCardapio i = new ItemCardapio() {
            public String getNome() { return null; }
            public double getPreco() { return 10.0; }
        };
        assertNull(i.getNome());
    }

    @Test
    public void testContratoPrecoZero() {
        ItemCardapio i = new ItemCardapio() {
            public String getNome() { return "Brinde"; }
            public double getPreco() { return 0.0; }
        };
        assertEquals(0.0, i.getPreco());
    }

    @Test
    public void testContratoPrecoNegativo() {
        ItemCardapio i = new ItemCardapio() {
            public String getNome() { return "Desconto"; }
            public double getPreco() { return -5.0; }
        };
        assertTrue(i.getPreco() < 0);
    }

    @Test
    public void testPolimorfismoInterface() {
        ItemCardapio i = new ItemCardapio() {
            public String getNome() { return "Suco"; }
            public double getPreco() { return 7.0; }
        };
        assertTrue(i instanceof ItemCardapio);
    }

    @Test
    public void testInstanciaAnonima() {
        assertNotNull((ItemCardapio) new ItemCardapio() {
            public String getNome() { return "A"; }
            public double getPreco() { return 1.0; }
        });
    }

    @Test
    public void testExcecaoNaImplementacao() {
        ItemCardapio i = new ItemCardapio() {
            public String getNome() { throw new RuntimeException(); }
            public double getPreco() { return 0; }
        };
        assertThrows(RuntimeException.class, i::getNome);
    }

    @Test
    public void testMultiplasChamadasNome() {
        ItemCardapio i = new ItemCardapio() {
            public String getNome() { return "Fixo"; }
            public double getPreco() { return 1.0; }
        };
        assertEquals(i.getNome(), i.getNome());
    }

    @Test
    public void testMultiplasChamadasPreco() {
        ItemCardapio i = new ItemCardapio() {
            public String getNome() { return "Fixo"; }
            public double getPreco() { return 10.5; }
        };
        assertEquals(i.getPreco(), i.getPreco());
    }
}
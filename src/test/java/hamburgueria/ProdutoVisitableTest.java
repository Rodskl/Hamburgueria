package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoVisitableTest {

    @Test
    public void testGetNome() {
        ProdutoVisitable p = new ProdutoVisitable("Refrigerante", 5.0);
        assertEquals("Refrigerante", p.getNome());
    }

    @Test
    public void testGetPreco() {
        ProdutoVisitable p = new ProdutoVisitable("Agua", 3.0);
        assertEquals(3.0, p.getPreco());
    }

    @Test
    public void testNomeNulo() {
        ProdutoVisitable p = new ProdutoVisitable(null, 10.0);
        assertNull(p.getNome());
    }

    @Test
    public void testPrecoZero() {
        ProdutoVisitable p = new ProdutoVisitable("Brinde", 0.0);
        assertEquals(0.0, p.getPreco());
    }

    @Test
    public void testPrecoNegativo() {
        ProdutoVisitable p = new ProdutoVisitable("Desconto", -5.0);
        assertEquals(-5.0, p.getPreco());
    }

    @Test
    public void testAceitarChamaVisitor() {
        ProdutoVisitable p = new ProdutoVisitable("Batata", 10.0);
        VisitorExportacao v = new VisitorExportacao() {
            public String visitarProduto(ProdutoVisitable prod) { return prod.getNome(); }
            public String visitarCombo(ComboVisitable c) { return ""; }
        };
        assertEquals("Batata", p.aceitar(v));
    }

    @Test
    public void testAceitarVisitorNulo() {
        ProdutoVisitable p = new ProdutoVisitable("Batata", 10.0);
        assertEquals("", p.aceitar(null));
    }

    @Test
    public void testPolimorfismo() {
        ElementoVisitable p = new ProdutoVisitable("Suco", 7.0);
        assertTrue(p instanceof ElementoVisitable);
    }

    @Test
    public void testInstanciaNaoNula() {
        assertNotNull(new ProdutoVisitable("Teste", 1.0));
    }

    @Test
    public void testReferenciaPassadaCorretamente() {
        ProdutoVisitable p = new ProdutoVisitable("Ovo", 2.0);
        final ProdutoVisitable[] ref = new ProdutoVisitable[1];
        VisitorExportacao v = new VisitorExportacao() {
            public String visitarProduto(ProdutoVisitable prod) { ref[0] = prod; return ""; }
            public String visitarCombo(ComboVisitable c) { return ""; }
        };
        p.aceitar(v);
        assertEquals(p, ref[0]);
    }
}
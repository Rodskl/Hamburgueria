package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VisitorExportacaoTest {

    @Test
    public void testVisitarProdutoValido() {
        VisitorExportacao v = new VisitorExportacao() {
            public String visitarProduto(ProdutoVisitable p) { return "P"; }
            public String visitarCombo(ComboVisitable c) { return "C"; }
        };
        assertEquals("P", v.visitarProduto(new ProdutoVisitable("A", 1.0)));
    }

    @Test
    public void testVisitarProdutoNulo() {
        VisitorExportacao v = new VisitorExportacao() {
            public String visitarProduto(ProdutoVisitable p) { return p == null ? "Nulo" : "P"; }
            public String visitarCombo(ComboVisitable c) { return "C"; }
        };
        assertEquals("Nulo", v.visitarProduto(null));
    }

    @Test
    public void testVisitarComboValido() {
        VisitorExportacao v = new VisitorExportacao() {
            public String visitarProduto(ProdutoVisitable p) { return "P"; }
            public String visitarCombo(ComboVisitable c) { return "C"; }
        };
        assertEquals("C", v.visitarCombo(new ComboVisitable("Combo")));
    }

    @Test
    public void testVisitarComboNulo() {
        VisitorExportacao v = new VisitorExportacao() {
            public String visitarProduto(ProdutoVisitable p) { return "P"; }
            public String visitarCombo(ComboVisitable c) { return c == null ? "Nulo" : "C"; }
        };
        assertEquals("Nulo", v.visitarCombo(null));
    }

    @Test
    public void testPolimorfismo() {
        VisitorExportacao v = new VisitorExportacao() {
            public String visitarProduto(ProdutoVisitable p) { return ""; }
            public String visitarCombo(ComboVisitable c) { return ""; }
        };
        assertTrue(v instanceof VisitorExportacao);
    }

    @Test
    public void testInstanciaAnonima() {
        assertNotNull((VisitorExportacao) new VisitorExportacao() {
            public String visitarProduto(ProdutoVisitable p) { return ""; }
            public String visitarCombo(ComboVisitable c) { return ""; }
        });
    }

    @Test
    public void testExcecaoEmProduto() {
        VisitorExportacao v = new VisitorExportacao() {
            public String visitarProduto(ProdutoVisitable p) { throw new RuntimeException(); }
            public String visitarCombo(ComboVisitable c) { return ""; }
        };
        assertThrows(RuntimeException.class, () -> v.visitarProduto(null));
    }

    @Test
    public void testExcecaoEmCombo() {
        VisitorExportacao v = new VisitorExportacao() {
            public String visitarProduto(ProdutoVisitable p) { return ""; }
            public String visitarCombo(ComboVisitable c) { throw new RuntimeException(); }
        };
        assertThrows(RuntimeException.class, () -> v.visitarCombo(null));
    }

    @Test
    public void testRetornosDiferentes() {
        VisitorExportacao v = new VisitorExportacao() {
            public String visitarProduto(ProdutoVisitable p) { return "1"; }
            public String visitarCombo(ComboVisitable c) { return "2"; }
        };
        assertNotEquals(v.visitarProduto(null), v.visitarCombo(null));
    }

    @Test
    public void testVariavelExterna() {
        final int[] cont = {0};
        VisitorExportacao v = new VisitorExportacao() {
            public String visitarProduto(ProdutoVisitable p) { cont[0]++; return ""; }
            public String visitarCombo(ComboVisitable c) { cont[0]++; return ""; }
        };
        v.visitarProduto(null);
        v.visitarCombo(null);
        assertEquals(2, cont[0]);
    }
}
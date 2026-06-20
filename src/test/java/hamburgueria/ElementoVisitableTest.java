package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ElementoVisitableTest {

    @Test
    public void testAceitarRetornaValor() {
        ElementoVisitable e = v -> "Aceito";
        assertEquals("Aceito", e.aceitar(null));
    }

    @Test
    public void testAceitarVisitorNulo() {
        ElementoVisitable e = v -> v == null ? "Erro" : "Ok";
        assertEquals("Erro", e.aceitar(null));
    }

    @Test
    public void testPolimorfismo() {
        ElementoVisitable e = v -> "";
        assertTrue(e instanceof ElementoVisitable);
    }

    @Test
    public void testInstanciaAnonima() {
        assertNotNull((ElementoVisitable) v -> "Teste");
    }

    @Test
    public void testExcecaoNaImplementacao() {
        ElementoVisitable e = v -> { throw new IllegalArgumentException(); };
        assertThrows(IllegalArgumentException.class, () -> e.aceitar(null));
    }

    @Test
    public void testMultiplasChamadas() {
        ElementoVisitable e = v -> "Fixo";
        assertEquals(e.aceitar(null), e.aceitar(null));
    }

    @Test
    public void testRetornoVazio() {
        ElementoVisitable e = v -> "";
        assertEquals("", e.aceitar(null));
    }

    @Test
    public void testVariavelExterna() {
        final boolean[] flag = {false};
        ElementoVisitable e = v -> { flag[0] = true; return ""; };
        e.aceitar(null);
        assertTrue(flag[0]);
    }

    @Test
    public void testIntegracaoComMockVisitor() {
        VisitorExportacao v = new VisitorExportacao() {
            public String visitarProduto(ProdutoVisitable p) { return "P"; }
            public String visitarCombo(ComboVisitable c) { return "C"; }
        };
        ElementoVisitable e = visitor -> visitor.visitarProduto(null);
        assertEquals("P", e.aceitar(v));
    }

    @Test
    public void testCastParaInterface() {
        Object o = (ElementoVisitable) v -> "Cast";
        assertTrue(o instanceof ElementoVisitable);
    }
}
package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExpressaoTest {

    @Test
    public void testRetornoVerdadeiro() {
        Expressao e = ctx -> true;
        assertTrue(e.interpretar("Qualquer"));
    }

    @Test
    public void testRetornoFalso() {
        Expressao e = ctx -> false;
        assertFalse(e.interpretar("Qualquer"));
    }

    @Test
    public void testContextoNulo() {
        Expressao e = ctx -> ctx == null;
        assertTrue(e.interpretar(null));
    }

    @Test
    public void testContextoVazio() {
        Expressao e = ctx -> ctx.isEmpty();
        assertTrue(e.interpretar(""));
    }

    @Test
    public void testPolimorfismoInterface() {
        Expressao e = ctx -> false;
        assertTrue(e instanceof Expressao);
    }

    @Test
    public void testInstanciaAnonima() {
        assertNotNull((Expressao) ctx -> true);
    }

    @Test
    public void testExcecaoNaImplementacao() {
        Expressao e = ctx -> { throw new IllegalArgumentException(); };
        assertThrows(IllegalArgumentException.class, () -> e.interpretar("Teste"));
    }

    @Test
    public void testMultiplasChamadas() {
        Expressao e = ctx -> ctx.length() > 3;
        assertTrue(e.interpretar("Bacon"));
        assertTrue(e.interpretar("Queijo"));
    }

    @Test
    public void testVariavelExterna() {
        final int[] count = {0};
        Expressao e = ctx -> { count[0]++; return true; };
        e.interpretar("A");
        e.interpretar("B");
        assertEquals(2, count[0]);
    }

    @Test
    public void testLogicaInternaContexto() {
        Expressao e = ctx -> ctx.contains("Vegan");
        assertTrue(e.interpretar("Lanche Vegan"));
        assertFalse(e.interpretar("Lanche Bovina"));
    }
}
package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExpressaoTerminalTest {

    @Test
    public void testContemPalavraExata() {
        ExpressaoTerminal e = new ExpressaoTerminal("Bacon");
        assertTrue(e.interpretar("Pao Carne Bacon Queijo"));
    }

    @Test
    public void testNaoContemPalavra() {
        ExpressaoTerminal e = new ExpressaoTerminal("Alface");
        assertFalse(e.interpretar("Pao Carne Bacon Queijo"));
    }

    @Test
    public void testContextoNulo() {
        ExpressaoTerminal e = new ExpressaoTerminal("Queijo");
        assertFalse(e.interpretar(null));
    }

    @Test
    public void testDadoNulo() {
        ExpressaoTerminal e = new ExpressaoTerminal(null);
        assertFalse(e.interpretar("Pao Carne"));
    }

    @Test
    public void testAmbosNulos() {
        ExpressaoTerminal e = new ExpressaoTerminal(null);
        assertFalse(e.interpretar(null));
    }

    @Test
    public void testCaseSensitivity() {
        ExpressaoTerminal e = new ExpressaoTerminal("bacon");
        assertFalse(e.interpretar("BACON"));
    }

    @Test
    public void testContemSubstring() {
        ExpressaoTerminal e = new ExpressaoTerminal("Catup");
        assertTrue(e.interpretar("Borda de Catupiry"));
    }

    @Test
    public void testDadoVazio() {
        ExpressaoTerminal e = new ExpressaoTerminal("");
        assertTrue(e.interpretar("Qualquer Lanche"));
    }

    @Test
    public void testContextoVazio() {
        ExpressaoTerminal e = new ExpressaoTerminal("Carne");
        assertFalse(e.interpretar(""));
    }

    @Test
    public void testPolimorfismo() {
        Expressao e = new ExpressaoTerminal("Teste");
        assertTrue(e instanceof Expressao);
    }
}
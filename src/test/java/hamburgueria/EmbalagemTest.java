package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmbalagemTest {

    @Test
    public void testContratoRetornoValido() {
        Embalagem e = () -> "Caixa";
        assertEquals("Caixa", e.getTipo());
    }

    @Test
    public void testContratoRetornoNulo() {
        Embalagem e = () -> null;
        assertNull(e.getTipo());
    }

    @Test
    public void testContratoRetornoVazio() {
        Embalagem e = () -> "";
        assertEquals("", e.getTipo());
    }

    @Test
    public void testContratoRetornoEspacos() {
        Embalagem e = () -> "   ";
        assertEquals("   ", e.getTipo());
    }

    @Test
    public void testPolimorfismoInterface() {
        Embalagem e = () -> "Teste";
        assertTrue(e instanceof Embalagem);
    }

    @Test
    public void testInstanciaAnonima() {
        assertNotNull((Embalagem) () -> "Anonima");
    }

    @Test
    public void testMultiplasChamadas() {
        Embalagem e = () -> "Fixo";
        assertEquals(e.getTipo(), e.getTipo());
    }

    @Test
    public void testExcecaoNaImplementacao() {
        Embalagem e = () -> { throw new RuntimeException(); };
        assertThrows(RuntimeException.class, e::getTipo);
    }

    @Test
    public void testCaseSensitivity() {
        Embalagem e = () -> "caixa";
        assertNotEquals("Caixa", e.getTipo());
    }

    @Test
    public void testCaracteresEspeciais() {
        Embalagem e = () -> "Caixa-Térmica!";
        assertEquals("Caixa-Térmica!", e.getTipo());
    }
}
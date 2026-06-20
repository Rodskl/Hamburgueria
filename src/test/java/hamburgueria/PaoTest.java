package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaoTest {

    @Test
    public void testRetornoValido() {
        Pao p = () -> "Brioche";
        assertEquals("Brioche", p.getTipo());
    }

    @Test
    public void testRetornoNulo() {
        Pao p = () -> null;
        assertNull(p.getTipo());
    }

    @Test
    public void testRetornoVazio() {
        Pao p = () -> "";
        assertEquals("", p.getTipo());
    }

    @Test
    public void testRetornoEspacos() {
        Pao p = () -> "   ";
        assertEquals("   ", p.getTipo());
    }

    @Test
    public void testMultiplasChamadas() {
        Pao p = () -> "Australiano";
        assertEquals(p.getTipo(), p.getTipo());
    }

    @Test
    public void testRetornoLongo() {
        Pao p = () -> "Pao de Hamburguer Artesanal com Gergelim Torrado";
        assertEquals("Pao de Hamburguer Artesanal com Gergelim Torrado", p.getTipo());
    }

    @Test
    public void testCaseSensitivity() {
        Pao p = () -> "brioche";
        assertNotEquals("Brioche", p.getTipo());
    }

    @Test
    public void testPolimorfismo() {
        Pao p = () -> "Frances";
        assertTrue(p instanceof Pao);
    }

    @Test
    public void testCaracteresEspeciais() {
        Pao p = () -> "Pão@#";
        assertEquals("Pão@#", p.getTipo());
    }

    @Test
    public void testInstanciaAnonima() {
        assertNotNull((Pao) () -> "Teste");
    }
}
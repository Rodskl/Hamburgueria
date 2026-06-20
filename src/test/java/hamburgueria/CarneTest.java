package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarneTest {

    @Test
    public void testRetornoValido() {
        Carne c = () -> "Bovina";
        assertEquals("Bovina", c.getTipo());
    }

    @Test
    public void testRetornoNulo() {
        Carne c = () -> null;
        assertNull(c.getTipo());
    }

    @Test
    public void testRetornoVazio() {
        Carne c = () -> "";
        assertEquals("", c.getTipo());
    }

    @Test
    public void testRetornoEspacos() {
        Carne c = () -> "   ";
        assertEquals("   ", c.getTipo());
    }

    @Test
    public void testMultiplasChamadas() {
        Carne c = () -> "Frango";
        assertEquals(c.getTipo(), c.getTipo());
    }

    @Test
    public void testRetornoLongo() {
        Carne c = () -> "Blend de Costela com Acem e Fraldinha";
        assertEquals("Blend de Costela com Acem e Fraldinha", c.getTipo());
    }

    @Test
    public void testCaseSensitivity() {
        Carne c = () -> "soja";
        assertNotEquals("Soja", c.getTipo());
    }

    @Test
    public void testPolimorfismo() {
        Carne c = () -> "Suina";
        assertTrue(c instanceof Carne);
    }

    @Test
    public void testCaracteresEspeciais() {
        Carne c = () -> "Wagyu A5+";
        assertEquals("Wagyu A5+", c.getTipo());
    }

    @Test
    public void testInstanciaAnonima() {
        assertNotNull((Carne) () -> "Teste");
    }
}
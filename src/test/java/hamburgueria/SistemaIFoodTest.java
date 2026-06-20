package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaIFoodTest {

    @Test
    public void testDespachoValido() {
        SistemaIFood s = new SistemaIFood();
        String resultado = s.despacharMotoqueiro("Lat 10 Lon 20", "TK123");
        assertEquals("Motoqueiro a caminho de Lat 10 Lon 20 [Token: TK123]", resultado);
    }

    @Test
    public void testCoordenadaNula() {
        SistemaIFood s = new SistemaIFood();
        assertEquals("Erro de integracao", s.despacharMotoqueiro(null, "TK123"));
    }

    @Test
    public void testTokenNulo() {
        SistemaIFood s = new SistemaIFood();
        assertEquals("Erro de integracao", s.despacharMotoqueiro("Lat 10", null));
    }

    @Test
    public void testAmbosNulos() {
        SistemaIFood s = new SistemaIFood();
        assertEquals("Erro de integracao", s.despacharMotoqueiro(null, null));
    }

    @Test
    public void testCoordenadaVazia() {
        SistemaIFood s = new SistemaIFood();
        assertEquals("Dados incompletos", s.despacharMotoqueiro("", "TK123"));
    }

    @Test
    public void testTokenVazio() {
        SistemaIFood s = new SistemaIFood();
        assertEquals("Dados incompletos", s.despacharMotoqueiro("Lat 10", ""));
    }

    @Test
    public void testCoordenadaApenasEspacos() {
        SistemaIFood s = new SistemaIFood();
        assertEquals("Dados incompletos", s.despacharMotoqueiro("   ", "TK123"));
    }

    @Test
    public void testTokenApenasEspacos() {
        SistemaIFood s = new SistemaIFood();
        assertEquals("Dados incompletos", s.despacharMotoqueiro("Lat 10", "   "));
    }

    @Test
    public void testIndependenciaDeChamadas() {
        SistemaIFood s = new SistemaIFood();
        s.despacharMotoqueiro("A", "B");
        String resultado = s.despacharMotoqueiro("C", "D");
        assertEquals("Motoqueiro a caminho de C [Token: D]", resultado);
    }

    @Test
    public void testInstanciaNaoNula() {
        SistemaIFood s = new SistemaIFood();
        assertNotNull(s);
    }
}
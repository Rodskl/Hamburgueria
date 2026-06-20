package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChapaTest {

    @Test
    public void testInstanciaUnica() {
        Chapa c1 = Chapa.getInstancia();
        Chapa c2 = Chapa.getInstancia();
        assertSame(c1, c2);
    }

    @Test
    public void testInstanciaNaoNula() {
        Chapa c = Chapa.getInstancia();
        assertNotNull(c);
    }

    @Test
    public void testEstadoInicialDesligada() {
        Chapa c = Chapa.getInstancia();
        c.desligar(); 
        assertFalse(c.isLigada());
    }

    @Test
    public void testLigarChapa() {
        Chapa c = Chapa.getInstancia();
        c.ligar();
        assertTrue(c.isLigada());
    }

    @Test
    public void testDesligarChapa() {
        Chapa c = Chapa.getInstancia();
        c.ligar();
        c.desligar();
        assertFalse(c.isLigada());
    }

    @Test
    public void testPrepararLancheComChapaLigada() {
        Chapa c = Chapa.getInstancia();
        c.resetEstatisticas();
        c.ligar();
        c.prepararLanche();
        assertEquals(1, c.getLanchesPreparados());
    }

    @Test
    public void testPrepararLancheComChapaDesligada() {
        Chapa c = Chapa.getInstancia();
        c.resetEstatisticas();
        c.desligar();
        c.prepararLanche();
        assertEquals(0, c.getLanchesPreparados());
    }

    @Test
    public void testSomaDeLanchesMultiplos() {
        Chapa c = Chapa.getInstancia();
        c.resetEstatisticas();
        c.ligar();
        c.prepararLanche();
        c.prepararLanche();
        c.prepararLanche();
        assertEquals(3, c.getLanchesPreparados());
    }

    @Test
    public void testResetEstatisticas() {
        Chapa c = Chapa.getInstancia();
        c.ligar();
        c.prepararLanche();
        c.resetEstatisticas();
        assertEquals(0, c.getLanchesPreparados());
    }

    @Test
    public void testCompartilhamentoDeEstado() {
        Chapa c1 = Chapa.getInstancia();
        Chapa c2 = Chapa.getInstancia();
        c1.resetEstatisticas();
        c1.ligar();
        c1.prepararLanche();
        c1.prepararLanche();
        assertEquals(2, c2.getLanchesPreparados());
        assertTrue(c2.isLigada());
    }
}
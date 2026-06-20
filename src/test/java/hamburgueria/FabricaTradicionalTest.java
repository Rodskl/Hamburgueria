package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FabricaTradicionalTest {

    @Test
    public void testCriarPaoNaoNulo() {
        FabricaTradicional f = new FabricaTradicional();
        assertNotNull(f.criarPao());
    }

    @Test
    public void testCriarCarneNaoNula() {
        FabricaTradicional f = new FabricaTradicional();
        assertNotNull(f.criarCarne());
    }

    @Test
    public void testTipoPaoTradicional() {
        FabricaTradicional f = new FabricaTradicional();
        assertEquals("Brioche", f.criarPao().getTipo());
    }

    @Test
    public void testTipoCarneTradicional() {
        FabricaTradicional f = new FabricaTradicional();
        assertEquals("Bovina", f.criarCarne().getTipo());
    }

    @Test
    public void testPaoImplementaInterface() {
        FabricaTradicional f = new FabricaTradicional();
        assertTrue(f.criarPao() instanceof Pao);
    }

    @Test
    public void testCarneImplementaInterface() {
        FabricaTradicional f = new FabricaTradicional();
        assertTrue(f.criarCarne() instanceof Carne);
    }

    @Test
    public void testFabricaImplementaInterface() {
        FabricaTradicional f = new FabricaTradicional();
        assertTrue(f instanceof FabricaIngredientes);
    }

   @Test
    public void testCriacaoConsistentePao() {
        FabricaTradicional f = new FabricaTradicional();
        Pao p1 = f.criarPao();
        Pao p2 = f.criarPao();
        assertEquals(p1.getTipo(), p2.getTipo());
    }

    @Test
    public void testCriacaoConsistenteCarne() {
        FabricaTradicional f = new FabricaTradicional();
        Carne c1 = f.criarCarne();
        Carne c2 = f.criarCarne();
        assertEquals(c1.getTipo(), c2.getTipo());
    }
    @Test
    public void testConsistenciaValoresMutuos() {
        FabricaTradicional f = new FabricaTradicional();
        assertEquals("Brioche", f.criarPao().getTipo());
        assertEquals("Bovina", f.criarCarne().getTipo());
    }
}
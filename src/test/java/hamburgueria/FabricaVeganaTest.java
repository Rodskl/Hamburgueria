package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FabricaVeganaTest {

    @Test
    public void testCriarPaoNaoNulo() {
        FabricaVegana f = new FabricaVegana();
        assertNotNull(f.criarPao());
    }

    @Test
    public void testCriarCarneNaoNula() {
        FabricaVegana f = new FabricaVegana();
        assertNotNull(f.criarCarne());
    }

    @Test
    public void testTipoPaoVegano() {
        FabricaVegana f = new FabricaVegana();
        assertEquals("Integral", f.criarPao().getTipo());
    }

    @Test
    public void testTipoCarneVegana() {
        FabricaVegana f = new FabricaVegana();
        assertEquals("Soja", f.criarCarne().getTipo());
    }

    @Test
    public void testPaoImplementaInterface() {
        FabricaVegana f = new FabricaVegana();
        assertTrue(f.criarPao() instanceof Pao);
    }

    @Test
    public void testCarneImplementaInterface() {
        FabricaVegana f = new FabricaVegana();
        assertTrue(f.criarCarne() instanceof Carne);
    }

    @Test
    public void testFabricaImplementaInterface() {
        FabricaVegana f = new FabricaVegana();
        assertTrue(f instanceof FabricaIngredientes);
    }

    @Test
    public void testCriacaoConsistentePao() {
        FabricaVegana f = new FabricaVegana();
        Pao p1 = f.criarPao();
        Pao p2 = f.criarPao();
        assertEquals(p1.getTipo(), p2.getTipo());
    }

    @Test
    public void testCriacaoConsistenteCarne() {
        FabricaVegana f = new FabricaVegana();
        Carne c1 = f.criarCarne();
        Carne c2 = f.criarCarne();
        assertEquals(c1.getTipo(), c2.getTipo());
    }   
    @Test
    public void testConsistenciaValoresMutuos() {
        FabricaVegana f = new FabricaVegana();
        assertEquals("Integral", f.criarPao().getTipo());
        assertEquals("Soja", f.criarCarne().getTipo());
    }
}
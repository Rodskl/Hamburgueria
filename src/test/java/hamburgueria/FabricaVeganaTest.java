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
    public void testIndependenciaInstanciasPao() {
        FabricaVegana f = new FabricaVegana();
        Pao p1 = f.criarPao();
        Pao p2 = f.criarPao();
        assertNotSame(p1, p2);
    }

    @Test
    public void testIndependenciaInstanciasCarne() {
        FabricaVegana f = new FabricaVegana();
        Carne c1 = f.criarCarne();
        Carne c2 = f.criarCarne();
        assertNotSame(c1, c2);
    }

    @Test
    public void testConsistenciaValoresMutuos() {
        FabricaVegana f = new FabricaVegana();
        assertEquals("Integral", f.criarPao().getTipo());
        assertEquals("Soja", f.criarCarne().getTipo());
    }
}
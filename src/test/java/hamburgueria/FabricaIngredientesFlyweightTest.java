package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FabricaIngredientesFlyweightTest {

    @Test
    public void testCacheInicialVazio() {
        FabricaIngredientesFlyweight f = new FabricaIngredientesFlyweight();
        assertEquals(0, f.getTamanhoCache());
    }

    @Test
    public void testCriacaoDeNovoIngrediente() {
        FabricaIngredientesFlyweight f = new FabricaIngredientesFlyweight();
        IngredienteFlyweight i = f.getIngrediente("Pao Brioche", 2.0);
        assertNotNull(i);
        assertEquals("Pao Brioche", i.getNome());
        assertEquals(1, f.getTamanhoCache());
    }

    @Test
    public void testReusoDeIngrediente() {
        FabricaIngredientesFlyweight f = new FabricaIngredientesFlyweight();
        IngredienteFlyweight i1 = f.getIngrediente("Carne", 5.0);
        IngredienteFlyweight i2 = f.getIngrediente("Carne", 5.0);
        assertSame(i1, i2);
        assertEquals(1, f.getTamanhoCache());
    }

    @Test
    public void testReusoCaseInsensitive() {
        FabricaIngredientesFlyweight f = new FabricaIngredientesFlyweight();
        IngredienteFlyweight i1 = f.getIngrediente("Bacon", 3.0);
        IngredienteFlyweight i2 = f.getIngrediente("bacon", 3.0);
        assertSame(i1, i2);
        assertEquals(1, f.getTamanhoCache());
    }

    @Test
    public void testCriacaoDeIngredientesDiferentes() {
        FabricaIngredientesFlyweight f = new FabricaIngredientesFlyweight();
        f.getIngrediente("Pao", 2.0);
        f.getIngrediente("Carne", 5.0);
        assertEquals(2, f.getTamanhoCache());
    }

    @Test
    public void testNomeNuloRetornaNulo() {
        FabricaIngredientesFlyweight f = new FabricaIngredientesFlyweight();
        assertNull(f.getIngrediente(null, 1.0));
        assertEquals(0, f.getTamanhoCache());
    }

    @Test
    public void testNomeVazioRetornaNulo() {
        FabricaIngredientesFlyweight f = new FabricaIngredientesFlyweight();
        assertNull(f.getIngrediente("", 1.0));
        assertEquals(0, f.getTamanhoCache());
    }

    @Test
    public void testNomeApenasEspacosRetornaNulo() {
        FabricaIngredientesFlyweight f = new FabricaIngredientesFlyweight();
        assertNull(f.getIngrediente("   ", 1.0));
        assertEquals(0, f.getTamanhoCache());
    }

    @Test
    public void testCustoIgnoradoNoReuso() {
        FabricaIngredientesFlyweight f = new FabricaIngredientesFlyweight();
        IngredienteFlyweight i1 = f.getIngrediente("Ovo", 1.0);
        IngredienteFlyweight i2 = f.getIngrediente("Ovo", 99.0);
        assertSame(i1, i2);
        assertEquals(1.0, i2.getCusto());
    }

    @Test
    public void testInstanciaValida() {
        assertNotNull(new FabricaIngredientesFlyweight());
    }
}
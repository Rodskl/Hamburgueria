package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FabricaIngredientesTest {

    @Test
    public void testCriarPaoValido() {
        FabricaIngredientes f = new FabricaIngredientes() {
            public Pao criarPao() { return () -> "Brioche"; }
            public Carne criarCarne() { return () -> "Bovina"; }
        };
        assertEquals("Brioche", f.criarPao().getTipo());
    }

    @Test
    public void testCriarCarneValida() {    
        FabricaIngredientes f = new FabricaIngredientes() {
            public Pao criarPao() { return () -> "Brioche"; }
            public Carne criarCarne() { return () -> "Bovina"; }
        };
        assertEquals("Bovina", f.criarCarne().getTipo());
    }

    @Test
    public void testCriarPaoNulo() {
        FabricaIngredientes f = new FabricaIngredientes() {
            public Pao criarPao() { return null; }
            public Carne criarCarne() { return () -> "Bovina"; }
        };
        assertNull(f.criarPao());
    }

    @Test
    public void testCriarCarneNula() {
        FabricaIngredientes f = new FabricaIngredientes() {
            public Pao criarPao() { return () -> "Brioche"; }
            public Carne criarCarne() { return null; }
        };
        assertNull(f.criarCarne());
    }

    @Test
    public void testAmbosNulos() {
        FabricaIngredientes f = new FabricaIngredientes() {
            public Pao criarPao() { return null; }
            public Carne criarCarne() { return null; }
        };
        assertNull(f.criarPao());
        assertNull(f.criarCarne());
    }

    @Test
    public void testMultiplasChamadasPao() {
        FabricaIngredientes f = new FabricaIngredientes() {
            public Pao criarPao() { return () -> "Fixo"; }
            public Carne criarCarne() { return () -> "Fixo"; }
        };
        assertEquals(f.criarPao().getTipo(), f.criarPao().getTipo());
    }

    @Test
    public void testMultiplasChamadasCarne() {
        FabricaIngredientes f = new FabricaIngredientes() {
            public Pao criarPao() { return () -> "Fixo"; }
            public Carne criarCarne() { return () -> "Fixo"; }
        };
        assertEquals(f.criarCarne().getTipo(), f.criarCarne().getTipo());
    }

   @Test
    public void testConsistenciaInstanciaPao() {
        FabricaIngredientes f = new FabricaIngredientes() {
            public Pao criarPao() { return () -> "Fixo"; }
            public Carne criarCarne() { return () -> "Fixo"; }
        };
        assertNotNull(f.criarPao());
    }

    @Test
    public void testConsistenciaInstanciaCarne() {
        FabricaIngredientes f = new FabricaIngredientes() {
            public Pao criarPao() { return () -> "Fixo"; }
            public Carne criarCarne() { return () -> "Fixo"; }
        };
        assertNotNull(f.criarCarne());
    }

    @Test
    public void testPolimorfismoFabrica() {
        FabricaIngredientes f = new FabricaIngredientes() {
            public Pao criarPao() { return () -> "A"; }
            public Carne criarCarne() { return () -> "B"; }
        };
        assertTrue(f instanceof FabricaIngredientes);
    }
}
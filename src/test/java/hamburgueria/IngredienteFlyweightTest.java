package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IngredienteFlyweightTest {

    @Test
    public void testContratoNomeValido() {
        IngredienteFlyweight i = new IngredienteFlyweight() {
            public String getNome() { return "Ketchup"; }
            public double getCusto() { return 1.0; }
            public String adicionarAoLanche(String c) { return c; }
        };
        assertEquals("Ketchup", i.getNome());
    }

    @Test
    public void testContratoCustoValido() {
        IngredienteFlyweight i = new IngredienteFlyweight() {
            public String getNome() { return "Mostarda"; }
            public double getCusto() { return 0.5; }
            public String adicionarAoLanche(String c) { return c; }
        };
        assertEquals(0.5, i.getCusto());
    }

    @Test
    public void testContratoAdicionarAoLanche() {
        IngredienteFlyweight i = new IngredienteFlyweight() {
            public String getNome() { return "Maionese"; }
            public double getCusto() { return 1.0; }
            public String adicionarAoLanche(String c) { return c + " com Maionese"; }
        };
        assertEquals("X-Burger com Maionese", i.adicionarAoLanche("X-Burger"));
    }

    @Test
    public void testContratoNomeNulo() {
        IngredienteFlyweight i = new IngredienteFlyweight() {
            public String getNome() { return null; }
            public double getCusto() { return 10.0; }
            public String adicionarAoLanche(String c) { return c; }
        };
        assertNull(i.getNome());
    }

    @Test
    public void testContratoCustoZero() {
        IngredienteFlyweight i = new IngredienteFlyweight() {
            public String getNome() { return "Agua"; }
            public double getCusto() { return 0.0; }
            public String adicionarAoLanche(String c) { return c; }
        };
        assertEquals(0.0, i.getCusto());
    }

    @Test
    public void testPolimorfismoInterface() {
        IngredienteFlyweight i = new IngredienteFlyweight() {
            public String getNome() { return "Teste"; }
            public double getCusto() { return 1.0; }
            public String adicionarAoLanche(String c) { return c; }
        };
        assertTrue(i instanceof IngredienteFlyweight);
    }

    @Test
    public void testContextoNulo() {
        IngredienteFlyweight i = new IngredienteFlyweight() {
            public String getNome() { return "Teste"; }
            public double getCusto() { return 1.0; }
            public String adicionarAoLanche(String c) { return c == null ? "Nulo" : c; }
        };
        assertEquals("Nulo", i.adicionarAoLanche(null));
    }

    @Test
    public void testInstanciaAnonima() {
        assertNotNull((IngredienteFlyweight) new IngredienteFlyweight() {
            public String getNome() { return "A"; }
            public double getCusto() { return 1.0; }
            public String adicionarAoLanche(String c) { return c; }
        });
    }

    @Test
    public void testExcecaoNaImplementacao() {
        IngredienteFlyweight i = new IngredienteFlyweight() {
            public String getNome() { throw new RuntimeException(); }
            public double getCusto() { return 1.0; }
            public String adicionarAoLanche(String c) { return c; }
        };
        assertThrows(RuntimeException.class, i::getNome);
    }

    @Test
    public void testMultiplasChamadas() {
        IngredienteFlyweight i = new IngredienteFlyweight() {
            public String getNome() { return "Fixo"; }
            public double getCusto() { return 1.0; }
            public String adicionarAoLanche(String c) { return c; }
        };
        assertEquals(i.getNome(), i.getNome());
    }
}
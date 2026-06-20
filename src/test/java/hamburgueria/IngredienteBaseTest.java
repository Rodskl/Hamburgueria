package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IngredienteBaseTest {

    @Test
    public void testConstrutorGetterNome() {
        IngredienteBase i = new IngredienteBase("Cheddar", 3.0);
        assertEquals("Cheddar", i.getNome());
    }

    @Test
    public void testConstrutorGetterCusto() {
        IngredienteBase i = new IngredienteBase("Cheddar", 3.0);
        assertEquals(3.0, i.getCusto());
    }

    @Test
    public void testNomeNulo() {
        IngredienteBase i = new IngredienteBase(null, 1.0);
        assertNull(i.getNome());
    }

    @Test
    public void testCustoZero() {
        IngredienteBase i = new IngredienteBase("Alface", 0.0);
        assertEquals(0.0, i.getCusto());
    }

    @Test
    public void testCustoNegativo() {
        IngredienteBase i = new IngredienteBase("Desconto", -1.0);
        assertEquals(-1.0, i.getCusto());
    }

    @Test
    public void testAdicionarAoLancheValido() {
        IngredienteBase i = new IngredienteBase("Bacon", 4.0);
        assertEquals("X-Salada recebe Bacon", i.adicionarAoLanche("X-Salada"));
    }

    @Test
    public void testAdicionarAoLancheNulo() {
        IngredienteBase i = new IngredienteBase("Bacon", 4.0);
        assertEquals("Pedido sem identificacao recebe Bacon", i.adicionarAoLanche(null));
    }

    @Test
    public void testAdicionarAoLancheVazio() {
        IngredienteBase i = new IngredienteBase("Ovo", 2.0);
        assertEquals(" recebe Ovo", i.adicionarAoLanche(""));
    }

    @Test
    public void testPolimorfismoFlyweight() {
        IngredienteBase i = new IngredienteBase("Pao", 1.0);
        assertTrue(i instanceof IngredienteFlyweight);
    }

    @Test
    public void testImutabilidadeAparente() {
        IngredienteBase i = new IngredienteBase("Carne", 5.0);
        assertEquals(5.0, i.getCusto());
        assertEquals("Carne", i.getNome());
    }
}
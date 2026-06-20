package hamburgueria;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class EstadoLancheTest {

    @Test
    public void testRetornoCopiaDosIngredientes() {
        List<String> lista = new ArrayList<>();
        lista.add("Pao");
        EstadoLanche e = new EstadoLanche(lista);
        assertEquals(1, e.getIngredientes().size());
        assertEquals("Pao", e.getIngredientes().get(0));
    }

    @Test
    public void testConstrutorNulo() {
        EstadoLanche e = new EstadoLanche(null);
        assertTrue(e.getIngredientes().isEmpty());
    }

    @Test
    public void testImutabilidadeExterna() {
        List<String> original = new ArrayList<>();
        original.add("Carne");
        EstadoLanche e = new EstadoLanche(original);
        original.add("Queijo");
        assertEquals(1, e.getIngredientes().size());
    }

    @Test
    public void testImutabilidadePeloGetter() {
        EstadoLanche e = new EstadoLanche(new ArrayList<>());
        List<String> copia = e.getIngredientes();
        copia.add("Alface");
        assertTrue(e.getIngredientes().isEmpty());
    }

    @Test
    public void testOrdemIngredientesPreservada() {
        List<String> lista = new ArrayList<>();
        lista.add("A");
        lista.add("B");
        EstadoLanche e = new EstadoLanche(lista);
        assertEquals("A", e.getIngredientes().get(0));
        assertEquals("B", e.getIngredientes().get(1));
    }

    @Test
    public void testVazio() {
        EstadoLanche e = new EstadoLanche(new ArrayList<>());
        assertTrue(e.getIngredientes().isEmpty());
    }

    @Test
    public void testInstanciaNaoNula() {
        assertNotNull(new EstadoLanche(new ArrayList<>()));
    }

    @Test
    public void testIndependenciaDeInstancias() {
        List<String> l1 = new ArrayList<>(); l1.add("A");
        List<String> l2 = new ArrayList<>(); l2.add("B");
        EstadoLanche e1 = new EstadoLanche(l1);
        EstadoLanche e2 = new EstadoLanche(l2);
        assertNotEquals(e1.getIngredientes().get(0), e2.getIngredientes().get(0));
    }

    @Test
    public void testMultiplasChamadasGetter() {
        EstadoLanche e = new EstadoLanche(new ArrayList<>());
        assertNotSame(e.getIngredientes(), e.getIngredientes());
    }

    @Test
    public void testTipoDaClasse() {
        EstadoLanche e = new EstadoLanche(new ArrayList<>());
        assertEquals(EstadoLanche.class, e.getClass());
    }
}
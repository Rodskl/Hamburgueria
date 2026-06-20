package hamburgueria;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MontadorLancheTest {

    @Test
    public void testEstadoInicialVazio() {
        MontadorLanche m = new MontadorLanche();
        assertTrue(m.getIngredientes().isEmpty());
    }

    @Test
    public void testAdicionarIngredienteValido() {
        MontadorLanche m = new MontadorLanche();
        m.adicionarIngrediente("Bacon");
        assertEquals(1, m.getIngredientes().size());
        assertEquals("Bacon", m.getIngredientes().get(0));
    }

    @Test
    public void testAdicionarIngredienteNulo() {
        MontadorLanche m = new MontadorLanche();
        m.adicionarIngrediente(null);
        assertTrue(m.getIngredientes().isEmpty());
    }

    @Test
    public void testAdicionarIngredienteVazio() {
        MontadorLanche m = new MontadorLanche();
        m.adicionarIngrediente("   ");
        assertTrue(m.getIngredientes().isEmpty());
    }

    @Test
    public void testSalvarEstado() {
        MontadorLanche m = new MontadorLanche();
        m.adicionarIngrediente("Ovo");
        EstadoLanche e = m.salvarEstado();
        assertEquals(1, e.getIngredientes().size());
    }

    @Test
    public void testRestaurarEstadoValido() {
        MontadorLanche m = new MontadorLanche();
        m.adicionarIngrediente("Pao");
        EstadoLanche e = m.salvarEstado();
        m.adicionarIngrediente("Carne");
        m.restaurarEstado(e);
        assertEquals(1, m.getIngredientes().size());
        assertEquals("Pao", m.getIngredientes().get(0));
    }

    @Test
    public void testRestaurarEstadoNulo() {
        MontadorLanche m = new MontadorLanche();
        m.adicionarIngrediente("Queijo");
        m.restaurarEstado(null);
        assertEquals(1, m.getIngredientes().size());
    }

    @Test
    public void testGetIngredientesImutavel() {
        MontadorLanche m = new MontadorLanche();
        m.adicionarIngrediente("Salada");
        List<String> copia = m.getIngredientes();
        copia.clear();
        assertFalse(m.getIngredientes().isEmpty());
    }

    @Test
    public void testSalvarMultiplosEstados() {
        MontadorLanche m = new MontadorLanche();
        m.adicionarIngrediente("A");
        EstadoLanche e1 = m.salvarEstado();
        m.adicionarIngrediente("B");
        EstadoLanche e2 = m.salvarEstado();
        assertNotEquals(e1.getIngredientes().size(), e2.getIngredientes().size());
    }

    @Test
    public void testRestauracaoAlteraListaInternaCompleta() {
        MontadorLanche m = new MontadorLanche();
        m.adicionarIngrediente("X");
        m.adicionarIngrediente("Y");
        EstadoLanche vazio = new EstadoLanche(new ArrayList<>());
        m.restaurarEstado(vazio);
        assertTrue(m.getIngredientes().isEmpty());
    }
}
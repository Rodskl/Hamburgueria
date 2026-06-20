package hamburgueria;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class MenuAgregadoTest {

    @Test
    public void testCriarIteradorNaoNulo() {
        MenuAgregado m = new MenuAgregado() {
            public IteradorCardapio criarIterador() { return new IteradorItens(new ArrayList<>()); }
        };
        assertNotNull(m.criarIterador());
    }

    @Test
    public void testCriarIteradorRetornaNulo() {
        MenuAgregado m = new MenuAgregado() {
            public IteradorCardapio criarIterador() { return null; }
        };
        assertNull(m.criarIterador());
    }

    @Test
    public void testPolimorfismoInterface() {
        MenuAgregado m = new MenuAgregado() {
            public IteradorCardapio criarIterador() { return null; }
        };
        assertTrue(m instanceof MenuAgregado);
    }

    @Test
    public void testMultiplasChamadasCriarIterador() {
        MenuAgregado m = new MenuAgregado() {
            IteradorCardapio it = new IteradorItens(new ArrayList<>());
            public IteradorCardapio criarIterador() { return it; }
        };
        assertEquals(m.criarIterador(), m.criarIterador());
    }

    @Test
    public void testInstanciasDiferentesDeIterador() {
        MenuAgregado m = new MenuAgregado() {
            public IteradorCardapio criarIterador() { return new IteradorItens(new ArrayList<>()); }
        };
        assertNotSame(m.criarIterador(), m.criarIterador());
    }

    @Test
    public void testExcecaoNaCriacao() {
        MenuAgregado m = new MenuAgregado() {
            public IteradorCardapio criarIterador() { throw new RuntimeException(); }
        };
        assertThrows(RuntimeException.class, m::criarIterador);
    }

    @Test
    public void testInstanciaAnonima() {
        assertNotNull((MenuAgregado) () -> null);
    }

    @Test
    public void testRetornoImplementaIterador() {
        MenuAgregado m = new MenuAgregado() {
            public IteradorCardapio criarIterador() { return new IteradorItens(new ArrayList<>()); }
        };
        assertTrue(m.criarIterador() instanceof IteradorCardapio);
    }

    @Test
    public void testVariavelExterna() {
        final boolean[] flag = {false};
        MenuAgregado m = () -> { flag[0] = true; return null; };
        m.criarIterador();
        assertTrue(flag[0]);
    }

    @Test
    public void testSemAcessoAoEstadoInterno() {
        MenuAgregado m = () -> new IteradorItens(new ArrayList<>());
        assertFalse(m.criarIterador().hasNext());
    }
}
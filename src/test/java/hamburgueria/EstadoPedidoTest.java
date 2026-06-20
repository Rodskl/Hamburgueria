package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstadoPedidoTest {

    @Test
    public void testGetNome() {
        EstadoPedido e = new EstadoPedido() {
            public void avancar(PedidoFluxo p) {}
            public String getNome() { return "Teste"; }
        };
        assertEquals("Teste", e.getNome());
    }

    @Test
    public void testAvancar() {
        final boolean[] chamado = {false};
        EstadoPedido e = new EstadoPedido() {
            public void avancar(PedidoFluxo p) { chamado[0] = true; }
            public String getNome() { return "Teste"; }
        };
        e.avancar(new PedidoFluxo());
        assertTrue(chamado[0]);
    }

    @Test
    public void testGetNomeNull() {
        EstadoPedido e = new EstadoPedido() {
            public void avancar(PedidoFluxo p) {}
            public String getNome() { return null; }
        };
        assertNull(e.getNome());
    }

    @Test
    public void testGetNomeEmpty() {
        EstadoPedido e = new EstadoPedido() {
            public void avancar(PedidoFluxo p) {}
            public String getNome() { return ""; }
        };
        assertEquals("", e.getNome());
    }

    @Test
    public void testPolimorfismo() {
        EstadoPedido e = new EstadoPedido() {
            public void avancar(PedidoFluxo p) {}
            public String getNome() { return "P"; }
        };
        assertTrue(e instanceof EstadoPedido);
    }

    @Test
    public void testAvancarModificaEstado() {
        PedidoFluxo fluxo = new PedidoFluxo();
        EstadoPedido e = new EstadoPedido() {
            public void avancar(PedidoFluxo p) { p.setEstado(null); }
            public String getNome() { return "X"; }
        };
        e.avancar(fluxo);
        assertNull(fluxo.getEstado());
    }

    @Test
    public void testMultiplasChamadasGetNome() {
        EstadoPedido e = new EstadoPedido() {
            public void avancar(PedidoFluxo p) {}
            public String getNome() { return "Fixo"; }
        };
        assertEquals(e.getNome(), e.getNome());
    }

    @Test
    public void testMultiplasChamadasAvancar() {
        final int[] contagem = {0};
        EstadoPedido e = new EstadoPedido() {
            public void avancar(PedidoFluxo p) { contagem[0]++; }
            public String getNome() { return ""; }
        };
        e.avancar(null);
        e.avancar(null);
        assertEquals(2, contagem[0]);
    }

    @Test
    public void testInstanciaAnonima() {
        assertNotNull((EstadoPedido) new EstadoPedido() {
            public void avancar(PedidoFluxo p) {}
            public String getNome() { return "A"; }
        });
    }

    @Test
    public void testExcecaoEmAvancar() {
        EstadoPedido e = new EstadoPedido() {
            public void avancar(PedidoFluxo p) { throw new RuntimeException(); }
            public String getNome() { return "Erro"; }
        };
        assertThrows(RuntimeException.class, () -> e.avancar(null));
    }
}
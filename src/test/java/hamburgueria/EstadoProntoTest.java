package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstadoProntoTest {

    @Test
    public void testGetNomeCorreto() {
        EstadoPronto e = new EstadoPronto();
        assertEquals("Pronto", e.getNome());
    }

    @Test
    public void testAvancarNaoMudaEstado() {
        EstadoPronto e = new EstadoPronto();
        PedidoFluxo p = new PedidoFluxo();
        p.setEstado(e);
        e.avancar(p);
        assertEquals(e, p.getEstado());
    }

    @Test
    public void testAvancarComPedidoNulo() {
        EstadoPronto e = new EstadoPronto();
        assertDoesNotThrow(() -> e.avancar(null));
    }

    @Test
    public void testPolimorfismoInterface() {
        EstadoPronto e = new EstadoPronto();
        assertTrue(e instanceof EstadoPedido);
    }

    @Test
    public void testNaoRetornaNulo() {
        EstadoPronto e = new EstadoPronto();
        assertNotNull(e.getNome());
    }

    @Test
    public void testNaoRetornaVazio() {
        EstadoPronto e = new EstadoPronto();
        assertNotEquals("", e.getNome());
    }

    @Test
    public void testInstanciaUnica() {
        EstadoPronto e1 = new EstadoPronto();
        EstadoPronto e2 = new EstadoPronto();
        assertNotSame(e1, e2);
    }

    @Test
    public void testMultiplasChamadasGetNome() {
        EstadoPronto e = new EstadoPronto();
        assertEquals(e.getNome(), e.getNome());
    }

    @Test
    public void testComportamentoIdempotente() {
        EstadoPronto e = new EstadoPronto();
        PedidoFluxo p = new PedidoFluxo();
        p.setEstado(e);
        e.avancar(p);
        e.avancar(p);
        assertEquals("Pronto", p.getStatus());
    }

    @Test
    public void testTipoDaClasse() {
        EstadoPedido e = new EstadoPronto();
        assertEquals(EstadoPronto.class, e.getClass());
    }
}
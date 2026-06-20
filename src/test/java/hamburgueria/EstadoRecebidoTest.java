package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstadoRecebidoTest {

    @Test
    public void testGetNomeCorreto() {
        EstadoRecebido e = new EstadoRecebido();
        assertEquals("Recebido", e.getNome());
    }

    @Test
    public void testAvancarMudaParaEmPreparo() {
        EstadoRecebido e = new EstadoRecebido();
        PedidoFluxo p = new PedidoFluxo();
        e.avancar(p);
        assertTrue(p.getEstado() instanceof EstadoEmPreparo);
    }

    @Test
    public void testAvancarComPedidoNulo() {
        EstadoRecebido e = new EstadoRecebido();
        assertDoesNotThrow(() -> e.avancar(null));
    }

    @Test
    public void testPolimorfismoInterface() {
        EstadoRecebido e = new EstadoRecebido();
        assertTrue(e instanceof EstadoPedido);
    }

    @Test
    public void testNaoRetornaNulo() {
        EstadoRecebido e = new EstadoRecebido();
        assertNotNull(e.getNome());
    }

    @Test
    public void testNaoRetornaVazio() {
        EstadoRecebido e = new EstadoRecebido();
        assertNotEquals("", e.getNome());
    }

    @Test
    public void testInstanciaUnica() {
        EstadoRecebido e1 = new EstadoRecebido();
        EstadoRecebido e2 = new EstadoRecebido();
        assertNotSame(e1, e2);
    }

    @Test
    public void testMultiplasChamadasGetNome() {
        EstadoRecebido e = new EstadoRecebido();
        assertEquals(e.getNome(), e.getNome());
    }

    @Test
    public void testTransicaoCorreta() {
        EstadoRecebido e = new EstadoRecebido();
        PedidoFluxo p = new PedidoFluxo();
        e.avancar(p);
        assertEquals("Em Preparo", p.getStatus());
    }

    @Test
    public void testTipoDaClasse() {
        EstadoPedido e = new EstadoRecebido();
        assertEquals(EstadoRecebido.class, e.getClass());
    }
}
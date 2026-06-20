package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstadoEmPreparoTest {

    @Test
    public void testGetNomeCorreto() {
        EstadoEmPreparo e = new EstadoEmPreparo();
        assertEquals("Em Preparo", e.getNome());
    }

    @Test
    public void testAvancarMudaParaPronto() {
        EstadoEmPreparo e = new EstadoEmPreparo();
        PedidoFluxo p = new PedidoFluxo();
        e.avancar(p);
        assertTrue(p.getEstado() instanceof EstadoPronto);
    }

    @Test
    public void testAvancarComPedidoNulo() {
        EstadoEmPreparo e = new EstadoEmPreparo();
        assertDoesNotThrow(() -> e.avancar(null));
    }

    @Test
    public void testPolimorfismoInterface() {
        EstadoEmPreparo e = new EstadoEmPreparo();
        assertTrue(e instanceof EstadoPedido);
    }

    @Test
    public void testNaoRetornaNulo() {
        EstadoEmPreparo e = new EstadoEmPreparo();
        assertNotNull(e.getNome());
    }

    @Test
    public void testNaoRetornaVazio() {
        EstadoEmPreparo e = new EstadoEmPreparo();
        assertNotEquals("", e.getNome());
    }

    @Test
    public void testInstanciaUnica() {
        EstadoEmPreparo e1 = new EstadoEmPreparo();
        EstadoEmPreparo e2 = new EstadoEmPreparo();
        assertNotSame(e1, e2);
    }

    @Test
    public void testMultiplasChamadasGetNome() {
        EstadoEmPreparo e = new EstadoEmPreparo();
        assertEquals(e.getNome(), e.getNome());
    }

    @Test
    public void testTransicaoCorreta() {
        EstadoEmPreparo e = new EstadoEmPreparo();
        PedidoFluxo p = new PedidoFluxo();
        e.avancar(p);
        assertEquals("Pronto", p.getStatus());
    }

    @Test
    public void testTipoDaClasse() {
        EstadoPedido e = new EstadoEmPreparo();
        assertEquals(EstadoEmPreparo.class, e.getClass());
    }
}
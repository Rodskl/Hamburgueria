package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoFluxoTest {

    @Test
    public void testEstadoInicial() {
        PedidoFluxo p = new PedidoFluxo();
        assertTrue(p.getEstado() instanceof EstadoRecebido);
    }

    @Test
    public void testAvancarParaEmPreparo() {
        PedidoFluxo p = new PedidoFluxo();
        p.avancar();
        assertTrue(p.getEstado() instanceof EstadoEmPreparo);
    }

    @Test
    public void testAvancarParaPronto() {
        PedidoFluxo p = new PedidoFluxo();
        p.avancar();
        p.avancar();
        assertTrue(p.getEstado() instanceof EstadoPronto);
    }

    @Test
    public void testGetStatusInicial() {
        PedidoFluxo p = new PedidoFluxo();
        assertEquals("Recebido", p.getStatus());
    }

    @Test
    public void testSetEstadoManual() {
        PedidoFluxo p = new PedidoFluxo();
        p.setEstado(new EstadoPronto());
        assertTrue(p.getEstado() instanceof EstadoPronto);
    }

    @Test
    public void testSetEstadoNulo() {
        PedidoFluxo p = new PedidoFluxo();
        p.setEstado(null);
        assertNull(p.getEstado());
    }

    @Test
    public void testGetStatusQuandoEstadoNulo() {
        PedidoFluxo p = new PedidoFluxo();
        p.setEstado(null);
        assertEquals("Sem Estado", p.getStatus());
    }

    @Test
    public void testAvancarQuandoEstadoNulo() {
        PedidoFluxo p = new PedidoFluxo();
        p.setEstado(null);
        assertDoesNotThrow(p::avancar);
        assertNull(p.getEstado());
    }

    @Test
    public void testPermanenciaEstadoPronto() {
        PedidoFluxo p = new PedidoFluxo();
        p.setEstado(new EstadoPronto());
        p.avancar();
        assertTrue(p.getEstado() instanceof EstadoPronto);
    }

    @Test
    public void testFluxoCompletoStatus() {
        PedidoFluxo p = new PedidoFluxo();
        assertEquals("Recebido", p.getStatus());
        p.avancar();
        assertEquals("Em Preparo", p.getStatus());
        p.avancar();
        assertEquals("Pronto", p.getStatus());
    }
}
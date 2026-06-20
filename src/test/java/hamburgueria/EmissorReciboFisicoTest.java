package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmissorReciboFisicoTest {

    @Test
    public void testEmitirSucesso() {
        EmissorReciboFisico e = new EmissorReciboFisico();
        assertEquals("Imprimindo recibo fisico: Combo 1 - R$35.5", e.emitir("Combo 1", 35.5));
    }

    @Test
    public void testEmitirValorZero() {
        EmissorReciboFisico e = new EmissorReciboFisico();
        assertEquals("Imprimindo recibo fisico: Brinde - R$0.0", e.emitir("Brinde", 0.0));
    }

    @Test
    public void testEmitirValorNegativo() {
        EmissorReciboFisico e = new EmissorReciboFisico();
        assertEquals("Imprimindo recibo fisico: Estorno - R$-15.0", e.emitir("Estorno", -15.0));
    }

    @Test
    public void testEmitirPedidoNulo() {
        EmissorReciboFisico e = new EmissorReciboFisico();
        assertEquals("Imprimindo recibo fisico: null - R$20.0", e.emitir(null, 20.0));
    }

    @Test
    public void testEmitirPedidoVazio() {
        EmissorReciboFisico e = new EmissorReciboFisico();
        assertEquals("Imprimindo recibo fisico:  - R$10.0", e.emitir("", 10.0));
    }

    @Test
    public void testPolimorfismo() {
        EmissorRecibo e = new EmissorReciboFisico();
        assertTrue(e instanceof EmissorRecibo);
    }

    @Test
    public void testNaoRetornaNulo() {
        EmissorReciboFisico e = new EmissorReciboFisico();
        assertNotNull(e.emitir("Teste", 5.0));
    }

    @Test
    public void testTamanhoStringRetorno() {
        EmissorReciboFisico e = new EmissorReciboFisico();
        assertTrue(e.emitir("A", 1.0).length() > 20);
    }

    @Test
    public void testInstanciaValida() {
        assertNotNull(new EmissorReciboFisico());
    }

    @Test
    public void testMultiplasChamadas() {
        EmissorReciboFisico e = new EmissorReciboFisico();
        assertNotEquals(e.emitir("A", 10.0), e.emitir("B", 10.0));
    }
}
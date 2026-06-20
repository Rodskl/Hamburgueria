package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmissorReciboDigitalTest {

    @Test
    public void testEmitirSucesso() {
        EmissorReciboDigital e = new EmissorReciboDigital();
        assertEquals("Enviando recibo digital: Combo 2 - R$45.0", e.emitir("Combo 2", 45.0));
    }

    @Test
    public void testEmitirValorZero() {
        EmissorReciboDigital e = new EmissorReciboDigital();
        assertEquals("Enviando recibo digital: Agua - R$0.0", e.emitir("Agua", 0.0));
    }

    @Test
    public void testEmitirValorNegativo() {
        EmissorReciboDigital e = new EmissorReciboDigital();
        assertEquals("Enviando recibo digital: Promocao - R$-5.0", e.emitir("Promocao", -5.0));
    }

    @Test
    public void testEmitirPedidoNulo() {
        EmissorReciboDigital e = new EmissorReciboDigital();
        assertEquals("Enviando recibo digital: null - R$12.0", e.emitir(null, 12.0));
    }

    @Test
    public void testEmitirPedidoVazio() {
        EmissorReciboDigital e = new EmissorReciboDigital();
        assertEquals("Enviando recibo digital:  - R$8.0", e.emitir("", 8.0));
    }

    @Test
    public void testPolimorfismo() {
        EmissorRecibo e = new EmissorReciboDigital();
        assertTrue(e instanceof EmissorRecibo);
    }

    @Test
    public void testNaoRetornaNulo() {
        EmissorReciboDigital e = new EmissorReciboDigital();
        assertNotNull(e.emitir("Teste", 5.0));
    }

    @Test
    public void testTamanhoStringRetorno() {
        EmissorReciboDigital e = new EmissorReciboDigital();
        assertTrue(e.emitir("A", 1.0).length() > 20);
    }

    @Test
    public void testInstanciaValida() {
        assertNotNull(new EmissorReciboDigital());
    }

    @Test
    public void testMultiplasChamadas() {
        EmissorReciboDigital e = new EmissorReciboDigital();
        assertNotEquals(e.emitir("A", 10.0), e.emitir("B", 10.0));
    }
}
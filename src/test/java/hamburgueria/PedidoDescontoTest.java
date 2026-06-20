package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoDescontoTest {

    @Test
    public void testValorPositivo() {
        PedidoDesconto p = new PedidoDesconto(15.50);
        assertEquals(15.50, p.getValor());
    }

    @Test
    public void testValorZero() {
        PedidoDesconto p = new PedidoDesconto(0.0);
        assertEquals(0.0, p.getValor());
    }

    @Test
    public void testValorNegativo() {
        PedidoDesconto p = new PedidoDesconto(-5.0);
        assertEquals(-5.0, p.getValor());
    }

    @Test
    public void testValorAlto() {
        PedidoDesconto p = new PedidoDesconto(1000.0);
        assertEquals(1000.0, p.getValor());
    }

    @Test
    public void testMultiplasInstancias() {
        PedidoDesconto p1 = new PedidoDesconto(10.0);
        PedidoDesconto p2 = new PedidoDesconto(20.0);
        assertNotEquals(p1.getValor(), p2.getValor());
    }

    @Test
    public void testInstanciaNaoNula() {
        assertNotNull(new PedidoDesconto(5.0));
    }

    @Test
    public void testConsistenciaDoRetorno() {
        PedidoDesconto p = new PedidoDesconto(7.77);
        assertEquals(p.getValor(), p.getValor());
    }

    @Test
    public void testTipoDaClasse() {
        PedidoDesconto p = new PedidoDesconto(1.0);
        assertEquals(PedidoDesconto.class, p.getClass());
    }

    @Test
    public void testValorDecimalPequeno() {
        PedidoDesconto p = new PedidoDesconto(0.01);
        assertEquals(0.01, p.getValor());
    }

    @Test
    public void testValorMaximoDouble() {
        PedidoDesconto p = new PedidoDesconto(Double.MAX_VALUE);
        assertEquals(Double.MAX_VALUE, p.getValor());
    }
}
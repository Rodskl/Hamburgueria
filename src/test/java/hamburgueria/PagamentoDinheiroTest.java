package hamburgueria;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class PagamentoDinheiroTest {

    @Test
    public void testPagamentoExato() {
        PagamentoDinheiro p = new PagamentoDinheiro(new BigDecimal("50.00"));
        assertTrue(p.pagar(new BigDecimal("50.00")));
    }

    @Test
    public void testPagamentoComSobras() {
        PagamentoDinheiro p = new PagamentoDinheiro(new BigDecimal("100.00"));
        assertTrue(p.pagar(new BigDecimal("75.50")));
    }

    @Test
    public void testPagamentoInsuficiente() {
        PagamentoDinheiro p = new PagamentoDinheiro(new BigDecimal("20.00"));
        assertFalse(p.pagar(new BigDecimal("25.00")));
    }

    @Test
    public void testValorPedidoNulo() {
        PagamentoDinheiro p = new PagamentoDinheiro(new BigDecimal("50.00"));
        assertFalse(p.pagar(null));
    }

    @Test
    public void testValorEntregueNulo() {
        PagamentoDinheiro p = new PagamentoDinheiro(null);
        assertFalse(p.pagar(new BigDecimal("10.00")));
    }

    @Test
    public void testValorPedidoZero() {
        PagamentoDinheiro p = new PagamentoDinheiro(new BigDecimal("10.00"));
        assertFalse(p.pagar(BigDecimal.ZERO));
    }

    @Test
    public void testValorPedidoNegativo() {
        PagamentoDinheiro p = new PagamentoDinheiro(new BigDecimal("10.00"));
        assertFalse(p.pagar(new BigDecimal("-5.00")));
    }

    @Test
    public void testTrocoPagamentoExato() {
        PagamentoDinheiro p = new PagamentoDinheiro(new BigDecimal("30.00"));
        assertEquals(0, p.getTroco(new BigDecimal("30.00")).compareTo(BigDecimal.ZERO));
    }

    @Test
    public void testTrocoPagamentoComSobras() {
        PagamentoDinheiro p = new PagamentoDinheiro(new BigDecimal("50.00"));
        assertEquals(0, p.getTroco(new BigDecimal("35.00")).compareTo(new BigDecimal("15.00")));
    }

    @Test
    public void testTrocoPagamentoInsuficiente() {
        PagamentoDinheiro p = new PagamentoDinheiro(new BigDecimal("10.00"));
        assertEquals(0, p.getTroco(new BigDecimal("20.00")).compareTo(BigDecimal.ZERO));
    }
}
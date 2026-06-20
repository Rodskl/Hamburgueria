package hamburgueria;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class PagamentoCartaoTest {

    @Test
    public void testPagamentoCartaoValido() {
        PagamentoCartao p = new PagamentoCartao("1234567890123456", "123");
        assertTrue(p.pagar(new BigDecimal("45.00")));
    }

    @Test
    public void testCartaoCurto() {
        PagamentoCartao p = new PagamentoCartao("1234567890", "123");
        assertFalse(p.pagar(new BigDecimal("45.00")));
    }

    @Test
    public void testCartaoLongo() {
        PagamentoCartao p = new PagamentoCartao("1234567890123456789", "123");
        assertFalse(p.pagar(new BigDecimal("45.00")));
    }

    @Test
    public void testCartaoNulo() {
        PagamentoCartao p = new PagamentoCartao(null, "123");
        assertFalse(p.pagar(new BigDecimal("45.00")));
    }

    @Test
    public void testCvvCurto() {
        PagamentoCartao p = new PagamentoCartao("1234567890123456", "12");
        assertFalse(p.pagar(new BigDecimal("45.00")));
    }

    @Test
    public void testCvvLongo() {
        PagamentoCartao p = new PagamentoCartao("1234567890123456", "1234");
        assertFalse(p.pagar(new BigDecimal("45.00")));
    }

    @Test
    public void testCvvNulo() {
        PagamentoCartao p = new PagamentoCartao("1234567890123456", null);
        assertFalse(p.pagar(new BigDecimal("45.00")));
    }

    @Test
    public void testValorNulo() {
        PagamentoCartao p = new PagamentoCartao("1234567890123456", "123");
        assertFalse(p.pagar(null));
    }

    @Test
    public void testValorZero() {
        PagamentoCartao p = new PagamentoCartao("1234567890123456", "123");
        assertFalse(p.pagar(BigDecimal.ZERO));
    }

    @Test
    public void testValorNegativo() {
        PagamentoCartao p = new PagamentoCartao("1234567890123456", "123");
        assertFalse(p.pagar(new BigDecimal("-10.00")));
    }
}
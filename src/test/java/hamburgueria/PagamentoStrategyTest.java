package hamburgueria;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class PagamentoStrategyTest {

    @Test
    public void testImplementacaoAnonimaVerdadeiro() {
        PagamentoStrategy s = valor -> true;
        assertTrue(s.pagar(BigDecimal.TEN));
    }

    @Test
    public void testImplementacaoAnonimaFalso() {
        PagamentoStrategy s = valor -> false;
        assertFalse(s.pagar(BigDecimal.TEN));
    }

    @Test
    public void testCalculoTaxa() {
        PagamentoStrategy s = valor -> valor.compareTo(BigDecimal.TEN) > 0;
        assertTrue(s.pagar(new BigDecimal("15")));
    }

    @Test
    public void testIgualdadeExata() {
        PagamentoStrategy s = valor -> valor.equals(BigDecimal.ONE);
        assertTrue(s.pagar(BigDecimal.ONE));
    }

    @Test
    public void testValorZero() {
        PagamentoStrategy s = valor -> valor.equals(BigDecimal.ZERO);
        assertTrue(s.pagar(BigDecimal.ZERO));
    }

    @Test
    public void testValorNegativo() {
        PagamentoStrategy s = valor -> valor.compareTo(BigDecimal.ZERO) < 0;
        assertTrue(s.pagar(new BigDecimal("-5")));
    }

    @Test
    public void testExcecaoDentroDaImplementacao() {
        PagamentoStrategy s = valor -> { throw new RuntimeException(); };
        assertThrows(RuntimeException.class, () -> s.pagar(BigDecimal.TEN));
    }

    @Test
    public void testNullSafetyDentroDaImplementacao() {
        PagamentoStrategy s = valor -> valor != null;
        assertFalse(s.pagar(null));
    }

    @Test
    public void testComparacaoComScale() {
        PagamentoStrategy s = valor -> valor.compareTo(new BigDecimal("10.00")) == 0;
        assertTrue(s.pagar(new BigDecimal("10")));
    }

    @Test
    public void testLimitesMaximos() {
        PagamentoStrategy s = valor -> valor.compareTo(new BigDecimal("999999.99")) <= 0;
        assertTrue(s.pagar(new BigDecimal("500000.00")));
    }
}
package hamburgueria;


import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class ProcessadorPagamentoTest {

    @Test
    public void testEstrategiaNula() {
        ProcessadorPagamento p = new ProcessadorPagamento();
        assertThrows(IllegalStateException.class, () -> p.processar(BigDecimal.TEN));
    }

    @Test
    public void testProcessarComSucesso() {
        ProcessadorPagamento p = new ProcessadorPagamento();
        p.setEstrategia(valor -> true);
        assertTrue(p.processar(BigDecimal.TEN));
    }

    @Test
    public void testProcessarComFalha() {
        ProcessadorPagamento p = new ProcessadorPagamento();
        p.setEstrategia(valor -> false);
        assertFalse(p.processar(BigDecimal.TEN));
    }

    @Test
    public void testTrocaDeEstrategia() {
        ProcessadorPagamento p = new ProcessadorPagamento();
        p.setEstrategia(valor -> false);
        p.setEstrategia(valor -> true);
        assertTrue(p.processar(BigDecimal.TEN));
    }

    @Test
    public void testProcessarValorZero() {
        ProcessadorPagamento p = new ProcessadorPagamento();
        p.setEstrategia(valor -> valor.compareTo(BigDecimal.ZERO) == 0);
        assertTrue(p.processar(BigDecimal.ZERO));
    }

    @Test
    public void testProcessarValorNegativo() {
        ProcessadorPagamento p = new ProcessadorPagamento();
        p.setEstrategia(valor -> valor.compareTo(BigDecimal.ZERO) > 0);
        assertFalse(p.processar(new BigDecimal("-10")));
    }

    @Test
    public void testProcessarValorAlto() {
        ProcessadorPagamento p = new ProcessadorPagamento();
        p.setEstrategia(valor -> valor.compareTo(new BigDecimal("1000")) >= 0);
        assertTrue(p.processar(new BigDecimal("5000")));
    }

    @Test
    public void testMudancaMutuaDeEstrategias() {
        ProcessadorPagamento p = new ProcessadorPagamento();
        p.setEstrategia(valor -> true);
        assertTrue(p.processar(BigDecimal.ONE));
        p.setEstrategia(valor -> false);
        assertFalse(p.processar(BigDecimal.ONE));
    }

    @Test
    public void testValidarExcecaoEspecifica() {
        ProcessadorPagamento p = new ProcessadorPagamento();
        p.setEstrategia(valor -> { throw new IllegalArgumentException(); });
        assertThrows(IllegalArgumentException.class, () -> p.processar(BigDecimal.TEN));
    }

    @Test
    public void testReferenciaEstrategia() {
        ProcessadorPagamento p = new ProcessadorPagamento();
        PagamentoStrategy s = valor -> true;
        p.setEstrategia(s);
        assertTrue(p.processar(BigDecimal.TEN));
    }
}
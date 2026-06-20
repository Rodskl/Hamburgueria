package hamburgueria;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class PagamentoPixTest {

    @Test
    public void testPagamentoPixValido() {
        PagamentoPix p = new PagamentoPix("123.456.789-00");
        assertTrue(p.pagar(new BigDecimal("30.00")));
    }

    @Test
    public void testChaveNula() {
        PagamentoPix p = new PagamentoPix(null);
        assertFalse(p.pagar(new BigDecimal("30.00")));
    }

    @Test
    public void testChaveVazia() {
        PagamentoPix p = new PagamentoPix("");
        assertFalse(p.pagar(new BigDecimal("30.00")));
    }

    @Test
    public void testChaveComEspacosBrancos() {
        PagamentoPix p = new PagamentoPix("   ");
        assertFalse(p.pagar(new BigDecimal("30.00")));
    }

    @Test
    public void testValorNulo() {
        PagamentoPix p = new PagamentoPix("contato@hamburgueria.com");
        assertFalse(p.pagar(null));
    }

    @Test
    public void testValorZero() {
        PagamentoPix p = new PagamentoPix("contato@hamburgueria.com");
        assertFalse(p.pagar(BigDecimal.ZERO));
    }

    @Test
    public void testValorNegativo() {
        PagamentoPix p = new PagamentoPix("contato@hamburgueria.com");
        assertFalse(p.pagar(new BigDecimal("-15.00")));
    }

    @Test
    public void testChaveEmail() {
        PagamentoPix p = new PagamentoPix("cliente@email.com");
        assertTrue(p.pagar(new BigDecimal("100.00")));
    }

    @Test
    public void testChaveTelefone() {
        PagamentoPix p = new PagamentoPix("+5511999999999");
        assertTrue(p.pagar(new BigDecimal("50.00")));
    }

    @Test
    public void testChaveAleatoria() {
        PagamentoPix p = new PagamentoPix("123e4567-e89b-12d3-a456-426614174000");
        assertTrue(p.pagar(new BigDecimal("80.00")));
    }
}
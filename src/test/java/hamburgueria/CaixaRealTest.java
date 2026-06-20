package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CaixaRealTest {

    @Test
    public void testEstornoSucesso() {
        CaixaReal c = new CaixaReal(100.0);
        assertEquals("Estorno processado com sucesso: R$30.0", c.processarEstorno(30.0));
    }

    @Test
    public void testEstornoSaldoInsuficiente() {
        CaixaReal c = new CaixaReal(50.0);
        assertEquals("Saldo insuficiente no caixa", c.processarEstorno(60.0));
    }

    @Test
    public void testEstornoValorZero() {
        CaixaReal c = new CaixaReal(100.0);
        assertEquals("Valor invalido para estorno", c.processarEstorno(0.0));
    }

    @Test
    public void testEstornoValorNegativo() {
        CaixaReal c = new CaixaReal(100.0);
        assertEquals("Valor invalido para estorno", c.processarEstorno(-10.0));
    }

    @Test
    public void testSaldoAtualizado() {
        CaixaReal c = new CaixaReal(100.0);
        c.processarEstorno(40.0);
        assertEquals(60.0, c.getSaldo());
    }

    @Test
    public void testMultiplosEstornos() {
        CaixaReal c = new CaixaReal(200.0);
        c.processarEstorno(50.0);
        c.processarEstorno(20.0);
        assertEquals(130.0, c.getSaldo());
    }

    @Test
    public void testZerarSaldoExato() {
        CaixaReal c = new CaixaReal(50.0);
        assertEquals("Estorno processado com sucesso: R$50.0", c.processarEstorno(50.0));
        assertEquals(0.0, c.getSaldo());
    }

    @Test
    public void testEstornoAposZerarSaldo() {
        CaixaReal c = new CaixaReal(50.0);
        c.processarEstorno(50.0);
        assertEquals("Saldo insuficiente no caixa", c.processarEstorno(10.0));
    }

    @Test
    public void testGetSaldoInicial() {
        CaixaReal c = new CaixaReal(75.5);
        assertEquals(75.5, c.getSaldo());
    }

    @Test
    public void testPolimorfismo() {
        OperacaoCaixa c = new CaixaReal(10.0);
        assertTrue(c instanceof OperacaoCaixa);
    }
}
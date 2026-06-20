package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OperacaoCaixaTest {

    @Test
    public void testContratoSucesso() {
        OperacaoCaixa o = valor -> "Estorno de " + valor;
        assertEquals("Estorno de 50.0", o.processarEstorno(50.0));
    }

    @Test
    public void testContratoValorZero() {
        OperacaoCaixa o = valor -> String.valueOf(valor);
        assertEquals("0.0", o.processarEstorno(0.0));
    }

    @Test
    public void testContratoValorNegativo() {
        OperacaoCaixa o = valor -> "Negado: " + valor;
        assertEquals("Negado: -10.0", o.processarEstorno(-10.0));
    }

    @Test
    public void testContratoMultiplasChamadas() {
        OperacaoCaixa o = valor -> "OK";
        assertEquals(o.processarEstorno(1.0), o.processarEstorno(2.0));
    }

    @Test
    public void testPolimorfismo() {
        OperacaoCaixa o = valor -> "";
        assertTrue(o instanceof OperacaoCaixa);
    }

    @Test
    public void testInstanciaAnonima() {
        assertNotNull((OperacaoCaixa) valor -> "Teste");
    }

    @Test
    public void testExcecaoNaImplementacao() {
        OperacaoCaixa o = valor -> { throw new IllegalArgumentException(); };
        assertThrows(IllegalArgumentException.class, () -> o.processarEstorno(10.0));
    }

    @Test
    public void testFormatacaoStringContrato() {
        OperacaoCaixa o = valor -> String.format("R$%.2f", valor);
        assertEquals("R$15,50", o.processarEstorno(15.50).replace(".", ","));
    }

    @Test
    public void testVariavelExternaMutavel() {
        final double[] total = {0};
        OperacaoCaixa o = valor -> { total[0] += valor; return "OK"; };
        o.processarEstorno(10.0);
        o.processarEstorno(20.0);
        assertEquals(30.0, total[0]);
    }

    @Test
    public void testRetornoNulo() {
        OperacaoCaixa o = valor -> null;
        assertNull(o.processarEstorno(10.0));
    }
}
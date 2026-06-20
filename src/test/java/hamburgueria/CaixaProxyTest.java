package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CaixaProxyTest {

    @Test
    public void testAcessoPermitido() {
        CaixaReal real = new CaixaReal(100.0);
        CaixaProxy proxy = new CaixaProxy(real, "1234", "GERENTE");
        assertEquals("Estorno processado com sucesso: R$20.0", proxy.processarEstorno(20.0));
    }

    @Test
    public void testAcessoNegadoNivel() {
        CaixaReal real = new CaixaReal(100.0);
        CaixaProxy proxy = new CaixaProxy(real, "1234", "ATENDENTE");
        assertEquals("Acesso negado: apenas gerentes podem estornar", proxy.processarEstorno(20.0));
    }

    @Test
    public void testAcessoNegadoSenha() {
        CaixaReal real = new CaixaReal(100.0);
        CaixaProxy proxy = new CaixaProxy(real, "0000", "GERENTE");
        assertEquals("Acesso negado: senha incorreta", proxy.processarEstorno(20.0));
    }

    @Test
    public void testCaixaRealNulo() {
        CaixaProxy proxy = new CaixaProxy(null, "1234", "GERENTE");
        assertEquals("Caixa indisponivel", proxy.processarEstorno(20.0));
    }

    @Test
    public void testNivelNulo() {
        CaixaReal real = new CaixaReal(100.0);
        CaixaProxy proxy = new CaixaProxy(real, "1234", null);
        assertEquals("Acesso negado: apenas gerentes podem estornar", proxy.processarEstorno(20.0));
    }

    @Test
    public void testSenhaNula() {
        CaixaReal real = new CaixaReal(100.0);
        CaixaProxy proxy = new CaixaProxy(real, null, "GERENTE");
        assertEquals("Acesso negado: senha incorreta", proxy.processarEstorno(20.0));
    }

    @Test
    public void testAmbosAcessosNulos() {
        CaixaReal real = new CaixaReal(100.0);
        CaixaProxy proxy = new CaixaProxy(real, null, null);
        assertEquals("Acesso negado: apenas gerentes podem estornar", proxy.processarEstorno(20.0));
    }

    @Test
    public void testRepasseRegraSaldoInsuficiente() {
        CaixaReal real = new CaixaReal(50.0);
        CaixaProxy proxy = new CaixaProxy(real, "1234", "GERENTE");
        assertEquals("Saldo insuficiente no caixa", proxy.processarEstorno(60.0));
    }

    @Test
    public void testRepasseRegraValorZero() {
        CaixaReal real = new CaixaReal(50.0);
        CaixaProxy proxy = new CaixaProxy(real, "1234", "GERENTE");
        assertEquals("Valor invalido para estorno", proxy.processarEstorno(0.0));
    }

    @Test
    public void testPolimorfismoProxy() {
        OperacaoCaixa proxy = new CaixaProxy(new CaixaReal(10.0), "1234", "GERENTE");
        assertTrue(proxy instanceof OperacaoCaixa);
    }
}
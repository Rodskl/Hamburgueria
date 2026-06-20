package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FechamentoContaTest {

    private class FechamentoMock extends FechamentoConta {
        public FechamentoMock(EmissorRecibo emissor) { super(emissor); }
        public String fechar(String pedido, double valor) { return "Mock"; }
    }

    @Test
    public void testConstrutorArmazenaEmissor() {
        EmissorRecibo e = (p, v) -> "Ok";
        FechamentoConta f = new FechamentoMock(e);
        assertNotNull(f.emissor);
    }

    @Test
    public void testEmissorNuloNoConstrutor() {
        FechamentoConta f = new FechamentoMock(null);
        assertNull(f.emissor);
    }

    @Test
    public void testFecharAbstratoChamado() {
        FechamentoConta f = new FechamentoMock(null);
        assertEquals("Mock", f.fechar("A", 10.0));
    }

    @Test
    public void testHeranca() {
        FechamentoConta f = new FechamentoMock(null);
        assertTrue(f instanceof FechamentoConta);
    }

    @Test
    public void testPolimorfismoDaPropriedade() {
        EmissorRecibo e = new EmissorReciboDigital();
        FechamentoConta f = new FechamentoMock(e);
        assertTrue(f.emissor instanceof EmissorReciboDigital);
    }

    @Test
    public void testAcessoProtegidoEmissor() {
        EmissorRecibo e = (p, v) -> "A";
        FechamentoConta f = new FechamentoMock(e);
        assertEquals(e, f.emissor);
    }

    @Test
    public void testMudancaDeEstadoNoEmissor() {
        final double[] v = {0};
        EmissorRecibo e = (ped, val) -> { v[0] = val; return ""; };
        FechamentoConta f = new FechamentoConta(e) {
            public String fechar(String p, double val) { emissor.emitir(p, val); return ""; }
        };
        f.fechar("T", 99.0);
        assertEquals(99.0, v[0]);
    }

    @Test
    public void testExcecaoNoFechar() {
        FechamentoConta f = new FechamentoConta(null) {
            public String fechar(String p, double v) { throw new RuntimeException(); }
        };
        assertThrows(RuntimeException.class, () -> f.fechar("A", 1.0));
    }

    @Test
    public void testInstanciaSubclasseValida() {
        assertNotNull(new FechamentoMock(null));
    }

    @Test
    public void testInstanciaPeloPai() {
        FechamentoConta f = new FechamentoConta((p, v) -> "") {
            public String fechar(String p, double v) { return "Teste"; }
        };
        assertEquals("Teste", f.fechar("A", 1.0));
    }
}
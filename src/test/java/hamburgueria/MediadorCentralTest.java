package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MediadorCentralTest {

    private class SetorFalso extends SetorHamburgueria {
        public SetorFalso() { super(null); }
        public void receber(String msg) { this.ultimaMensagem = msg; }
    }

    @Test
    public void testCozinhaEnviaParaPainel() {
        MediadorCentral m = new MediadorCentral();
        SetorFalso cozinha = new SetorFalso();
        SetorFalso painel = new SetorFalso();
        m.setCozinha(cozinha);
        m.setPainel(painel);
        m.enviarMensagem("Pronto", cozinha);
        assertEquals("Pronto", painel.getUltimaMensagem());
    }

    @Test
    public void testPainelEnviaParaCozinha() {
        MediadorCentral m = new MediadorCentral();
        SetorFalso cozinha = new SetorFalso();
        SetorFalso painel = new SetorFalso();
        m.setCozinha(cozinha);
        m.setPainel(painel);
        m.enviarMensagem("Novo Pedido", painel);
        assertEquals("Novo Pedido", cozinha.getUltimaMensagem());
    }

    @Test
    public void testRemetenteDesconhecidoNaoFazNada() {
        MediadorCentral m = new MediadorCentral();
        SetorFalso cozinha = new SetorFalso();
        SetorFalso painel = new SetorFalso();
        SetorFalso outro = new SetorFalso();
        m.setCozinha(cozinha);
        m.setPainel(painel);
        m.enviarMensagem("Teste", outro);
        assertNull(cozinha.getUltimaMensagem());
        assertNull(painel.getUltimaMensagem());
    }

    @Test
    public void testCozinhaEnviaComPainelNulo() {
        MediadorCentral m = new MediadorCentral();
        SetorFalso cozinha = new SetorFalso();
        m.setCozinha(cozinha);
        assertDoesNotThrow(() -> m.enviarMensagem("Teste", cozinha));
    }

    @Test
    public void testPainelEnviaComCozinhaNulo() {
        MediadorCentral m = new MediadorCentral();
        SetorFalso painel = new SetorFalso();
        m.setPainel(painel);
        assertDoesNotThrow(() -> m.enviarMensagem("Teste", painel));
    }

    @Test
    public void testAmbosNulos() {
        MediadorCentral m = new MediadorCentral();
        SetorFalso externo = new SetorFalso();
        assertDoesNotThrow(() -> m.enviarMensagem("Teste", externo));
    }

    @Test
    public void testMensagemNula() {
        MediadorCentral m = new MediadorCentral();
        SetorFalso cozinha = new SetorFalso();
        SetorFalso painel = new SetorFalso();
        m.setCozinha(cozinha);
        m.setPainel(painel);
        m.enviarMensagem(null, cozinha);
        assertNull(painel.getUltimaMensagem());
    }

    @Test
    public void testInstanciaNaoNula() {
        assertNotNull(new MediadorCentral());
    }

    @Test
    public void testPolimorfismoMediador() {
        assertTrue(new MediadorCentral() instanceof Mediador);
    }

    @Test
    public void testSubstituicaoDeColegas() {
        MediadorCentral m = new MediadorCentral();
        SetorFalso c1 = new SetorFalso();
        SetorFalso c2 = new SetorFalso();
        SetorFalso p = new SetorFalso();
        m.setCozinha(c1);
        m.setPainel(p);
        m.setCozinha(c2);
        m.enviarMensagem("T", p);
        assertEquals("T", c2.getUltimaMensagem());
        assertNull(c1.getUltimaMensagem());
    }
}
package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PainelSetorTest {

    @Test
    public void testReceberFormataMensagem() {
        PainelSetor p = new PainelSetor(null);
        p.receber("Senha 05");
        assertEquals("Painel exibe: Senha 05", p.getUltimaMensagem());
    }

    @Test
    public void testEnviarChamaMediador() {
        final boolean[] chamado = {false};
        Mediador m = (msg, r) -> chamado[0] = true;
        PainelSetor p = new PainelSetor(m);
        p.enviar("Chamando");
        assertTrue(chamado[0]);
    }

    @Test
    public void testInstanciaNaoNula() {
        assertNotNull(new PainelSetor(null));
    }

    @Test
    public void testHeranca() {
        assertTrue(new PainelSetor(null) instanceof SetorHamburgueria);
    }

    @Test
    public void testReceberMensagemNula() {
        PainelSetor p = new PainelSetor(null);
        p.receber(null);
        assertEquals("Painel exibe: null", p.getUltimaMensagem());
    }

    @Test
    public void testEnviarMensagemNula() {
        final String[] capturada = new String[1];
        Mediador m = (msg, r) -> capturada[0] = msg;
        PainelSetor p = new PainelSetor(m);
        p.enviar(null);
        assertNull(capturada[0]);
    }

    @Test
    public void testEnviarSemMediadorNaoQuebra() {
        PainelSetor p = new PainelSetor(null);
        assertDoesNotThrow(() -> p.enviar("Aviso"));
    }

    @Test
    public void testUltimaMensagemInicialNula() {
        PainelSetor p = new PainelSetor(null);
        assertNull(p.getUltimaMensagem());
    }

    @Test
    public void testSubstituicaoMensagem() {
        PainelSetor p = new PainelSetor(null);
        p.receber("X");
        p.receber("Y");
        assertEquals("Painel exibe: Y", p.getUltimaMensagem());
    }

    @Test
    public void testReferenciaPropriaNoEnvio() {
        final SetorHamburgueria[] ref = new SetorHamburgueria[1];
        Mediador m = (msg, r) -> ref[0] = r;
        PainelSetor p = new PainelSetor(m);
        p.enviar("X");
        assertEquals(p, ref[0]);
    }
}
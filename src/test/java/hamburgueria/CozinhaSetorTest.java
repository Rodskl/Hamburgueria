package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CozinhaSetorTest {

    @Test
    public void testReceberFormataMensagem() {
        CozinhaSetor c = new CozinhaSetor(null);
        c.receber("Pedido 1");
        assertEquals("Cozinha recebeu: Pedido 1", c.getUltimaMensagem());
    }

    @Test
    public void testEnviarChamaMediador() {
        final boolean[] chamado = {false};
        Mediador m = (msg, r) -> chamado[0] = true;
        CozinhaSetor c = new CozinhaSetor(m);
        c.enviar("Pronto");
        assertTrue(chamado[0]);
    }

    @Test
    public void testInstanciaNaoNula() {
        assertNotNull(new CozinhaSetor(null));
    }

    @Test
    public void testHeranca() {
        assertTrue(new CozinhaSetor(null) instanceof SetorHamburgueria);
    }

    @Test
    public void testReceberMensagemNula() {
        CozinhaSetor c = new CozinhaSetor(null);
        c.receber(null);
        assertEquals("Cozinha recebeu: null", c.getUltimaMensagem());
    }

    @Test
    public void testEnviarMensagemNula() {
        final String[] capturada = new String[1];
        Mediador m = (msg, r) -> capturada[0] = msg;
        CozinhaSetor c = new CozinhaSetor(m);
        c.enviar(null);
        assertNull(capturada[0]);
    }

    @Test
    public void testEnviarSemMediadorNaoQuebra() {
        CozinhaSetor c = new CozinhaSetor(null);
        assertDoesNotThrow(() -> c.enviar("Lanche"));
    }

    @Test
    public void testUltimaMensagemInicialNula() {
        CozinhaSetor c = new CozinhaSetor(null);
        assertNull(c.getUltimaMensagem());
    }

    @Test
    public void testSubstituicaoMensagem() {
        CozinhaSetor c = new CozinhaSetor(null);
        c.receber("A");
        c.receber("B");
        assertEquals("Cozinha recebeu: B", c.getUltimaMensagem());
    }

    @Test
    public void testReferenciaPropriaNoEnvio() {
        final SetorHamburgueria[] ref = new SetorHamburgueria[1];
        Mediador m = (msg, r) -> ref[0] = r;
        CozinhaSetor c = new CozinhaSetor(m);
        c.enviar("A");
        assertEquals(c, ref[0]);
    }
}
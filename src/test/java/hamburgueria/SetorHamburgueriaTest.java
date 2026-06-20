package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SetorHamburgueriaTest {

    private class SetorMock extends SetorHamburgueria {
        public SetorMock(Mediador m) { super(m); }
        public void receber(String msg) { this.ultimaMensagem = msg; }
    }

    @Test
    public void testConstrutorDefineMediador() {
        Mediador m = (msg, r) -> {};
        SetorHamburgueria s = new SetorMock(m);
        assertEquals(m, s.mediador);
    }

    @Test
    public void testEnviarComMediadorValido() {
        final boolean[] chamado = {false};
        Mediador m = (msg, r) -> chamado[0] = true;
        SetorHamburgueria s = new SetorMock(m);
        s.enviar("Oi");
        assertTrue(chamado[0]);
    }

    @Test
    public void testEnviarComMediadorNulo() {
        SetorHamburgueria s = new SetorMock(null);
        assertDoesNotThrow(() -> s.enviar("Teste"));
    }

    @Test
    public void testGetUltimaMensagemInicialNula() {
        SetorHamburgueria s = new SetorMock(null);
        assertNull(s.getUltimaMensagem());
    }

    @Test
    public void testImplementacaoReceberMock() {
        SetorHamburgueria s = new SetorMock(null);
        s.receber("Recebido");
        assertEquals("Recebido", s.getUltimaMensagem());
    }

    @Test
    public void testAlterarUltimaMensagemProtegida() {
        SetorMock s = new SetorMock(null);
        s.ultimaMensagem = "Manual";
        assertEquals("Manual", s.getUltimaMensagem());
    }

    @Test
    public void testEnviarMensagemNula() {
        final String[] capturada = new String[1];
        Mediador m = (msg, r) -> capturada[0] = msg;
        SetorHamburgueria s = new SetorMock(m);
        s.enviar(null);
        assertNull(capturada[0]);
    }

    @Test
    public void testInstanciaNaoNula() {
        assertNotNull(new SetorMock(null));
    }

    @Test
    public void testPolimorfismo() {
        assertTrue(new SetorMock(null) instanceof SetorHamburgueria);
    }

    @Test
    public void testMultiplosEnvios() {
        final int[] cont = {0};
        Mediador m = (msg, r) -> cont[0]++;
        SetorHamburgueria s = new SetorMock(m);
        s.enviar("1");
        s.enviar("2");
        assertEquals(2, cont[0]);
    }
}
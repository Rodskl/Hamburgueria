package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MediadorTest {

    @Test
    public void testContratoEnviar() {
        final String[] capturado = new String[1];
        Mediador m = (msg, remetente) -> capturado[0] = msg;
        m.enviarMensagem("Teste", null);
        assertEquals("Teste", capturado[0]);
    }

    @Test
    public void testContratoEnviarRemetenteNulo() {
        final SetorHamburgueria[] capturado = new SetorHamburgueria[1];
        Mediador m = (msg, remetente) -> capturado[0] = remetente;
        m.enviarMensagem("Teste", null);
        assertNull(capturado[0]);
    }

    @Test
    public void testImplementacaoAnonima() {
        Mediador m = new Mediador() {
            public void enviarMensagem(String msg, SetorHamburgueria r) {}
        };
        assertNotNull(m);
    }

    @Test
    public void testPolimorfismo() {
        Mediador m = (msg, r) -> {};
        assertTrue(m instanceof Mediador);
    }

    @Test
    public void testMultiplasChamadas() {
        final int[] count = {0};
        Mediador m = (msg, r) -> count[0]++;
        m.enviarMensagem("A", null);
        m.enviarMensagem("B", null);
        assertEquals(2, count[0]);
    }

    @Test
    public void testExcecaoNaImplementacao() {
        Mediador m = (msg, r) -> { throw new RuntimeException(); };
        assertThrows(RuntimeException.class, () -> m.enviarMensagem("A", null));
    }

    @Test
    public void testIndependenciaDeInstancias() {
        Mediador m1 = (msg, r) -> {};
        Mediador m2 = (msg, r) -> {};
        assertNotSame(m1, m2);
    }

    @Test
    public void testCast() {
        Object m = (Mediador) (msg, r) -> {};
        assertTrue(m instanceof Mediador);
    }

    @Test
    public void testVariavelExternaAcesso() {
        final boolean[] flag = {false};
        Mediador m = (msg, r) -> flag[0] = true;
        m.enviarMensagem("A", null);
        assertTrue(flag[0]);
    }

    @Test
    public void testContratoComObjetoReal() {
        final boolean[] passou = {false};
        SetorHamburgueria setor = new SetorHamburgueria(null) {
            public void receber(String m) {}
        };
        Mediador m = (msg, r) -> passou[0] = (r != null);
        m.enviarMensagem("A", setor);
        assertTrue(passou[0]);
    }
}
package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PainelAtendimentoTest {

    @Test
    public void testListaInicialVazia() {
        PainelAtendimento p = new PainelAtendimento();
        assertEquals(0, p.getQuantidadeObservers());
    }

    @Test
    public void testAdicionarObserver() {
        PainelAtendimento p = new PainelAtendimento();
        p.adicionarObserver(new Cliente("Teste"));
        assertEquals(1, p.getQuantidadeObservers());
    }

    @Test
    public void testNaoAdicionarNulo() {
        PainelAtendimento p = new PainelAtendimento();
        p.adicionarObserver(null);
        assertEquals(0, p.getQuantidadeObservers());
    }

    @Test
    public void testNaoAdicionarDuplicado() {
        PainelAtendimento p = new PainelAtendimento();
        Cliente c = new Cliente("Teste");
        p.adicionarObserver(c);
        p.adicionarObserver(c);
        assertEquals(1, p.getQuantidadeObservers());
    }

    @Test
    public void testRemoverObserver() {
        PainelAtendimento p = new PainelAtendimento();
        Cliente c = new Cliente("Teste");
        p.adicionarObserver(c);
        p.removerObserver(c);
        assertEquals(0, p.getQuantidadeObservers());
    }

    @Test
    public void testRemoverObserverNaoCadastrado() {
        PainelAtendimento p = new PainelAtendimento();
        Cliente c1 = new Cliente("A");
        Cliente c2 = new Cliente("B");
        p.adicionarObserver(c1);
        p.removerObserver(c2);
        assertEquals(1, p.getQuantidadeObservers());
    }

    @Test
    public void testRemoverNulo() {
        PainelAtendimento p = new PainelAtendimento();
        p.adicionarObserver(new Cliente("Teste"));
        p.removerObserver(null);
        assertEquals(1, p.getQuantidadeObservers());
    }

    @Test
    public void testNotificarTodosObservers() {
        PainelAtendimento p = new PainelAtendimento();
        Cliente c1 = new Cliente("A");
        Cliente c2 = new Cliente("B");
        p.adicionarObserver(c1);
        p.adicionarObserver(c2);
        p.notificarObservers("Pronto");
        assertEquals("Pronto", c1.getUltimaNotificacao());
        assertEquals("Pronto", c2.getUltimaNotificacao());
    }

    @Test
    public void testNotificarSemObservers() {
        PainelAtendimento p = new PainelAtendimento();
        assertDoesNotThrow(() -> p.notificarObservers("Teste"));
    }

    @Test
    public void testPolimorfismoSubject() {
        PainelAtendimento p = new PainelAtendimento();
        assertTrue(p instanceof SubjectPedido);
    }
}
package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    @Test
    public void testConstrutorENome() {
        Cliente c = new Cliente("João");
        assertEquals("João", c.getNome());
    }

    @Test
    public void testNomeNulo() {
        Cliente c = new Cliente(null);
        assertNull(c.getNome());
    }

    @Test
    public void testNomeVazio() {
        Cliente c = new Cliente("");
        assertEquals("", c.getNome());
    }

    @Test
    public void testNotificacaoInicialNula() {
        Cliente c = new Cliente("Maria");
        assertNull(c.getUltimaNotificacao());
    }

    @Test
    public void testAtualizarNotificacao() {
        Cliente c = new Cliente("Ana");
        c.atualizar("Seu pedido está pronto!");
        assertEquals("Seu pedido está pronto!", c.getUltimaNotificacao());
    }

    @Test
    public void testAtualizarNotificacaoNula() {
        Cliente c = new Cliente("Pedro");
        c.atualizar("Preparando");
        c.atualizar(null);
        assertNull(c.getUltimaNotificacao());
    }

    @Test
    public void testAtualizarNotificacaoVazia() {
        Cliente c = new Cliente("Lucas");
        c.atualizar("");
        assertEquals("", c.getUltimaNotificacao());
    }

    @Test
    public void testSubstituicaoDeNotificacao() {
        Cliente c = new Cliente("Carlos");
        c.atualizar("Recebido");
        c.atualizar("Em Preparo");
        assertEquals("Em Preparo", c.getUltimaNotificacao());
    }

    @Test
    public void testPolimorfismoObserver() {
        Cliente c = new Cliente("Julia");
        assertTrue(c instanceof ObserverPedido);
    }

    @Test
    public void testInstanciasDiferentes() {
        Cliente c1 = new Cliente("A");
        Cliente c2 = new Cliente("B");
        c1.atualizar("Msg1");
        c2.atualizar("Msg2");
        assertNotEquals(c1.getUltimaNotificacao(), c2.getUltimaNotificacao());
    }
}
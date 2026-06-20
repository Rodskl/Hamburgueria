package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ObserverPedidoTest {

    @Test
    public void testAtualizarSimples() {
        final String[] resultado = new String[1];
        ObserverPedido o = msg -> resultado[0] = msg;
        o.atualizar("Pronto");
        assertEquals("Pronto", resultado[0]);
    }

    @Test
    public void testAtualizarNulo() {
        final String[] resultado = new String[1];
        ObserverPedido o = msg -> resultado[0] = msg;
        o.atualizar(null);
        assertNull(resultado[0]);
    }

    @Test
    public void testAtualizarVazio() {
        final String[] resultado = new String[1];
        ObserverPedido o = msg -> resultado[0] = msg;
        o.atualizar("");
        assertEquals("", resultado[0]);
    }

    @Test
    public void testAtualizarEspacos() {
        final String[] resultado = new String[1];
        ObserverPedido o = msg -> resultado[0] = msg;
        o.atualizar("   ");
        assertEquals("   ", resultado[0]);
    }

    @Test
    public void testMultiplasAtualizacoes() {
        final int[] contagem = {0};
        ObserverPedido o = msg -> contagem[0]++;
        o.atualizar("A");
        o.atualizar("B");
        assertEquals(2, contagem[0]);
    }

    @Test
    public void testPolimorfismo() {
        ObserverPedido o = msg -> {};
        assertTrue(o instanceof ObserverPedido);
    }

    @Test
    public void testInstanciaAnonima() {
        ObserverPedido o = new ObserverPedido() {
            public void atualizar(String mensagem) {}
        };
        assertNotNull(o);
    }

    @Test
    public void testExcecaoNaImplementacao() {
        ObserverPedido o = msg -> { throw new IllegalArgumentException(); };
        assertThrows(IllegalArgumentException.class, () -> o.atualizar("Teste"));
    }

    @Test
    public void testSobrescritaDeVariavel() {
        final String[] resultado = {"Inicial"};
        ObserverPedido o = msg -> resultado[0] = msg;
        o.atualizar("Final");
        assertEquals("Final", resultado[0]);
    }

    @Test
    public void testAtualizacaoMensagemLonga() {
        final String[] resultado = new String[1];
        ObserverPedido o = msg -> resultado[0] = msg;
        String longa = "O seu pedido contendo dois hambúrgueres está pronto para retirada no balcão 3";
        o.atualizar(longa);
        assertEquals(longa, resultado[0]);
    }
}
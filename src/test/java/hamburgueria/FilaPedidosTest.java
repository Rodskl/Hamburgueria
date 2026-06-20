package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FilaPedidosTest {

    @Test
    public void testFilaInicialVazia() {
        FilaPedidos f = new FilaPedidos();
        assertEquals(0, f.getTamanho());
    }

    @Test
    public void testAdicionarPedidoValido() {
        FilaPedidos f = new FilaPedidos();
        f.adicionarPedido(() -> {});
        assertEquals(1, f.getTamanho());
    }

    @Test
    public void testAdicionarPedidoNulo() {
        FilaPedidos f = new FilaPedidos();
        f.adicionarPedido(null);
        assertEquals(0, f.getTamanho());
    }

    @Test
    public void testProcessarFilaExecutaComandos() {
        FilaPedidos f = new FilaPedidos();
        final boolean[] executado = {false};
        f.adicionarPedido(() -> executado[0] = true);
        f.processarFila();
        assertTrue(executado[0]);
    }

    @Test
    public void testProcessarFilaLimpaLista() {
        FilaPedidos f = new FilaPedidos();
        f.adicionarPedido(() -> {});
        f.processarFila();
        assertEquals(0, f.getTamanho());
    }

    @Test
    public void testCancelarTodos() {
        FilaPedidos f = new FilaPedidos();
        f.adicionarPedido(() -> {});
        f.adicionarPedido(() -> {});
        f.cancelarTodos();
        assertEquals(0, f.getTamanho());
    }

    @Test
    public void testProcessarFilaVazia() {
        FilaPedidos f = new FilaPedidos();
        assertDoesNotThrow(f::processarFila);
    }

    @Test
    public void testOrdemExecucao() {
        FilaPedidos f = new FilaPedidos();
        StringBuilder sb = new StringBuilder();
        f.adicionarPedido(() -> sb.append("1"));
        f.adicionarPedido(() -> sb.append("2"));
        f.processarFila();
        assertEquals("12", sb.toString());
    }

    @Test
    public void testCancelarNaoExecuta() {
        FilaPedidos f = new FilaPedidos();
        final boolean[] executado = {false};
        f.adicionarPedido(() -> executado[0] = true);
        f.cancelarTodos();
        f.processarFila();
        assertFalse(executado[0]);
    }

    @Test
    public void testIntegracaoComCozinha() {
        Cozinha c = new Cozinha();
        FilaPedidos f = new FilaPedidos();
        f.adicionarPedido(new ComandoPrepararHamburguer(c, "Burger"));
        f.processarFila();
        assertEquals(1, c.getPreparados().size());
        assertEquals(0, f.getTamanho());
    }
}
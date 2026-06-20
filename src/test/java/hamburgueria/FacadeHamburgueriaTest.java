package hamburgueria;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class FacadeHamburgueriaTest {

    @Test
    public void testPedidoComSucessoRetorno() {
        FacadeHamburgueria f = new FacadeHamburgueria();
        boolean resultado = f.realizarPedido("X-Salada", BigDecimal.TEN, v -> true, new Cliente("A"));
        assertTrue(resultado);
    }

    @Test
    public void testPedidoComFalhaRetorno() {
        FacadeHamburgueria f = new FacadeHamburgueria();
        boolean resultado = f.realizarPedido("X-Salada", BigDecimal.TEN, v -> false, new Cliente("A"));
        assertFalse(resultado);
    }

    @Test
    public void testPreparoIniciadoAposSucesso() {
        FacadeHamburgueria f = new FacadeHamburgueria();
        f.realizarPedido("Smash", BigDecimal.TEN, v -> true, null);
        assertEquals("Lanche: Smash", f.getCozinha().getPreparados().get(0));
    }

    @Test
    public void testPreparoNaoIniciadoAposFalha() {
        FacadeHamburgueria f = new FacadeHamburgueria();
        f.realizarPedido("Smash", BigDecimal.TEN, v -> false, null);
        assertTrue(f.getCozinha().getPreparados().isEmpty());
    }

    @Test
    public void testNotificacaoClienteAposSucesso() {
        FacadeHamburgueria f = new FacadeHamburgueria();
        Cliente c = new Cliente("Joao");
        f.realizarPedido("Artesanal", BigDecimal.TEN, v -> true, c);
        assertEquals("Pedido Artesanal em preparo", c.getUltimaNotificacao());
    }

    @Test
    public void testSemNotificacaoAposFalha() {
        FacadeHamburgueria f = new FacadeHamburgueria();
        Cliente c = new Cliente("Maria");
        f.realizarPedido("Artesanal", BigDecimal.TEN, v -> false, c);
        assertNull(c.getUltimaNotificacao());
    }

    @Test
    public void testClienteNuloTratadoCorretamente() {
        FacadeHamburgueria f = new FacadeHamburgueria();
        assertDoesNotThrow(() -> f.realizarPedido("Bacon", BigDecimal.TEN, v -> true, null));
    }

    @Test
    public void testEstrategiaNulaLancaExcecao() {
        FacadeHamburgueria f = new FacadeHamburgueria();
        assertThrows(IllegalStateException.class, () -> f.realizarPedido("Vegan", BigDecimal.TEN, null, null));
    }

    @Test
    public void testFilaProcessadaELimpa() {
        FacadeHamburgueria f = new FacadeHamburgueria();
        f.realizarPedido("Duplo", BigDecimal.TEN, v -> true, null);
        assertEquals(0, f.getFilaPedidos().getTamanho());
    }

    @Test
    public void testIntegridadeDosSubsistemas() {
        FacadeHamburgueria f = new FacadeHamburgueria();
        assertNotNull(f.getCozinha());
        assertNotNull(f.getFilaPedidos());
        assertNotNull(f.getPainel());
    }
}
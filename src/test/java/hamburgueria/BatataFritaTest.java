package hamburgueria;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class BatataFritaTest {

    @Test
    public void testAcrescimoDescricao() {
        Pedido p = new HamburguerBase("Smash Burger", new BigDecimal("20.00"));
        BatataFrita bf = new BatataFrita(p);
        assertEquals("Smash Burger + Batata Frita", bf.getDescricao());
    }

    @Test
    public void testAcrescimoPreco() {
        Pedido p = new HamburguerBase("Smash Burger", new BigDecimal("20.00"));
        BatataFrita bf = new BatataFrita(p);
        assertEquals(new BigDecimal("32.50"), bf.getPreco());
    }

    @Test
    public void testDuplaBatataDescricao() {
        Pedido p = new HamburguerBase("X-Salada", new BigDecimal("25.00"));
        BatataFrita bf1 = new BatataFrita(p);
        BatataFrita bf2 = new BatataFrita(bf1);
        assertEquals("X-Salada + Batata Frita + Batata Frita", bf2.getDescricao());
    }

    @Test
    public void testDuplaBatataPreco() {
        Pedido p = new HamburguerBase("X-Salada", new BigDecimal("25.00"));
        BatataFrita bf1 = new BatataFrita(p);
        BatataFrita bf2 = new BatataFrita(bf1);
        assertEquals(new BigDecimal("50.00"), bf2.getPreco());
    }

    @Test
    public void testPedidoWrappadoNuloDescricao() {
        BatataFrita bf = new BatataFrita(null);
        assertEquals(" + Batata Frita", bf.getDescricao());
    }

    @Test
    public void testPedidoWrappadoNuloPreco() {
        BatataFrita bf = new BatataFrita(null);
        assertEquals(new BigDecimal("12.50"), bf.getPreco());
    }

    @Test
    public void testPrecoPedidoBaseZero() {
        Pedido p = new HamburguerBase("Brinde", BigDecimal.ZERO);
        BatataFrita bf = new BatataFrita(p);
        assertEquals(new BigDecimal("12.50"), bf.getPreco());
    }

    @Test
    public void testDescricaoPedidoBaseVazio() {
        Pedido p = new HamburguerBase("", new BigDecimal("10.00"));
        BatataFrita bf = new BatataFrita(p);
        assertEquals(" + Batata Frita", bf.getDescricao());
    }

    @Test
    public void testTriplaBatataPreco() {
        Pedido p = new HamburguerBase("Simples", new BigDecimal("10.00"));
        Pedido bf = new BatataFrita(new BatataFrita(new BatataFrita(p)));
        assertEquals(new BigDecimal("47.50"), bf.getPreco());
    }

    @Test
    public void testInstanciaCorreta() {
        Pedido p = new HamburguerBase("Teste", BigDecimal.ONE);
        BatataFrita bf = new BatataFrita(p);
        assertTrue(bf instanceof AdicionalDecorator);
        assertTrue(bf instanceof Pedido);
    }
}
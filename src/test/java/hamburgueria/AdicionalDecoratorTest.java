package hamburgueria;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class AdicionalDecoratorTest {

    private class DecoratorConcreto extends AdicionalDecorator {
        public DecoratorConcreto(Pedido p) { super(p); }
    }

    @Test
    public void testRepasseDescricao() {
        Pedido p = new HamburguerBase("Bacon Burger", new BigDecimal("30.00"));
        AdicionalDecorator d = new DecoratorConcreto(p);
        assertEquals("Bacon Burger", d.getDescricao());
    }

    @Test
    public void testRepassePreco() {
        Pedido p = new HamburguerBase("Bacon Burger", new BigDecimal("30.00"));
        AdicionalDecorator d = new DecoratorConcreto(p);
        assertEquals(new BigDecimal("30.00"), d.getPreco());
    }

    @Test
    public void testWrappadoNuloDescricao() {
        AdicionalDecorator d = new DecoratorConcreto(null);
        assertEquals("", d.getDescricao());
    }

    @Test
    public void testWrappadoNuloPreco() {
        AdicionalDecorator d = new DecoratorConcreto(null);
        assertEquals(BigDecimal.ZERO, d.getPreco());
    }

    @Test
    public void testEncadeamentoDescricao() {
        Pedido p = new HamburguerBase("X-Burger", new BigDecimal("20.00"));
        AdicionalDecorator d1 = new DecoratorConcreto(p);
        AdicionalDecorator d2 = new DecoratorConcreto(d1);
        assertEquals("X-Burger", d2.getDescricao());
    }

    @Test
    public void testEncadeamentoPreco() {
        Pedido p = new HamburguerBase("X-Burger", new BigDecimal("20.00"));
        AdicionalDecorator d1 = new DecoratorConcreto(p);
        AdicionalDecorator d2 = new DecoratorConcreto(d1);
        assertEquals(new BigDecimal("20.00"), d2.getPreco());
    }

    @Test
    public void testPolimorfismoDecorator() {
        Pedido p = new HamburguerBase("Test", BigDecimal.ONE);
        AdicionalDecorator d = new DecoratorConcreto(p);
        assertTrue(d instanceof Pedido);
    }

    @Test
    public void testComponenteNuloNoMeioDoEncadeamentoDescricao() {
        AdicionalDecorator d1 = new DecoratorConcreto(null);
        AdicionalDecorator d2 = new DecoratorConcreto(d1);
        assertEquals("", d2.getDescricao());
    }

    @Test
    public void testComponenteNuloNoMeioDoEncadeamentoPreco() {
        AdicionalDecorator d1 = new DecoratorConcreto(null);
        AdicionalDecorator d2 = new DecoratorConcreto(d1);
        assertEquals(BigDecimal.ZERO, d2.getPreco());
    }

    @Test
    public void testReferenciaInterna() {
        Pedido p = new HamburguerBase("Ref", BigDecimal.TEN);
        DecoratorConcreto d = new DecoratorConcreto(p);
        assertEquals(p.getPreco(), d.pedidoWrappado.getPreco());
    }
}
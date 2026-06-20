package hamburgueria;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class HamburguerBaseTest {

    @Test
    public void testDescricaoPadrao() {
        HamburguerBase hb = new HamburguerBase("Cheeseburger", new BigDecimal("25.00"));
        assertEquals("Cheeseburger", hb.getDescricao());
    }

    @Test
    public void testPrecoPadrao() {
        HamburguerBase hb = new HamburguerBase("Cheeseburger", new BigDecimal("25.00"));
        assertEquals(new BigDecimal("25.00"), hb.getPreco());
    }

    @Test
    public void testNomeNulo() {
        HamburguerBase hb = new HamburguerBase(null, new BigDecimal("20.00"));
        assertEquals("Hamburguer Indefinido", hb.getDescricao());
    }

    @Test
    public void testPrecoNulo() {
        HamburguerBase hb = new HamburguerBase("Simples", null);
        assertEquals(BigDecimal.ZERO, hb.getPreco());
    }

    @Test
    public void testAmbosNulos() {
        HamburguerBase hb = new HamburguerBase(null, null);
        assertEquals("Hamburguer Indefinido", hb.getDescricao());
        assertEquals(BigDecimal.ZERO, hb.getPreco());
    }

    @Test
    public void testPrecoZero() {
        HamburguerBase hb = new HamburguerBase("Promocao", BigDecimal.ZERO);
        assertEquals(BigDecimal.ZERO, hb.getPreco());
    }

    @Test
    public void testPrecoNegativo() {
        HamburguerBase hb = new HamburguerBase("Estorno", new BigDecimal("-10.00"));
        assertEquals(new BigDecimal("-10.00"), hb.getPreco());
    }

    @Test
    public void testDescricaoVazia() {
        HamburguerBase hb = new HamburguerBase("", new BigDecimal("15.00"));
        assertEquals("", hb.getDescricao());
    }

    @Test
    public void testNomeExtenso() {
        String nomeLongo = "Hamburguer Artesanal Duplo com Cheddar e Cebola Caramelizada";
        HamburguerBase hb = new HamburguerBase(nomeLongo, new BigDecimal("45.00"));
        assertEquals(nomeLongo, hb.getDescricao());
    }

    @Test
    public void testInstanciaTipo() {
        HamburguerBase hb = new HamburguerBase("X-Salada", new BigDecimal("22.00"));
        assertTrue(hb instanceof Pedido);
    }
}
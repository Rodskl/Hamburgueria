package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemIndividualTest {

    @Test
    public void testRetornoNomeExato() {
        ItemIndividual i = new ItemIndividual("Batata Frita Media", 12.0);
        assertEquals("Batata Frita Media", i.getNome());
    }

    @Test
    public void testRetornoPrecoExato() {
        ItemIndividual i = new ItemIndividual("Batata Frita Media", 12.0);
        assertEquals(12.0, i.getPreco());
    }

    @Test
    public void testNomeNulo() {
        ItemIndividual i = new ItemIndividual(null, 5.0);
        assertNull(i.getNome());
    }

    @Test
    public void testNomeVazio() {
        ItemIndividual i = new ItemIndividual("", 5.0);
        assertEquals("", i.getNome());
    }

    @Test
    public void testPrecoZero() {
        ItemIndividual i = new ItemIndividual("Molho Extra", 0.0);
        assertEquals(0.0, i.getPreco());
    }

    @Test
    public void testPrecoNegativo() {
        ItemIndividual i = new ItemIndividual("Cupom", -10.0);
        assertEquals(-10.0, i.getPreco());
    }

    @Test
    public void testPolimorfismo() {
        ItemIndividual i = new ItemIndividual("Agua", 3.0);
        assertTrue(i instanceof ItemCardapio);
    }

    @Test
    public void testInstanciasDiferentes() {
        ItemIndividual i1 = new ItemIndividual("Suco", 6.0);
        ItemIndividual i2 = new ItemIndividual("Suco", 6.0);
        assertNotSame(i1, i2);
    }

    @Test
    public void testCaracteresEspeciaisNome() {
        ItemIndividual i = new ItemIndividual("Combo #1 - Especial!", 25.0);
        assertEquals("Combo #1 - Especial!", i.getNome());
    }

    @Test
    public void testPrecoComDecimais() {
        ItemIndividual i = new ItemIndividual("Palha Italiana", 7.99);
        assertEquals(7.99, i.getPreco());
    }
}
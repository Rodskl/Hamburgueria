package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HamburguerTest {

    @Test
    public void testHamburguerSimples() {
        Hamburguer h = new Hamburguer.Builder().pao("Brioche").carne("Bovina").build();
        assertEquals("Brioche", h.getPao());
        assertEquals("Bovina", h.getCarne());
        assertFalse(h.hasQueijo());
    }

    @Test
    public void testHamburguerComQueijo() {
        Hamburguer h = new Hamburguer.Builder().pao("Gergelim").carne("Frango").queijo().build();
        assertTrue(h.hasQueijo());
        assertFalse(h.hasBacon());
    }

    @Test
    public void testHamburguerCompleto() {
        Hamburguer h = new Hamburguer.Builder().pao("Australiano").carne("Bovina").queijo().bacon().alface().tomate().build();
        assertTrue(h.hasBacon());
        assertTrue(h.hasAlface());
    }

    @Test
    public void testHamburguerSemCarne() {
        Hamburguer h = new Hamburguer.Builder().pao("Brioche").queijo().build();
        assertNull(h.getCarne());
        assertTrue(h.hasQueijo());
    }

    @Test
    public void testHamburguerSoPao() {
        Hamburguer h = new Hamburguer.Builder().pao("Brioche").build();
        assertEquals("Brioche", h.getPao());
        assertNull(h.getCarne());
        assertFalse(h.hasBacon());
    }

    @Test
    public void testHamburguerBaconQueijo() {
        Hamburguer h = new Hamburguer.Builder().pao("Gergelim").bacon().queijo().build();
        assertTrue(h.hasBacon());
        assertTrue(h.hasQueijo());
        assertFalse(h.hasTomate());
    }

    @Test
    public void testHamburguerSalada() {
        Hamburguer h = new Hamburguer.Builder().pao("Integral").alface().tomate().build();
        assertTrue(h.hasAlface());
        assertTrue(h.hasTomate());
        assertNull(h.getCarne());
    }

    @Test
    public void testHamburguerAtributosIniciais() {
        Hamburguer h = new Hamburguer.Builder().build();
        assertNull(h.getPao());
        assertNull(h.getCarne());
        assertFalse(h.hasQueijo());
    }

    @Test
    public void testHamburguerBuilderIsolado() {
        Hamburguer.Builder b = new Hamburguer.Builder().pao("Frances");
        Hamburguer h1 = b.build();
        Hamburguer h2 = b.carne("Suina").build();
        assertEquals("Frances", h1.getPao());
        assertNull(h1.getCarne());
        assertEquals("Suina", h2.getCarne());
    }

    @Test
    public void testHamburguerMultiplosIngredientes() {
        Hamburguer h = new Hamburguer.Builder().queijo().queijo().bacon().build();
        assertTrue(h.hasQueijo());
        assertTrue(h.hasBacon());
        assertFalse(h.hasAlface());
    }
}
package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HamburguerProntoTest {

    @Test
    public void testCloneCriaNovaInstancia() {
        HamburguerPronto original = new HamburguerPronto("X-Tudo", 25.0);
        HamburguerPronto clone = (HamburguerPronto) original.clonar();
        assertNotSame(original, clone);
    }

    @Test
    public void testCloneCopiaAtributos() {
        HamburguerPronto original = new HamburguerPronto("X-Bacon", 20.0);
        HamburguerPronto clone = (HamburguerPronto) original.clonar();
        assertEquals("X-Bacon", clone.getDescricao());
        assertEquals(20.0, clone.getPrecoBase());
    }

    @Test
    public void testIndependenciaAposClone() {
        HamburguerPronto original = new HamburguerPronto("Simples", 10.0);
        HamburguerPronto clone = (HamburguerPronto) original.clonar();
        clone.setDescricao("Simples sem Cebola");
        assertEquals("Simples", original.getDescricao());
        assertEquals("Simples sem Cebola", clone.getDescricao());
    }

    @Test
    public void testConstrutorDeCopiaNulo() {
        HamburguerPronto h = new HamburguerPronto(null);
        assertNull(h.getDescricao());
        assertEquals(0.0, h.getPrecoBase());
    }

    @Test
    public void testConstrutorPadrao() {
        HamburguerPronto h = new HamburguerPronto("Salada", 15.0);
        assertEquals("Salada", h.getDescricao());
        assertEquals(15.0, h.getPrecoBase());
    }

    @Test
    public void testSetDescricao() {
        HamburguerPronto h = new HamburguerPronto("A", 5.0);
        h.setDescricao("B");
        assertEquals("B", h.getDescricao());
    }

    @Test
    public void testCloneDeClone() {
        HamburguerPronto h1 = new HamburguerPronto("Duplo", 30.0);
        HamburguerPronto h2 = (HamburguerPronto) h1.clonar();
        HamburguerPronto h3 = (HamburguerPronto) h2.clonar();
        assertEquals("Duplo", h3.getDescricao());
        assertEquals(30.0, h3.getPrecoBase());
        assertNotSame(h1, h3);
    }

    @Test
    public void testPolimorfismoInterface() {
        PrototipoLanche h = new HamburguerPronto("Vegan", 22.0);
        assertTrue(h instanceof PrototipoLanche);
    }

    @Test
    public void testDescricaoNulaNoConstrutor() {
        HamburguerPronto h = new HamburguerPronto(null, 10.0);
        HamburguerPronto clone = (HamburguerPronto) h.clonar();
        assertNull(clone.getDescricao());
    }

    @Test
    public void testPrecoZero() {
        HamburguerPronto h = new HamburguerPronto("Brinde", 0.0);
        assertEquals(0.0, h.getPrecoBase());
    }
}
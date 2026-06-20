package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IteradorCardapioTest {

    @Test
    public void testContratoHasNextVerdadeiro() {
        IteradorCardapio i = new IteradorCardapio() {
            public boolean hasNext() { return true; }
            public ItemCardapio next() { return null; }
        };
        assertTrue(i.hasNext());
    }

    @Test
    public void testContratoHasNextFalso() {
        IteradorCardapio i = new IteradorCardapio() {
            public boolean hasNext() { return false; }
            public ItemCardapio next() { return null; }
        };
        assertFalse(i.hasNext());
    }

    @Test
    public void testContratoNextRetornaItem() {
        ItemCardapio item = new ItemIndividual("Bebida", 5.0);
        IteradorCardapio i = new IteradorCardapio() {
            public boolean hasNext() { return true; }
            public ItemCardapio next() { return item; }
        };
        assertEquals("Bebida", i.next().getNome());
    }

    @Test
    public void testContratoNextNulo() {
        IteradorCardapio i = new IteradorCardapio() {
            public boolean hasNext() { return false; }
            public ItemCardapio next() { return null; }
        };
        assertNull(i.next());
    }

    @Test
    public void testPolimorfismoInterface() {
        IteradorCardapio i = new IteradorCardapio() {
            public boolean hasNext() { return false; }
            public ItemCardapio next() { return null; }
        };
        assertTrue(i instanceof IteradorCardapio);
    }

    @Test
    public void testInstanciaAnonima() {
        assertNotNull((IteradorCardapio) new IteradorCardapio() {
            public boolean hasNext() { return true; }
            public ItemCardapio next() { return null; }
        });
    }

    @Test
    public void testMultiplasChamadasHasNext() {
        IteradorCardapio i = new IteradorCardapio() {
            public boolean hasNext() { return true; }
            public ItemCardapio next() { return null; }
        };
        assertEquals(i.hasNext(), i.hasNext());
    }

    @Test
    public void testMudancaDeEstadoHasNext() {
        final int[] chamadas = {0};
        IteradorCardapio i = new IteradorCardapio() {
            public boolean hasNext() { return chamadas[0]++ < 1; }
            public ItemCardapio next() { return null; }
        };
        assertTrue(i.hasNext());
        assertFalse(i.hasNext());
    }

    @Test
    public void testExcecaoNoNext() {
        IteradorCardapio i = new IteradorCardapio() {
            public boolean hasNext() { return false; }
            public ItemCardapio next() { throw new RuntimeException(); }
        };
        assertThrows(RuntimeException.class, i::next);
    }

    @Test
    public void testIndependenciaDeMetodos() {
        IteradorCardapio i = new IteradorCardapio() {
            public boolean hasNext() { return true; }
            public ItemCardapio next() { throw new IllegalArgumentException(); }
        };
        assertTrue(i.hasNext());
    }
}
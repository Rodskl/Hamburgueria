package hamburgueria;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class IteradorItensTest {

    @Test
    public void testHasNextListaVazia() {
        IteradorItens i = new IteradorItens(new ArrayList<>());
        assertFalse(i.hasNext());
    }

    @Test
    public void testHasNextListaNula() {
        IteradorItens i = new IteradorItens(null);
        assertFalse(i.hasNext());
    }

    @Test
    public void testHasNextComItens() {
        List<ItemCardapio> lista = new ArrayList<>();
        lista.add(new ItemIndividual("Teste", 1.0));
        IteradorItens i = new IteradorItens(lista);
        assertTrue(i.hasNext());
    }

    @Test
    public void testNextRetornaItemCorreto() {
        List<ItemCardapio> lista = new ArrayList<>();
        lista.add(new ItemIndividual("Bacon", 5.0));
        IteradorItens i = new IteradorItens(lista);
        assertEquals("Bacon", i.next().getNome());
    }

    @Test
    public void testNextAvancaPosicao() {
        List<ItemCardapio> lista = new ArrayList<>();
        lista.add(new ItemIndividual("A", 1.0));
        lista.add(new ItemIndividual("B", 2.0));
        IteradorItens i = new IteradorItens(lista);
        i.next();
        assertEquals("B", i.next().getNome());
    }

    @Test
    public void testNextLancaExcecaoQuandoVazio() {
        IteradorItens i = new IteradorItens(new ArrayList<>());
        assertThrows(NoSuchElementException.class, i::next);
    }

    @Test
    public void testNextLancaExcecaoAposEsgotar() {
        List<ItemCardapio> lista = new ArrayList<>();
        lista.add(new ItemIndividual("Unico", 1.0));
        IteradorItens i = new IteradorItens(lista);
        i.next();
        assertThrows(NoSuchElementException.class, i::next);
    }

    @Test
    public void testHasNextNaoAvancaPosicao() {
        List<ItemCardapio> lista = new ArrayList<>();
        lista.add(new ItemIndividual("Fixo", 1.0));
        IteradorItens i = new IteradorItens(lista);
        i.hasNext();
        i.hasNext();
        assertTrue(i.hasNext());
    }

    @Test
    public void testPolimorfismoIterador() {
        IteradorCardapio i = new IteradorItens(new ArrayList<>());
        assertTrue(i instanceof IteradorCardapio);
    }

    @Test
    public void testIndependenciaDeIteradores() {
        List<ItemCardapio> lista = new ArrayList<>();
        lista.add(new ItemIndividual("X", 1.0));
        lista.add(new ItemIndividual("Y", 2.0));
        
        IteradorItens i1 = new IteradorItens(lista);
        IteradorItens i2 = new IteradorItens(lista);
        
        i1.next();
        assertEquals("X", i2.next().getNome());
    }
}
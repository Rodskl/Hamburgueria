package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardapioTest {

    @Test
    public void testIteradorVazioInicialmente() {
        Cardapio c = new Cardapio();
        IteradorCardapio it = c.criarIterador();
        assertFalse(it.hasNext());
    }

    @Test
    public void testIteradorComUmItem() {
        Cardapio c = new Cardapio();
        c.adicionarItem(new ItemIndividual("Suco", 6.0));
        IteradorCardapio it = c.criarIterador();
        assertTrue(it.hasNext());
        assertEquals("Suco", it.next().getNome());
    }

    @Test
    public void testIgnoraItemNulo() {
        Cardapio c = new Cardapio();
        c.adicionarItem(null);
        IteradorCardapio it = c.criarIterador();
        assertFalse(it.hasNext());
    }

    @Test
    public void testOrdemDeInsercaoMantida() {
        Cardapio c = new Cardapio();
        c.adicionarItem(new ItemIndividual("Item 1", 1.0));
        c.adicionarItem(new ItemIndividual("Item 2", 2.0));
        IteradorCardapio it = c.criarIterador();
        assertEquals("Item 1", it.next().getNome());
        assertEquals("Item 2", it.next().getNome());
    }

    @Test
    public void testLimparMenu() {
        Cardapio c = new Cardapio();
        c.adicionarItem(new ItemIndividual("Teste", 10.0));
        c.limparMenu();
        IteradorCardapio it = c.criarIterador();
        assertFalse(it.hasNext());
    }

    @Test
    public void testIsolamentoDoIteradorAposCriacao() {
        Cardapio c = new Cardapio();
        c.adicionarItem(new ItemIndividual("Inicial", 5.0));
        IteradorCardapio it = c.criarIterador();
        c.adicionarItem(new ItemIndividual("Novo", 10.0));
        it.next(); 
        assertFalse(it.hasNext()); 
    }

    @Test
    public void testIndependenciaDeMultiplosIteradores() {
        Cardapio c = new Cardapio();
        c.adicionarItem(new ItemIndividual("Fixo", 10.0));
        IteradorCardapio it1 = c.criarIterador();
        IteradorCardapio it2 = c.criarIterador();
        it1.next();
        assertTrue(it2.hasNext());
    }

    @Test
    public void testRetornoDoTipoCorreto() {
        Cardapio c = new Cardapio();
        assertTrue(c.criarIterador() instanceof IteradorItens);
    }

    @Test
    public void testPolimorfismoAgregado() {
        Cardapio c = new Cardapio();
        assertTrue(c instanceof MenuAgregado);
    }

    @Test
    public void testInstanciaNaoNula() {
        assertNotNull(new Cardapio());
    }
}
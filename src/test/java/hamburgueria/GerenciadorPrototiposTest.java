package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GerenciadorPrototiposTest {

    @Test
    public void testQuantidadeInicialZero() {
        GerenciadorPrototipos g = new GerenciadorPrototipos();
        assertEquals(0, g.getQuantidade());
    }

    @Test
    public void testAdicionarPrototipo() {
        GerenciadorPrototipos g = new GerenciadorPrototipos();
        g.adicionarPrototipo("Padrao", new HamburguerPronto("Teste", 10.0));
        assertEquals(1, g.getQuantidade());
    }

    @Test
    public void testNaoAdicionarChaveNula() {
        GerenciadorPrototipos g = new GerenciadorPrototipos();
        g.adicionarPrototipo(null, new HamburguerPronto("Teste", 10.0));
        assertEquals(0, g.getQuantidade());
    }

    @Test
    public void testNaoAdicionarPrototipoNulo() {
        GerenciadorPrototipos g = new GerenciadorPrototipos();
        g.adicionarPrototipo("Chave", null);
        assertEquals(0, g.getQuantidade());
    }

    @Test
    public void testSobrescritaDeChave() {
        GerenciadorPrototipos g = new GerenciadorPrototipos();
        g.adicionarPrototipo("Unica", new HamburguerPronto("A", 1.0));
        g.adicionarPrototipo("Unica", new HamburguerPronto("B", 2.0));
        assertEquals(1, g.getQuantidade());
    }

    @Test
    public void testObterCloneComSucesso() {
        GerenciadorPrototipos g = new GerenciadorPrototipos();
        HamburguerPronto original = new HamburguerPronto("Promocao", 15.0);
        g.adicionarPrototipo("P1", original);
        PrototipoLanche clone = g.obterClone("P1");
        assertNotNull(clone);
        assertNotSame(original, clone);
        assertEquals("Promocao", clone.getDescricao());
    }

    @Test
    public void testObterCloneChaveInexistente() {
        GerenciadorPrototipos g = new GerenciadorPrototipos();
        assertNull(g.obterClone("Fantasma"));
    }

    @Test
    public void testObterCloneChaveNula() {
        GerenciadorPrototipos g = new GerenciadorPrototipos();
        assertNull(g.obterClone(null));
    }

    @Test
    public void testMultiplosClonesDaMesmaChave() {
        GerenciadorPrototipos g = new GerenciadorPrototipos();
        g.adicionarPrototipo("Ref", new HamburguerPronto("Ref", 1.0));
        PrototipoLanche c1 = g.obterClone("Ref");
        PrototipoLanche c2 = g.obterClone("Ref");
        assertNotSame(c1, c2);
    }

    @Test
    public void testInstanciaValida() {
        assertNotNull(new GerenciadorPrototipos());
    }
}
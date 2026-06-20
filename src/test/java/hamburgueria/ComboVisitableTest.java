package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComboVisitableTest {

    @Test
    public void testGetNome() {
        ComboVisitable c = new ComboVisitable("Combo Familia");
        assertEquals("Combo Familia", c.getNome());
    }

    @Test
    public void testListaInicialVazia() {
        ComboVisitable c = new ComboVisitable("Promocao");
        assertTrue(c.getItens().isEmpty());
    }

    @Test
    public void testAdicionarItemValido() {
        ComboVisitable c = new ComboVisitable("Teste");
        c.adicionar(new ProdutoVisitable("Agua", 2.0));
        assertEquals(1, c.getItens().size());
    }

    @Test
    public void testAdicionarItemNulo() {
        ComboVisitable c = new ComboVisitable("Teste");
        c.adicionar(null);
        assertTrue(c.getItens().isEmpty());
    }

    @Test
    public void testAceitarChamaVisitor() {
        ComboVisitable c = new ComboVisitable("Especial");
        VisitorExportacao v = new VisitorExportacao() {
            public String visitarProduto(ProdutoVisitable p) { return ""; }
            public String visitarCombo(ComboVisitable combo) { return combo.getNome(); }
        };
        assertEquals("Especial", c.aceitar(v));
    }

    @Test
    public void testAceitarVisitorNulo() {
        ComboVisitable c = new ComboVisitable("Basico");
        assertEquals("", c.aceitar(null));
    }

    @Test
    public void testGetItensImutavel() {
        ComboVisitable c = new ComboVisitable("Mix");
        c.adicionar(new ProdutoVisitable("A", 1.0));
        c.getItens().clear();
        assertFalse(c.getItens().isEmpty());
    }

    @Test
    public void testOrdemDeInsercao() {
        ComboVisitable c = new ComboVisitable("Lista");
        c.adicionar(new ProdutoVisitable("1", 1.0));
        c.adicionar(new ProdutoVisitable("2", 2.0));
        assertEquals("1", ((ProdutoVisitable) c.getItens().get(0)).getNome());
        assertEquals("2", ((ProdutoVisitable) c.getItens().get(1)).getNome());
    }

    @Test
    public void testPolimorfismo() {
        ElementoVisitable c = new ComboVisitable("Teste");
        assertTrue(c instanceof ElementoVisitable);
    }

    @Test
    public void testInstanciaNaoNula() {
        assertNotNull(new ComboVisitable("X"));
    }
}
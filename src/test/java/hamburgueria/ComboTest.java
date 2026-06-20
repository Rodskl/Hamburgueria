package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComboTest {

    @Test
    public void testNomeCombo() {
        Combo c = new Combo("Combo Master", 0.10);
        assertEquals("Combo Master", c.getNome());
    }

    @Test
    public void testListaInicialVazia() {
        Combo c = new Combo("Promocao", 0.0);
        assertEquals(0, c.getQuantidadeItens());
    }

    @Test
    public void testAdicionarItem() {
        Combo c = new Combo("Especial", 0.0);
        c.adicionarItem(new ItemIndividual("Burger", 20.0));
        assertEquals(1, c.getQuantidadeItens());
    }

    @Test
    public void testRemoverItem() {
        Combo c = new Combo("Especial", 0.0);
        ItemCardapio burger = new ItemIndividual("Burger", 20.0);
        c.adicionarItem(burger);
        c.removerItem(burger);
        assertEquals(0, c.getQuantidadeItens());
    }

    @Test
    public void testPrecoSemDesconto() {
        Combo c = new Combo("Casal", 0.0);
        c.adicionarItem(new ItemIndividual("Burger 1", 20.0));
        c.adicionarItem(new ItemIndividual("Burger 2", 25.0));
        assertEquals(45.0, c.getPreco());
    }

    @Test
    public void testPrecoComDesconto() {
        Combo c = new Combo("Trio", 0.10); 
        c.adicionarItem(new ItemIndividual("Burger", 20.0));
        c.adicionarItem(new ItemIndividual("Batata", 10.0));
        c.adicionarItem(new ItemIndividual("Refrigerante", 10.0));
        assertEquals(36.0, c.getPreco()); 
    }

    @Test
    public void testAdicionarNull() {
        Combo c = new Combo("Furada", 0.0);
        c.adicionarItem(null);
        assertEquals(0, c.getQuantidadeItens());
    }

    @Test
    public void testComboAninhado() {
        Combo comboLanche = new Combo("Combo Lanche", 0.0);
        comboLanche.adicionarItem(new ItemIndividual("Burger", 30.0));
        comboLanche.adicionarItem(new ItemIndividual("Batata", 10.0));

        Combo superCombo = new Combo("Super Combo Familia", 0.50); 
        superCombo.adicionarItem(comboLanche);
        superCombo.adicionarItem(new ItemIndividual("Refrigerante 2L", 10.0));

        assertEquals(25.0, superCombo.getPreco());
    }

    @Test
    public void testPolimorfismo() {
        Combo c = new Combo("Teste", 0.0);
        assertTrue(c instanceof ItemCardapio);
    }

    @Test
    public void testDescontoTotalGratis() {
        Combo c = new Combo("Sorteio", 1.0); 
        c.adicionarItem(new ItemIndividual("Tudo", 100.0));
        assertEquals(0.0, c.getPreco());
    }
}
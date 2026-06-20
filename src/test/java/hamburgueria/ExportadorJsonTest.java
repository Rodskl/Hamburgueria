package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExportadorJsonTest {

    @Test
    public void testVisitarProdutoValido() {
        ExportadorJson e = new ExportadorJson();
        ProdutoVisitable p = new ProdutoVisitable("Burger", 20.0);
        assertEquals("{\"nome\":\"Burger\",\"preco\":20.0}", e.visitarProduto(p));
    }

    @Test
    public void testVisitarProdutoNulo() {
        ExportadorJson e = new ExportadorJson();
        assertEquals("{}", e.visitarProduto(null));
    }

    @Test
    public void testVisitarComboVazio() {
        ExportadorJson e = new ExportadorJson();
        ComboVisitable c = new ComboVisitable("Vazio");
        assertEquals("{\"combo\":\"Vazio\",\"itens\":[]}", e.visitarCombo(c));
    }

    @Test
    public void testVisitarComboNulo() {
        ExportadorJson e = new ExportadorJson();
        assertEquals("{}", e.visitarCombo(null));
    }

    @Test
    public void testVisitarComboComUmProduto() {
        ExportadorJson e = new ExportadorJson();
        ComboVisitable c = new ComboVisitable("Trio");
        c.adicionar(new ProdutoVisitable("Suco", 5.0));
        assertEquals("{\"combo\":\"Trio\",\"itens\":[{\"nome\":\"Suco\",\"preco\":5.0}]}", e.visitarCombo(c));
    }

    @Test
    public void testVisitarComboComVariosProdutos() {
        ExportadorJson e = new ExportadorJson();
        ComboVisitable c = new ComboVisitable("Duplo");
        c.adicionar(new ProdutoVisitable("A", 1.0));
        c.adicionar(new ProdutoVisitable("B", 2.0));
        String experado = "{\"combo\":\"Duplo\",\"itens\":[{\"nome\":\"A\",\"preco\":1.0},{\"nome\":\"B\",\"preco\":2.0}]}";
        assertEquals(experado, e.visitarCombo(c));
    }

    @Test
    public void testFormatacaoProdutoZero() {
        ExportadorJson e = new ExportadorJson();
        ProdutoVisitable p = new ProdutoVisitable("Brinde", 0.0);
        assertEquals("{\"nome\":\"Brinde\",\"preco\":0.0}", e.visitarProduto(p));
    }

    @Test
    public void testFormatacaoProdutoCaracteresEspeciais() {
        ExportadorJson e = new ExportadorJson();
        ProdutoVisitable p = new ProdutoVisitable("A & B", 10.5);
        assertEquals("{\"nome\":\"A & B\",\"preco\":10.5}", e.visitarProduto(p));
    }

    @Test
    public void testPolimorfismo() {
        VisitorExportacao e = new ExportadorJson();
        assertTrue(e instanceof VisitorExportacao);
    }

    @Test
    public void testInstanciaNaoNula() {
        assertNotNull(new ExportadorJson());
    }
}
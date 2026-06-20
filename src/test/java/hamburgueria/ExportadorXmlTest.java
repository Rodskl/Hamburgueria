package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExportadorXmlTest {

    @Test
    public void testVisitarProdutoValido() {
        ExportadorXml e = new ExportadorXml();
        ProdutoVisitable p = new ProdutoVisitable("Batata", 10.0);
        assertEquals("<produto><nome>Batata</nome><preco>10.0</preco></produto>", e.visitarProduto(p));
    }

    @Test
    public void testVisitarProdutoNulo() {
        ExportadorXml e = new ExportadorXml();
        assertEquals("<produto/>", e.visitarProduto(null));
    }

    @Test
    public void testVisitarComboVazio() {
        ExportadorXml e = new ExportadorXml();
        ComboVisitable c = new ComboVisitable("Vazio");
        assertEquals("<combo nome=\"Vazio\"><itens></itens></combo>", e.visitarCombo(c));
    }

    @Test
    public void testVisitarComboNulo() {
        ExportadorXml e = new ExportadorXml();
        assertEquals("<combo/>", e.visitarCombo(null));
    }

    @Test
    public void testVisitarComboComUmProduto() {
        ExportadorXml e = new ExportadorXml();
        ComboVisitable c = new ComboVisitable("Trio");
        c.adicionar(new ProdutoVisitable("Agua", 3.0));
        String esperado = "<combo nome=\"Trio\"><itens><produto><nome>Agua</nome><preco>3.0</preco></produto></itens></combo>";
        assertEquals(esperado, e.visitarCombo(c));
    }

    @Test
    public void testVisitarComboComVariosProdutos() {
        ExportadorXml e = new ExportadorXml();
        ComboVisitable c = new ComboVisitable("Duplo");
        c.adicionar(new ProdutoVisitable("X", 1.0));
        c.adicionar(new ProdutoVisitable("Y", 2.0));
        String ex = "<combo nome=\"Duplo\"><itens><produto><nome>X</nome><preco>1.0</preco></produto><produto><nome>Y</nome><preco>2.0</preco></produto></itens></combo>";
        assertEquals(ex, e.visitarCombo(c));
    }

    @Test
    public void testFormatacaoProdutoZero() {
        ExportadorXml e = new ExportadorXml();
        ProdutoVisitable p = new ProdutoVisitable("Free", 0.0);
        assertEquals("<produto><nome>Free</nome><preco>0.0</preco></produto>", e.visitarProduto(p));
    }

    @Test
    public void testFormatacaoProdutoCaracteresEspeciais() {
        ExportadorXml e = new ExportadorXml();
        ProdutoVisitable p = new ProdutoVisitable("A & B", 10.5);
        assertEquals("<produto><nome>A & B</nome><preco>10.5</preco></produto>", e.visitarProduto(p));
    }

    @Test
    public void testPolimorfismo() {
        VisitorExportacao e = new ExportadorXml();
        assertTrue(e instanceof VisitorExportacao);
    }

    @Test
    public void testInstanciaNaoNula() {
        assertNotNull(new ExportadorXml());
    }
}
package hamburgueria;

public interface VisitorExportacao {
    String visitarProduto(ProdutoVisitable produto);
    String visitarCombo(ComboVisitable combo);
}
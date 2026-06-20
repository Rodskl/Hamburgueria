package hamburgueria;

public class ExportadorXml implements VisitorExportacao {

    @Override
    public String visitarProduto(ProdutoVisitable produto) {
        if (produto == null) {
            return "<produto/>";
        }
        return "<produto><nome>" + produto.getNome() + "</nome><preco>" + produto.getPreco() + "</preco></produto>";
    }

    @Override
    public String visitarCombo(ComboVisitable combo) {
        if (combo == null) {
            return "<combo/>";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<combo nome=\"").append(combo.getNome()).append("\"><itens>");
        for (ElementoVisitable item : combo.getItens()) {
            sb.append(item.aceitar(this));
        }
        sb.append("</itens></combo>");
        return sb.toString();
    }
}
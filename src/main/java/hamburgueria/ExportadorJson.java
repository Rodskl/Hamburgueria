package hamburgueria;

public class ExportadorJson implements VisitorExportacao {

    @Override
    public String visitarProduto(ProdutoVisitable produto) {
        if (produto == null) {
            return "{}";
        }
        return "{\"nome\":\"" + produto.getNome() + "\",\"preco\":" + produto.getPreco() + "}";
    }

    @Override
    public String visitarCombo(ComboVisitable combo) {
        if (combo == null) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{\"combo\":\"").append(combo.getNome()).append("\",\"itens\":[");
        for (int i = 0; i < combo.getItens().size(); i++) {
            sb.append(combo.getItens().get(i).aceitar(this));
            if (i < combo.getItens().size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]}");
        return sb.toString();
    }
}
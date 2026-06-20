package hamburgueria;

public class ProdutoVisitable implements ElementoVisitable {
    private String nome;
    private double preco;

    public ProdutoVisitable(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String aceitar(VisitorExportacao visitor) {
        if (visitor != null) {
            return visitor.visitarProduto(this);
        }
        return "";
    }
}
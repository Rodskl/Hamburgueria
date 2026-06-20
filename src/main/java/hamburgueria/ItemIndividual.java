package hamburgueria;

public class ItemIndividual implements ItemCardapio {
    private String nome;
    private double preco;

    public ItemIndividual(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }
}
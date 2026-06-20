package hamburgueria;

public class IngredienteBase implements IngredienteFlyweight {
    private final String nome;
    private final double custo;

    public IngredienteBase(String nome, double custo) {
        this.nome = nome;
        this.custo = custo;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public double getCusto() {
        return this.custo;
    }

    @Override
    public String adicionarAoLanche(String contextoLanche) {
        if (contextoLanche == null) {
            return "Pedido sem identificacao recebe " + this.nome;
        }
        return contextoLanche + " recebe " + this.nome;
    }
}
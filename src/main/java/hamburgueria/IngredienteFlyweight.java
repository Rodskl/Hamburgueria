package hamburgueria;

public interface IngredienteFlyweight {
    String getNome();
    double getCusto();
    String adicionarAoLanche(String contextoLanche);
}
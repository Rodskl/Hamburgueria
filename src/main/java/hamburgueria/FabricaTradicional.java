package hamburgueria;

public class FabricaTradicional implements FabricaIngredientes {

    @Override
    public Pao criarPao() {
        return () -> "Brioche";
    }

    @Override
    public Carne criarCarne() {
        return () -> "Bovina";
    }
}
package hamburgueria;

public class FabricaVegana implements FabricaIngredientes {

    @Override
    public Pao criarPao() {
        return () -> "Integral";
    }

    @Override
    public Carne criarCarne() {
        return () -> "Soja";
    }
}
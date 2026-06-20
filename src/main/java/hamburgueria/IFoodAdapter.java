package hamburgueria;

public class IFoodAdapter implements PedidoDelivery {
    private SistemaIFood sistemaExterno;
    private String tokenAutenticacao;

    public IFoodAdapter(SistemaIFood sistemaExterno, String tokenAutenticacao) {
        this.sistemaExterno = sistemaExterno;
        this.tokenAutenticacao = tokenAutenticacao;
    }

    @Override
    public String agendarEntrega(String endereco) {
        if (sistemaExterno == null) {
            return "Servico indisponivel";
        }
        return sistemaExterno.despacharMotoqueiro(endereco, tokenAutenticacao);
    }
}
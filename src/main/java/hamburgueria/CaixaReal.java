package hamburgueria;

public class CaixaReal implements OperacaoCaixa {
    private double saldo;

    public CaixaReal(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    @Override
    public String processarEstorno(double valor) {
        if (valor <= 0) {
            return "Valor invalido para estorno";
        }
        if (valor > saldo) {
            return "Saldo insuficiente no caixa";
        }
        saldo -= valor;
        return "Estorno processado com sucesso: R$" + valor;
    }

    public double getSaldo() {
        return saldo;
    }
}
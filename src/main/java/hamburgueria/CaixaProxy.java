package hamburgueria;

public class CaixaProxy implements OperacaoCaixa {
    private CaixaReal caixaReal;
    private String senhaAcesso;
    private String nivelAcesso;

    public CaixaProxy(CaixaReal caixaReal, String senhaAcesso, String nivelAcesso) {
        this.caixaReal = caixaReal;
        this.senhaAcesso = senhaAcesso;
        this.nivelAcesso = nivelAcesso;
    }

    @Override
    public String processarEstorno(double valor) {
        if (caixaReal == null) {
            return "Caixa indisponivel";
        }
        if (!"GERENTE".equals(nivelAcesso)) {
            return "Acesso negado: apenas gerentes podem estornar";
        }
        if (!"1234".equals(senhaAcesso)) {
            return "Acesso negado: senha incorreta";
        }
        return caixaReal.processarEstorno(valor);
    }
}
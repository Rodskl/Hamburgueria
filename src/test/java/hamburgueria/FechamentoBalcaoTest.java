package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FechamentoBalcaoTest {

    @Test
    public void testFecharComEmissorFisico() {
        FechamentoBalcao f = new FechamentoBalcao(new EmissorReciboFisico());
        assertEquals("Fechamento Balcao -> Imprimindo recibo fisico: X-Salada - R$20.0", f.fechar("X-Salada", 20.0));
    }

    @Test
    public void testFecharComEmissorDigital() {
        FechamentoBalcao f = new FechamentoBalcao(new EmissorReciboDigital());
        assertEquals("Fechamento Balcao -> Enviando recibo digital: X-Bacon - R$25.0", f.fechar("X-Bacon", 25.0));
    }

    @Test
    public void testFecharComEmissorNulo() {
        FechamentoBalcao f = new FechamentoBalcao(null);
        assertEquals("Erro no fechamento", f.fechar("X-Tudo", 30.0));
    }

    @Test
    public void testFecharComValorZero() {
        FechamentoBalcao f = new FechamentoBalcao((p, v) -> v + "");
        assertEquals("Fechamento Balcao -> 0.0", f.fechar("Agua", 0.0));
    }

    @Test
    public void testFecharComValorNegativo() {
        FechamentoBalcao f = new FechamentoBalcao((p, v) -> v + "");
        assertEquals("Fechamento Balcao -> -10.0", f.fechar("Erro", -10.0));
    }

    @Test
    public void testFecharComPedidoNulo() {
        FechamentoBalcao f = new FechamentoBalcao((p, v) -> p + "");
        assertEquals("Fechamento Balcao -> null", f.fechar(null, 10.0));
    }

    @Test
    public void testPolimorfismo() {
        FechamentoConta f = new FechamentoBalcao(null);
        assertTrue(f instanceof FechamentoConta);
    }

    @Test
    public void testInstanciaValida() {
        assertNotNull(new FechamentoBalcao(null));
    }

    @Test
    public void testNaoAplicaTaxaDelivery() {
        FechamentoBalcao f = new FechamentoBalcao((p, v) -> v + "");
        assertEquals("Fechamento Balcao -> 50.0", f.fechar("Combo", 50.0));
    }

    @Test
    public void testRetornoContemBalcao() {
        FechamentoBalcao f = new FechamentoBalcao(new EmissorReciboFisico());
        assertTrue(f.fechar("A", 1.0).contains("Balcao"));
    }
}
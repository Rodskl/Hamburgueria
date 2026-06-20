package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FechamentoDeliveryTest {

    @Test
    public void testFecharComEmissorFisicoAplicaTaxa() {
        FechamentoDelivery f = new FechamentoDelivery(new EmissorReciboFisico());
        assertEquals("Fechamento Delivery (+Taxa) -> Imprimindo recibo fisico: X-Salada - R$25.0", f.fechar("X-Salada", 20.0));
    }

    @Test
    public void testFecharComEmissorDigitalAplicaTaxa() {
        FechamentoDelivery f = new FechamentoDelivery(new EmissorReciboDigital());
        assertEquals("Fechamento Delivery (+Taxa) -> Enviando recibo digital: X-Bacon - R$30.0", f.fechar("X-Bacon", 25.0));
    }

    @Test
    public void testFecharComEmissorNulo() {
        FechamentoDelivery f = new FechamentoDelivery(null);
        assertEquals("Erro no fechamento", f.fechar("X-Tudo", 30.0));
    }

    @Test
    public void testFecharComValorZero() {
        FechamentoDelivery f = new FechamentoDelivery((p, v) -> v + "");
        assertEquals("Fechamento Delivery (+Taxa) -> 5.0", f.fechar("Agua", 0.0));
    }

    @Test
    public void testFecharComValorNegativo() {
        FechamentoDelivery f = new FechamentoDelivery((p, v) -> v + "");
        assertEquals("Fechamento Delivery (+Taxa) -> -5.0", f.fechar("Erro", -10.0));
    }

    @Test
    public void testFecharComPedidoNulo() {
        FechamentoDelivery f = new FechamentoDelivery((p, v) -> p + "");
        assertEquals("Fechamento Delivery (+Taxa) -> null", f.fechar(null, 10.0));
    }

    @Test
    public void testPolimorfismo() {
        FechamentoConta f = new FechamentoDelivery(null);
        assertTrue(f instanceof FechamentoConta);
    }

    @Test
    public void testInstanciaValida() {
        assertNotNull(new FechamentoDelivery(null));
    }

    @Test
    public void testRetornoContemDelivery() {
        FechamentoDelivery f = new FechamentoDelivery(new EmissorReciboFisico());
        assertTrue(f.fechar("A", 1.0).contains("Delivery"));
    }

    @Test
    public void testRetornoContemTaxa() {
        FechamentoDelivery f = new FechamentoDelivery(new EmissorReciboFisico());
        assertTrue(f.fechar("A", 1.0).contains("+Taxa"));
    }
}
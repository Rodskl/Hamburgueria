package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoDeliveryTest {

    @Test
    public void testContratoRetornoValido() {
        PedidoDelivery p = endereco -> "Entrega para " + endereco;
        assertEquals("Entrega para Centro", p.agendarEntrega("Centro"));
    }

    @Test
    public void testContratoRetornoNulo() {
        PedidoDelivery p = endereco -> null;
        assertNull(p.agendarEntrega("Rua A"));
    }

    @Test
    public void testContratoEnderecoNulo() {
        PedidoDelivery p = endereco -> endereco == null ? "Sem endereco" : endereco;
        assertEquals("Sem endereco", p.agendarEntrega(null));
    }

    @Test
    public void testContratoEnderecoVazio() {
        PedidoDelivery p = endereco -> endereco;
        assertEquals("", p.agendarEntrega(""));
    }

    @Test
    public void testContratoEnderecoEspacos() {
        PedidoDelivery p = endereco -> endereco;
        assertEquals("   ", p.agendarEntrega("   "));
    }

    @Test
    public void testMultiplasChamadas() {
        PedidoDelivery p = endereco -> "Fixo";
        assertEquals(p.agendarEntrega("A"), p.agendarEntrega("B"));
    }

    @Test
    public void testPolimorfismoInterface() {
        PedidoDelivery p = endereco -> "Ok";
        assertTrue(p instanceof PedidoDelivery);
    }

    @Test
    public void testInstanciaAnonima() {
        assertNotNull((PedidoDelivery) endereco -> "Teste");
    }

    @Test
    public void testExcecaoNaImplementacao() {
        PedidoDelivery p = endereco -> { throw new IllegalArgumentException(); };
        assertThrows(IllegalArgumentException.class, () -> p.agendarEntrega("X"));
    }

    @Test
    public void testCaseSensitivityContrato() {
        PedidoDelivery p = endereco -> endereco.toUpperCase();
        assertEquals("RUA B", p.agendarEntrega("rua b"));
    }
}
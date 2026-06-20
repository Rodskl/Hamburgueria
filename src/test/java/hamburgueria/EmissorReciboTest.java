package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmissorReciboTest {

    @Test
    public void testInterfaceEmitirValido() {
        EmissorRecibo e = (pedido, valor) -> pedido + "-" + valor;
        assertEquals("X-Tudo-25.0", e.emitir("X-Tudo", 25.0));
    }

    @Test
    public void testInterfaceEmitirZero() {
        EmissorRecibo e = (pedido, valor) -> String.valueOf(valor);
        assertEquals("0.0", e.emitir("Agua", 0.0));
    }

    @Test
    public void testInterfaceEmitirNegativo() {
        EmissorRecibo e = (pedido, valor) -> String.valueOf(valor);
        assertEquals("-5.0", e.emitir("Desconto", -5.0));
    }

    @Test
    public void testInterfacePedidoNulo() {
        EmissorRecibo e = (pedido, valor) -> pedido == null ? "Nulo" : pedido;
        assertEquals("Nulo", e.emitir(null, 10.0));
    }

    @Test
    public void testInterfacePedidoVazio() {
        EmissorRecibo e = (pedido, valor) -> pedido;
        assertEquals("", e.emitir("", 15.0));
    }

    @Test
    public void testPolimorfismo() {
        EmissorRecibo e = (pedido, valor) -> "OK";
        assertTrue(e instanceof EmissorRecibo);
    }

    @Test
    public void testMultiplasChamadas() {
        EmissorRecibo e = (pedido, valor) -> "Fixo";
        assertEquals(e.emitir("A", 1.0), e.emitir("B", 2.0));
    }

    @Test
    public void testExcecaoNaImplementacao() {
        EmissorRecibo e = (pedido, valor) -> { throw new IllegalArgumentException(); };
        assertThrows(IllegalArgumentException.class, () -> e.emitir("Teste", 10.0));
    }

    @Test
    public void testInstanciaAnonima() {
        assertNotNull((EmissorRecibo) (pedido, valor) -> "Retorno");
    }

    @Test
    public void testFormatacaoString() {
        EmissorRecibo e = (pedido, valor) -> String.format("%s: R$%.2f", pedido, valor);
        assertEquals("Burger: R$20,00", e.emitir("Burger", 20.00).replace(".", ","));
    }
}
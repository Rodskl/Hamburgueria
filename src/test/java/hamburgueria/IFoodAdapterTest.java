package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IFoodAdapterTest {

    @Test
    public void testAgendamentoComSucesso() {
        SistemaIFood sys = new SistemaIFood();
        IFoodAdapter adapter = new IFoodAdapter(sys, "ABC");
        String res = adapter.agendarEntrega("Rua Principal");
        assertEquals("Motoqueiro a caminho de Rua Principal [Token: ABC]", res);
    }

    @Test
    public void testSistemaExternoNulo() {
        IFoodAdapter adapter = new IFoodAdapter(null, "ABC");
        assertEquals("Servico indisponivel", adapter.agendarEntrega("Rua X"));
    }

    @Test
    public void testTokenNulo() {
        SistemaIFood sys = new SistemaIFood();
        IFoodAdapter adapter = new IFoodAdapter(sys, null);
        assertEquals("Erro de integracao", adapter.agendarEntrega("Rua X"));
    }

    @Test
    public void testEnderecoNuloPeloAdapter() {
        SistemaIFood sys = new SistemaIFood();
        IFoodAdapter adapter = new IFoodAdapter(sys, "ABC");
        assertEquals("Erro de integracao", adapter.agendarEntrega(null));
    }

    @Test
    public void testEnderecoVazioPeloAdapter() {
        SistemaIFood sys = new SistemaIFood();
        IFoodAdapter adapter = new IFoodAdapter(sys, "ABC");
        assertEquals("Dados incompletos", adapter.agendarEntrega(""));
    }

    @Test
    public void testTokenVazioPeloAdapter() {
        SistemaIFood sys = new SistemaIFood();
        IFoodAdapter adapter = new IFoodAdapter(sys, "");
        assertEquals("Dados incompletos", adapter.agendarEntrega("Rua X"));
    }

    @Test
    public void testPolimorfismoAdapter() {
        SistemaIFood sys = new SistemaIFood();
        PedidoDelivery adapter = new IFoodAdapter(sys, "123");
        assertTrue(adapter instanceof PedidoDelivery);
    }

    @Test
    public void testReaproveitamentoDoAdapter() {
        SistemaIFood sys = new SistemaIFood();
        IFoodAdapter adapter = new IFoodAdapter(sys, "123");
        adapter.agendarEntrega("Rua A");
        String res = adapter.agendarEntrega("Rua B");
        assertEquals("Motoqueiro a caminho de Rua B [Token: 123]", res);
    }

    @Test
    public void testTipoDaClasseAdaptee() {
        IFoodAdapter adapter = new IFoodAdapter(new SistemaIFood(), "T");
        assertNotNull(adapter);
    }

    @Test
    public void testIsolamentoDeInstancias() {
        SistemaIFood sys1 = new SistemaIFood();
        SistemaIFood sys2 = new SistemaIFood();
        IFoodAdapter a1 = new IFoodAdapter(sys1, "A");
        IFoodAdapter a2 = new IFoodAdapter(sys2, "B");
        assertNotEquals(a1.agendarEntrega("Rua"), a2.agendarEntrega("Rua"));
    }
}
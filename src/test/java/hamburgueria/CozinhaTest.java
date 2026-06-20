package hamburgueria;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CozinhaTest {

    @Test
    public void testEstadoInicialVazio() {
        Cozinha c = new Cozinha();
        assertTrue(c.getPreparados().isEmpty());
    }

    @Test
    public void testPrepararLancheValido() {
        Cozinha c = new Cozinha();
        c.prepararLanche("X-Burger");
        assertEquals(1, c.getPreparados().size());
        assertEquals("Lanche: X-Burger", c.getPreparados().get(0));
    }

    @Test
    public void testPrepararLancheNulo() {
        Cozinha c = new Cozinha();
        c.prepararLanche(null);
        assertTrue(c.getPreparados().isEmpty());
    }

    @Test
    public void testPrepararLancheVazio() {
        Cozinha c = new Cozinha();
        c.prepararLanche("   ");
        assertTrue(c.getPreparados().isEmpty());
    }

    @Test
    public void testFritarAcompanhamentoValido() {
        Cozinha c = new Cozinha();
        c.fritarAcompanhamento("Batata Frita");
        assertEquals(1, c.getPreparados().size());
        assertEquals("Acompanhamento: Batata Frita", c.getPreparados().get(0));
    }

    @Test
    public void testFritarAcompanhamentoNulo() {
        Cozinha c = new Cozinha();
        c.fritarAcompanhamento(null);
        assertTrue(c.getPreparados().isEmpty());
    }

    @Test
    public void testFritarAcompanhamentoVazio() {
        Cozinha c = new Cozinha();
        c.fritarAcompanhamento("");
        assertTrue(c.getPreparados().isEmpty());
    }

    @Test
    public void testMultiplosPreparosOrdem() {
        Cozinha c = new Cozinha();
        c.prepararLanche("Burger");
        c.fritarAcompanhamento("Onion Rings");
        List<String> p = c.getPreparados();
        assertEquals(2, p.size());
        assertEquals("Lanche: Burger", p.get(0));
        assertEquals("Acompanhamento: Onion Rings", p.get(1));
    }

    @Test
    public void testLimparCozinha() {
        Cozinha c = new Cozinha();
        c.prepararLanche("Burger");
        c.limparCozinha();
        assertTrue(c.getPreparados().isEmpty());
    }

    @Test
    public void testEncapsulamentoLista() {
        Cozinha c = new Cozinha();
        c.prepararLanche("Burger");
        List<String> externa = c.getPreparados();
        externa.clear();
        assertFalse(c.getPreparados().isEmpty());
    }
}
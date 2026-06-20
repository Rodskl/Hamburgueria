package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmbalagemViagemTest {

    @Test
    public void testGetTipoRetornoExato() {
        EmbalagemViagem e = new EmbalagemViagem();
        assertEquals("Sacola de papel selada para viagem", e.getTipo());
    }

    @Test
    public void testGetTipoNaoNulo() {
        EmbalagemViagem e = new EmbalagemViagem();
        assertNotNull(e.getTipo());
    }

    @Test
    public void testGetTipoNaoVazio() {
        EmbalagemViagem e = new EmbalagemViagem();
        assertFalse(e.getTipo().isEmpty());
    }

    @Test
    public void testPolimorfismoProduto() {
        EmbalagemViagem e = new EmbalagemViagem();
        assertTrue(e instanceof Embalagem);
    }

    @Test
    public void testInstanciasDiferentes() {
        EmbalagemViagem e1 = new EmbalagemViagem();
        EmbalagemViagem e2 = new EmbalagemViagem();
        assertNotSame(e1, e2);
    }

    @Test
    public void testMultiplasChamadasManteemValor() {
        EmbalagemViagem e = new EmbalagemViagem();
        assertEquals(e.getTipo(), e.getTipo());
    }

    @Test
    public void testNaoEhEmbalagemBalcao() {
        EmbalagemViagem e = new EmbalagemViagem();
        assertNotEquals("Bandeja para consumo no local", e.getTipo());
    }

    @Test
    public void testTipoDaClasse() {
        Embalagem e = new EmbalagemViagem();
        assertEquals(EmbalagemViagem.class, e.getClass());
    }

    @Test
    public void testComprimentoDaString() {
        EmbalagemViagem e = new EmbalagemViagem();
        assertTrue(e.getTipo().length() > 10);
    }

    @Test
    public void testInstanciaCriada() {
        assertNotNull(new EmbalagemViagem());
    }
}
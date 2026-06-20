package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmbalagemBalcaoTest {

    @Test
    public void testGetTipoRetornoExato() {
        EmbalagemBalcao e = new EmbalagemBalcao();
        assertEquals("Bandeja para consumo no local", e.getTipo());
    }

    @Test
    public void testGetTipoNaoNulo() {
        EmbalagemBalcao e = new EmbalagemBalcao();
        assertNotNull(e.getTipo());
    }

    @Test
    public void testGetTipoNaoVazio() {
        EmbalagemBalcao e = new EmbalagemBalcao();
        assertFalse(e.getTipo().isEmpty());
    }

    @Test
    public void testPolimorfismoProduto() {
        EmbalagemBalcao e = new EmbalagemBalcao();
        assertTrue(e instanceof Embalagem);
    }

    @Test
    public void testInstanciasDiferentes() {
        EmbalagemBalcao e1 = new EmbalagemBalcao();
        EmbalagemBalcao e2 = new EmbalagemBalcao();
        assertNotSame(e1, e2);
    }

    @Test
    public void testMultiplasChamadasManteemValor() {
        EmbalagemBalcao e = new EmbalagemBalcao();
        assertEquals(e.getTipo(), e.getTipo());
    }

    @Test
    public void testNaoEhEmbalagemViagem() {
        EmbalagemBalcao e = new EmbalagemBalcao();
        assertNotEquals("Sacola de viagem", e.getTipo());
    }

    @Test
    public void testTipoDaClasse() {
        Embalagem e = new EmbalagemBalcao();
        assertEquals(EmbalagemBalcao.class, e.getClass());
    }

    @Test
    public void testComprimentoDaString() {
        EmbalagemBalcao e = new EmbalagemBalcao();
        assertTrue(e.getTipo().length() > 10);
    }

    @Test
    public void testInstanciaCriada() {
        assertNotNull(new EmbalagemBalcao());
    }
}
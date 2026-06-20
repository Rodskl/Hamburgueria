package hamburgueria;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MontagemArtesanalTest {

    @Test
    public void testQuantidadeDePassosArtesanal() {
        MontagemArtesanal m = new MontagemArtesanal();
        m.montarLanche();
        assertEquals(4, m.getPassos().size());
    }

    @Test
    public void testPrepararPaoArtesanal() {
        MontagemArtesanal m = new MontagemArtesanal();
        m.montarLanche();
        assertEquals("Selando pao brioche na manteiga", m.getPassos().get(0));
    }

    @Test
    public void testAdicionarCarneArtesanal() {
        MontagemArtesanal m = new MontagemArtesanal();
        m.montarLanche();
        assertEquals("Grelhando blend de 180g ao ponto", m.getPassos().get(1));
    }

    @Test
    public void testAdicionarAcompanhamentosArtesanal() {
        MontagemArtesanal m = new MontagemArtesanal();
        m.montarLanche();
        assertEquals("Adicionando cheddar e cebola caramelizada", m.getPassos().get(2));
    }

    @Test
    public void testFinalizacaoPadraoMantida() {
        MontagemArtesanal m = new MontagemArtesanal();
        m.montarLanche();
        assertEquals("Lanche embalado e pronto", m.getPassos().get(3));
    }

    @Test
    public void testHerancaTemplate() {
        MontagemArtesanal m = new MontagemArtesanal();
        assertTrue(m instanceof MontagemTemplate);
    }

    @Test
    public void testListaEncapsuladaVaziaInicialmente() {
        MontagemArtesanal m = new MontagemArtesanal();
        assertTrue(m.getPassos().isEmpty());
    }

    @Test
    public void testMultiplasMontagensLimpamLista() {
        MontagemArtesanal m = new MontagemArtesanal();
        m.montarLanche();
        m.montarLanche();
        m.montarLanche();
        assertEquals(4, m.getPassos().size());
    }

    @Test
    public void testConteudoNaoNuloNosPassos() {
        MontagemArtesanal m = new MontagemArtesanal();
        m.montarLanche();
        for (String passo : m.getPassos()) {
            assertNotNull(passo);
        }
    }

    @Test
    public void testTipagemExataDaClasse() {
        MontagemTemplate m = new MontagemArtesanal();
        assertEquals(MontagemArtesanal.class, m.getClass());
    }
}
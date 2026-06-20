package hamburgueria;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MontagemSmashTest {

    @Test
    public void testQuantidadeDePassosSmash() {
        MontagemSmash m = new MontagemSmash();
        m.montarLanche();
        assertEquals(4, m.getPassos().size());
    }

    @Test
    public void testPrepararPaoSmash() {
        MontagemSmash m = new MontagemSmash();
        m.montarLanche();
        assertEquals("Aquecendo pao de batata", m.getPassos().get(0));
    }

    @Test
    public void testAdicionarCarneSmash() {
        MontagemSmash m = new MontagemSmash();
        m.montarLanche();
        assertEquals("Fazendo smash de duas carnes de 90g com crosta", m.getPassos().get(1));
    }

    @Test
    public void testAdicionarAcompanhamentosSmash() {
        MontagemSmash m = new MontagemSmash();
        m.montarLanche();
        assertEquals("Adicionando american cheese e picles", m.getPassos().get(2));
    }

    @Test
    public void testFinalizacaoPadraoMantida() {
        MontagemSmash m = new MontagemSmash();
        m.montarLanche();
        assertEquals("Lanche embalado e pronto", m.getPassos().get(3));
    }

    @Test
    public void testHerancaTemplate() {
        MontagemSmash m = new MontagemSmash();
        assertTrue(m instanceof MontagemTemplate);
    }

    @Test
    public void testListaEncapsuladaVaziaInicialmente() {
        MontagemSmash m = new MontagemSmash();
        assertTrue(m.getPassos().isEmpty());
    }

    @Test
    public void testMultiplasMontagensLimpamLista() {
        MontagemSmash m = new MontagemSmash();
        m.montarLanche();
        m.montarLanche();
        assertEquals(4, m.getPassos().size());
    }

    @Test
    public void testConteudoNaoVazioNosPassos() {
        MontagemSmash m = new MontagemSmash();
        m.montarLanche();
        for (String passo : m.getPassos()) {
            assertFalse(passo.trim().isEmpty());
        }
    }

    @Test
    public void testTipagemExataDaClasse() {
        MontagemTemplate m = new MontagemSmash();
        assertEquals(MontagemSmash.class, m.getClass());
    }
}
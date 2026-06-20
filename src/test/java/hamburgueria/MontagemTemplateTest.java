package hamburgueria;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MontagemTemplateTest {

    private class MontagemMock extends MontagemTemplate {
        protected void prepararPao() { passos.add("Pao"); }
        protected void adicionarCarne() { passos.add("Carne"); }
        protected void adicionarAcompanhamentos() { passos.add("Extra"); }
    }

    @Test
    public void testEstadoInicialVazio() {
        MontagemTemplate m = new MontagemMock();
        assertTrue(m.getPassos().isEmpty());
    }

    @Test
    public void testOrdemDeExecucao() {
        MontagemTemplate m = new MontagemMock();
        m.montarLanche();
        List<String> p = m.getPassos();
        assertEquals("Pao", p.get(0));
        assertEquals("Carne", p.get(1));
        assertEquals("Extra", p.get(2));
        assertEquals("Lanche embalado e pronto", p.get(3));
    }

    @Test
    public void testQuantidadeDePassos() {
        MontagemTemplate m = new MontagemMock();
        m.montarLanche();
        assertEquals(4, m.getPassos().size());
    }

    @Test
    public void testLimpezaDePassosAoSobreporMontagem() {
        MontagemTemplate m = new MontagemMock();
        m.montarLanche();
        m.montarLanche();
        assertEquals(4, m.getPassos().size());
    }

    @Test
    public void testEncapsulamentoDaLista() {
        MontagemTemplate m = new MontagemMock();
        m.montarLanche();
        List<String> externa = m.getPassos();
        externa.clear();
        assertFalse(m.getPassos().isEmpty());
    }

    @Test
    public void testFinalizarLanchePadrao() {
        MontagemTemplate m = new MontagemTemplate() {
            protected void prepararPao() {}
            protected void adicionarCarne() {}
            protected void adicionarAcompanhamentos() {}
        };
        m.montarLanche();
        assertEquals("Lanche embalado e pronto", m.getPassos().get(0));
    }

    @Test
    public void testSobrescritaMetodoConcretoOpcional() {
        MontagemTemplate m = new MontagemMock() {
            @Override
            protected void finalizarLanche() {
                passos.add("Servido no prato");
            }
        };
        m.montarLanche();
        assertEquals("Servido no prato", m.getPassos().get(3));
    }

    @Test
    public void testNaoRetornaListaNula() {
        MontagemTemplate m = new MontagemMock();
        assertNotNull(m.getPassos());
    }

    @Test
    public void testPolimorfismoSubclasse() {
        MontagemTemplate m = new MontagemMock();
        assertTrue(m instanceof MontagemTemplate);
    }

    @Test
    public void testInstanciaNaoNula() {
        MontagemTemplate m = new MontagemMock();
        assertNotNull(m);
    }
}
package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComandoTest {

    @Test
    public void testExecucaoAnonima() {
        final boolean[] flag = {false};
        Comando c = () -> flag[0] = true;
        c.executar();
        assertTrue(flag[0]);
    }

    @Test
    public void testPolimorfismo() {
        Comando c = () -> {};
        assertTrue(c instanceof Comando);
    }

    @Test
    public void testMultiplaExecucao() {
        final int[] count = {0};
        Comando c = () -> count[0]++;
        c.executar();
        c.executar();
        assertEquals(2, count[0]);
    }

    @Test
    public void testExcecaoNaExecucao() {
        Comando c = () -> { throw new RuntimeException(); };
        assertThrows(RuntimeException.class, c::executar);
    }

    @Test
    public void testInstanciaNaoNula() {
        Comando c = new Comando() {
            public void executar() {}
        };
        assertNotNull(c);
    }

    @Test
    public void testReferenciaNula() {
        Comando c = null;
        assertNull(c);
    }

    @Test
    public void testSobrescritaVariavelExterna() {
        final String[] texto = {"Antes"};
        Comando c = () -> texto[0] = "Depois";
        c.executar();
        assertEquals("Depois", texto[0]);
    }

    @Test
    public void testSemEfeitoColateralSemChamada() {
        final int[] count = {0};
        Comando c = () -> count[0]++;
        assertEquals(0, count[0]);
    }

    @Test
    public void testEncadeamentoManual() {
        final StringBuilder sb = new StringBuilder();
        Comando c1 = () -> sb.append("A");
        Comando c2 = () -> sb.append("B");
        c1.executar();
        c2.executar();
        assertEquals("AB", sb.toString());
    }

    @Test
    public void testClasseAnonimaMetodoAcesso() {
        class ComandoLocal implements Comando {
            public boolean chamou = false;
            public void executar() { chamou = true; }
        }
        ComandoLocal cl = new ComandoLocal();
        cl.executar();
        assertTrue(cl.chamou);
    }
}
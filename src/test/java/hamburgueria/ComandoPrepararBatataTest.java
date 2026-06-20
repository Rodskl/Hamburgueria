package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComandoPrepararBatataTest {

    @Test
    public void testExecutarComSucesso() {
        Cozinha c = new Cozinha();
        Comando cmd = new ComandoPrepararBatata(c, "Rustica");
        cmd.executar();
        assertEquals("Acompanhamento: Rustica", c.getPreparados().get(0));
    }

    @Test
    public void testExecutarComCozinhaNula() {
        Comando cmd = new ComandoPrepararBatata(null, "Rustica");
        assertDoesNotThrow(cmd::executar);
    }

    @Test
    public void testExecutarComBatataNula() {
        Cozinha c = new Cozinha();
        Comando cmd = new ComandoPrepararBatata(c, null);
        cmd.executar();
        assertTrue(c.getPreparados().isEmpty());
    }

    @Test
    public void testExecutarComBatataVazia() {
        Cozinha c = new Cozinha();
        Comando cmd = new ComandoPrepararBatata(c, "   ");
        cmd.executar();
        assertTrue(c.getPreparados().isEmpty());
    }

    @Test
    public void testMultiplasExecucoes() {
        Cozinha c = new Cozinha();
        Comando cmd = new ComandoPrepararBatata(c, "Cheddar");
        cmd.executar();
        cmd.executar();
        assertEquals(2, c.getPreparados().size());
    }

    @Test
    public void testPolimorfismo() {
        Comando cmd = new ComandoPrepararBatata(new Cozinha(), "Teste");
        assertTrue(cmd instanceof Comando);
    }

    @Test
    public void testIndependenciaDeComandos() {
        Cozinha c = new Cozinha();
        Comando cmd1 = new ComandoPrepararBatata(c, "Media");
        Comando cmd2 = new ComandoPrepararBatata(c, "Grande");
        cmd1.executar();
        cmd2.executar();
        assertEquals("Acompanhamento: Media", c.getPreparados().get(0));
        assertEquals("Acompanhamento: Grande", c.getPreparados().get(1));
    }

    @Test
    public void testSemModificarCozinhasDiferentes() {
        Cozinha c1 = new Cozinha();
        Cozinha c2 = new Cozinha();
        Comando cmd = new ComandoPrepararBatata(c1, "Pequena");
        cmd.executar();
        assertTrue(c2.getPreparados().isEmpty());
    }

    @Test
    public void testCozinhaNaoAdicionaLanche() {
        Cozinha c = new Cozinha();
        Comando cmd = new ComandoPrepararBatata(c, "Frita");
        cmd.executar();
        assertFalse(c.getPreparados().get(0).startsWith("Lanche"));
    }

    @Test
    public void testInstanciaDaClasse() {
        ComandoPrepararBatata cmd = new ComandoPrepararBatata(new Cozinha(), "Frita");
        assertNotNull(cmd);
    }
}
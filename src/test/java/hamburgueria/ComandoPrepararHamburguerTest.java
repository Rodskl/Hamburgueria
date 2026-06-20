package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComandoPrepararHamburguerTest {

    @Test
    public void testExecutarComSucesso() {
        Cozinha c = new Cozinha();
        Comando cmd = new ComandoPrepararHamburguer(c, "X-Bacon");
        cmd.executar();
        assertEquals("Lanche: X-Bacon", c.getPreparados().get(0));
    }

    @Test
    public void testExecutarComCozinhaNula() {
        Comando cmd = new ComandoPrepararHamburguer(null, "X-Bacon");
        assertDoesNotThrow(cmd::executar);
    }

    @Test
    public void testExecutarComLancheNulo() {
        Cozinha c = new Cozinha();
        Comando cmd = new ComandoPrepararHamburguer(c, null);
        cmd.executar();
        assertTrue(c.getPreparados().isEmpty());
    }

    @Test
    public void testExecutarComLancheVazio() {
        Cozinha c = new Cozinha();
        Comando cmd = new ComandoPrepararHamburguer(c, "");
        cmd.executar();
        assertTrue(c.getPreparados().isEmpty());
    }

    @Test
    public void testMultiplasExecucoes() {
        Cozinha c = new Cozinha();
        Comando cmd = new ComandoPrepararHamburguer(c, "Simples");
        cmd.executar();
        cmd.executar();
        assertEquals(2, c.getPreparados().size());
    }

    @Test
    public void testPolimorfismo() {
        Comando cmd = new ComandoPrepararHamburguer(new Cozinha(), "Teste");
        assertTrue(cmd instanceof Comando);
    }

    @Test
    public void testIndependenciaDeComandos() {
        Cozinha c = new Cozinha();
        Comando cmd1 = new ComandoPrepararHamburguer(c, "A");
        Comando cmd2 = new ComandoPrepararHamburguer(c, "B");
        cmd1.executar();
        cmd2.executar();
        assertEquals("Lanche: A", c.getPreparados().get(0));
        assertEquals("Lanche: B", c.getPreparados().get(1));
    }

    @Test
    public void testSemModificarCozinhasDiferentes() {
        Cozinha c1 = new Cozinha();
        Cozinha c2 = new Cozinha();
        Comando cmd = new ComandoPrepararHamburguer(c1, "X");
        cmd.executar();
        assertTrue(c2.getPreparados().isEmpty());
    }

    @Test
    public void testCozinhaNaoAdicionaAcompanhamento() {
        Cozinha c = new Cozinha();
        Comando cmd = new ComandoPrepararHamburguer(c, "X");
        cmd.executar();
        assertFalse(c.getPreparados().get(0).startsWith("Acompanhamento"));
    }

    @Test
    public void testInstanciaDaClasse() {
        ComandoPrepararHamburguer cmd = new ComandoPrepararHamburguer(new Cozinha(), "X");
        assertNotNull(cmd);
    }
}
package hamburgueria;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class HistoricoLancheTest {

    @Test
    public void testTamanhoInicial() {
        HistoricoLanche h = new HistoricoLanche();
        assertEquals(0, h.getTamanho());
    }

    @Test
    public void testSalvarValido() {
        HistoricoLanche h = new HistoricoLanche();
        h.salvar(new EstadoLanche(new ArrayList<>()));
        assertEquals(1, h.getTamanho());
    }

    @Test
    public void testSalvarNulo() {
        HistoricoLanche h = new HistoricoLanche();
        h.salvar(null);
        assertEquals(0, h.getTamanho());
    }

    @Test
    public void testDesfazerComSucesso() {
        HistoricoLanche h = new HistoricoLanche();
        EstadoLanche e = new EstadoLanche(new ArrayList<>());
        h.salvar(e);
        assertEquals(e, h.desfazer());
        assertEquals(0, h.getTamanho());
    }

    @Test
    public void testDesfazerVazio() {
        HistoricoLanche h = new HistoricoLanche();
        assertNull(h.desfazer());
    }

    @Test
    public void testLIFOOrdem() {
        HistoricoLanche h = new HistoricoLanche();
        EstadoLanche e1 = new EstadoLanche(new ArrayList<>());
        EstadoLanche e2 = new EstadoLanche(new ArrayList<>());
        h.salvar(e1);
        h.salvar(e2);
        assertEquals(e2, h.desfazer());
        assertEquals(e1, h.desfazer());
    }

    @Test
    public void testLimparHistorico() {
        HistoricoLanche h = new HistoricoLanche();
        h.salvar(new EstadoLanche(new ArrayList<>()));
        h.salvar(new EstadoLanche(new ArrayList<>()));
        h.limparHistorico();
        assertEquals(0, h.getTamanho());
    }

    @Test
    public void testTamanhoAposMultiplosSalvamentos() {
        HistoricoLanche h = new HistoricoLanche();
        h.salvar(new EstadoLanche(new ArrayList<>()));
        h.salvar(new EstadoLanche(new ArrayList<>()));
        assertEquals(2, h.getTamanho());
    }

    @Test
    public void testInstanciaNaoNula() {
        assertNotNull(new HistoricoLanche());
    }

    @Test
    public void testDesfazerNaoLancaExcecaoQuandoVazio() {
        HistoricoLanche h = new HistoricoLanche();
        assertDoesNotThrow(h::desfazer);
    }
}
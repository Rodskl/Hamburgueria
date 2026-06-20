package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CriadorViagemTest {

    @Test
    public void testCriarEmbalagemRetornaViagem() {
        CriadorViagem c = new CriadorViagem();
        assertTrue(c.criarEmbalagem() instanceof EmbalagemViagem);
    }

    @Test
    public void testCriarEmbalagemNaoNulo() {
        CriadorViagem c = new CriadorViagem();
        assertNotNull(c.criarEmbalagem());
    }

    @Test
    public void testEmpacotarPedidoFormatacao() {
        CriadorViagem c = new CriadorViagem();
        assertEquals("Pedido empacotado em: Sacola de papel selada para viagem", c.empacotarPedido());
    }

    @Test
    public void testPolimorfismoCriador() {
        CriadorViagem c = new CriadorViagem();
        assertTrue(c instanceof CriadorEmbalagem);
    }

    @Test
    public void testInstanciasDiferentesCriadas() {
        CriadorViagem c = new CriadorViagem();
        Embalagem e1 = c.criarEmbalagem();
        Embalagem e2 = c.criarEmbalagem();
        assertNotSame(e1, e2);
    }

    @Test
    public void testTipoExatoDaClasse() {
        CriadorEmbalagem c = new CriadorViagem();
        assertEquals(CriadorViagem.class, c.getClass());
    }

    @Test
    public void testInstanciaDoCriador() {
        assertNotNull(new CriadorViagem());
    }

    @Test
    public void testNaoGeraEmbalagemBalcao() {
        CriadorViagem c = new CriadorViagem();
        assertFalse(c.criarEmbalagem() instanceof EmbalagemBalcao);
    }

    @Test
    public void testMultiplasCriacoes() {
        CriadorViagem c = new CriadorViagem();
        assertNotNull(c.criarEmbalagem());
        assertNotNull(c.criarEmbalagem());
    }

    @Test
    public void testEmpacotamentoRetornaStringValida() {
        CriadorViagem c = new CriadorViagem();
        assertFalse(c.empacotarPedido().isEmpty());
    }
}
package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CriadorBalcaoTest {

    @Test
    public void testCriarEmbalagemRetornaBalcao() {
        CriadorBalcao c = new CriadorBalcao();
        assertTrue(c.criarEmbalagem() instanceof EmbalagemBalcao);
    }

    @Test
    public void testCriarEmbalagemNaoNulo() {
        CriadorBalcao c = new CriadorBalcao();
        assertNotNull(c.criarEmbalagem());
    }

    @Test
    public void testEmpacotarPedidoFormatacao() {
        CriadorBalcao c = new CriadorBalcao();
        assertEquals("Pedido empacotado em: Bandeja para consumo no local", c.empacotarPedido());
    }

    @Test
    public void testPolimorfismoCriador() {
        CriadorBalcao c = new CriadorBalcao();
        assertTrue(c instanceof CriadorEmbalagem);
    }

    @Test
    public void testInstanciasDiferentesCriadas() {
        CriadorBalcao c = new CriadorBalcao();
        Embalagem e1 = c.criarEmbalagem();
        Embalagem e2 = c.criarEmbalagem();
        assertNotSame(e1, e2);
    }

    @Test
    public void testTipoExatoDaClasse() {
        CriadorEmbalagem c = new CriadorBalcao();
        assertEquals(CriadorBalcao.class, c.getClass());
    }

    @Test
    public void testInstanciaDoCriador() {
        assertNotNull(new CriadorBalcao());
    }

    @Test
    public void testNaoGeraEmbalagemViagem() {
        CriadorBalcao c = new CriadorBalcao();
        assertFalse(c.criarEmbalagem() instanceof EmbalagemViagem);
    }

    @Test
    public void testMultiplasCriacoes() {
        CriadorBalcao c = new CriadorBalcao();
        assertNotNull(c.criarEmbalagem());
        assertNotNull(c.criarEmbalagem());
    }

    @Test
    public void testEmpacotamentoRetornaStringValida() {
        CriadorBalcao c = new CriadorBalcao();
        assertFalse(c.empacotarPedido().isEmpty());
    }
}
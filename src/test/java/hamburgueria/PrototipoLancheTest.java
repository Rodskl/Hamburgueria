package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrototipoLancheTest {

    private class MockPrototipo implements PrototipoLanche {
        private String d;
        public PrototipoLanche clonar() { return new MockPrototipo(); }
        public String getDescricao() { return d; }
        public void setDescricao(String desc) { this.d = desc; }
    }

    @Test
    public void testContratoClonarRetornaNaoNulo() {
        PrototipoLanche p = new MockPrototipo();
        assertNotNull(p.clonar());
    }

    @Test
    public void testContratoClonarInstanciasDiferentes() {
        PrototipoLanche p1 = new MockPrototipo();
        PrototipoLanche p2 = p1.clonar();
        assertNotSame(p1, p2);
    }

    @Test
    public void testSetGetDescricao() {
        PrototipoLanche p = new MockPrototipo();
        p.setDescricao("Teste");
        assertEquals("Teste", p.getDescricao());
    }

    @Test
    public void testDescricaoNula() {
        PrototipoLanche p = new MockPrototipo();
        p.setDescricao(null);
        assertNull(p.getDescricao());
    }

    @Test
    public void testDescricaoVazia() {
        PrototipoLanche p = new MockPrototipo();
        p.setDescricao("");
        assertEquals("", p.getDescricao());
    }

    @Test
    public void testPolimorfismoClone() {
        PrototipoLanche p = new MockPrototipo();
        assertTrue(p.clonar() instanceof PrototipoLanche);
    }

    @Test
    public void testSubstituicaoDescricao() {
        PrototipoLanche p = new MockPrototipo();
        p.setDescricao("A");
        p.setDescricao("B");
        assertEquals("B", p.getDescricao());
    }

    @Test
    public void testClonagemMultipla() {
        PrototipoLanche p = new MockPrototipo();
        PrototipoLanche c1 = p.clonar();
        PrototipoLanche c2 = p.clonar();
        assertNotSame(c1, c2);
    }

    @Test
    public void testPolimorfismoBase() {
        PrototipoLanche p = new MockPrototipo();
        assertTrue(p instanceof PrototipoLanche);
    }

    @Test
    public void testExcecaoNoClonar() {
        PrototipoLanche p = new PrototipoLanche() {
            public PrototipoLanche clonar() { throw new RuntimeException(); }
            public String getDescricao() { return ""; }
            public void setDescricao(String d) {}
        };
        assertThrows(RuntimeException.class, p::clonar);
    }
}
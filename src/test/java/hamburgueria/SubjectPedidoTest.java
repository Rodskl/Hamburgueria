package hamburgueria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SubjectPedidoTest {

    @Test
    public void testAdicionarObserver() {
        SubjectPedido s = new SubjectPedido() {
            public void adicionarObserver(ObserverPedido o) { assertNotNull(o); }
            public void removerObserver(ObserverPedido o) {}
            public void notificarObservers(String m) {}
        };
        s.adicionarObserver(msg -> {});
    }

    @Test
    public void testRemoverObserver() {
        SubjectPedido s = new SubjectPedido() {
            public void adicionarObserver(ObserverPedido o) {}
            public void removerObserver(ObserverPedido o) { assertNotNull(o); }
            public void notificarObservers(String m) {}
        };
        s.removerObserver(msg -> {});
    }

    @Test
    public void testNotificarObservers() {
        SubjectPedido s = new SubjectPedido() {
            public void adicionarObserver(ObserverPedido o) {}
            public void removerObserver(ObserverPedido o) {}
            public void notificarObservers(String m) { assertEquals("Alerta", m); }
        };
        s.notificarObservers("Alerta");
    }

    @Test
    public void testAdicionarNull() {
        SubjectPedido s = new SubjectPedido() {
            public void adicionarObserver(ObserverPedido o) { assertNull(o); }
            public void removerObserver(ObserverPedido o) {}
            public void notificarObservers(String m) {}
        };
        s.adicionarObserver(null);
    }

    @Test
    public void testRemoverNull() {
        SubjectPedido s = new SubjectPedido() {
            public void adicionarObserver(ObserverPedido o) {}
            public void removerObserver(ObserverPedido o) { assertNull(o); }
            public void notificarObservers(String m) {}
        };
        s.removerObserver(null);
    }

    @Test
    public void testNotificarNull() {
        SubjectPedido s = new SubjectPedido() {
            public void adicionarObserver(ObserverPedido o) {}
            public void removerObserver(ObserverPedido o) {}
            public void notificarObservers(String m) { assertNull(m); }
        };
        s.notificarObservers(null);
    }

    @Test
    public void testNotificarVazio() {
        SubjectPedido s = new SubjectPedido() {
            public void adicionarObserver(ObserverPedido o) {}
            public void removerObserver(ObserverPedido o) {}
            public void notificarObservers(String m) { assertEquals("", m); }
        };
        s.notificarObservers("");
    }

    @Test
    public void testPolimorfismo() {
        SubjectPedido s = new SubjectPedido() {
            public void adicionarObserver(ObserverPedido o) {}
            public void removerObserver(ObserverPedido o) {}
            public void notificarObservers(String m) {}
        };
        assertTrue(s instanceof SubjectPedido);
    }

    @Test
    public void testMultiplasChamadas() {
        final int[] contagem = {0};
        SubjectPedido s = new SubjectPedido() {
            public void adicionarObserver(ObserverPedido o) {}
            public void removerObserver(ObserverPedido o) {}
            public void notificarObservers(String m) { contagem[0]++; }
        };
        s.notificarObservers("A");
        s.notificarObservers("B");
        assertEquals(2, contagem[0]);
    }

    @Test
    public void testExcecaoNaImplementacao() {
        SubjectPedido s = new SubjectPedido() {
            public void adicionarObserver(ObserverPedido o) { throw new RuntimeException(); }
            public void removerObserver(ObserverPedido o) {}
            public void notificarObservers(String m) {}
        };
        assertThrows(RuntimeException.class, () -> s.adicionarObserver(msg -> {}));
    }
}
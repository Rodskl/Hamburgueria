package hamburgueria;

public class Chapa {
    private static Chapa instancia;
    private boolean ligada;
    private int lanchesPreparados;

    private Chapa() {
        this.ligada = false;
        this.lanchesPreparados = 0;
    }

    public static synchronized Chapa getInstancia() {
        if (instancia == null) {
            instancia = new Chapa();
        }
        return instancia;
    }

    public void ligar() {
        this.ligada = true;
    }

    public void desligar() {
        this.ligada = false;
    }

    public boolean isLigada() {
        return this.ligada;
    }

    public void prepararLanche() {
        if (this.ligada) {
            this.lanchesPreparados++;
        }
    }

    public int getLanchesPreparados() {
        return this.lanchesPreparados;
    }

    public void resetEstatisticas() {
        this.lanchesPreparados = 0;
    }
}
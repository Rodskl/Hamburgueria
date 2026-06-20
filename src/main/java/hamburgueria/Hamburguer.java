package hamburgueria;

public class Hamburguer {
    private String pao;
    private String carne;
    private boolean queijo;
    private boolean bacon;
    private boolean alface;
    private boolean tomate;

    private Hamburguer(Builder builder) {
        this.pao = builder.pao;
        this.carne = builder.carne;
        this.queijo = builder.queijo;
        this.bacon = builder.bacon;
        this.alface = builder.alface;
        this.tomate = builder.tomate;
    }

    public String getPao() { return pao; }
    public String getCarne() { return carne; }
    public boolean hasQueijo() { return queijo; }
    public boolean hasBacon() { return bacon; }
    public boolean hasAlface() { return alface; }
    public boolean hasTomate() { return tomate; }

    public static class Builder {
        private String pao;
        private String carne;
        private boolean queijo;
        private boolean bacon;
        private boolean alface;
        private boolean tomate;

        public Builder pao(String pao) { this.pao = pao; return this; }
        public Builder carne(String carne) { this.carne = carne; return this; }
        public Builder queijo() { this.queijo = true; return this; }
        public Builder bacon() { this.bacon = true; return this; }
        public Builder alface() { this.alface = true; return this; }
        public Builder tomate() { this.tomate = true; return this; }
        public Hamburguer build() { return new Hamburguer(this); }
    }
}
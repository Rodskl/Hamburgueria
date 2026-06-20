package hamburgueria;

import java.util.ArrayList;
import java.util.List;

public class ComboVisitable implements ElementoVisitable {
    private String nome;
    private List<ElementoVisitable> itens;

    public ComboVisitable(String nome) {
        this.nome = nome;
        this.itens = new ArrayList<>();
    }

    public void adicionar(ElementoVisitable item) {
        if (item != null) {
            this.itens.add(item);
        }
    }

    public String getNome() {
        return nome;
    }

    public List<ElementoVisitable> getItens() {
        return new ArrayList<>(itens);
    }

    @Override
    public String aceitar(VisitorExportacao visitor) {
        if (visitor != null) {
            return visitor.visitarCombo(this);
        }
        return "";
    }
}
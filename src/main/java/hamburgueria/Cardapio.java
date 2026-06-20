package hamburgueria;

import java.util.ArrayList;
import java.util.List;

public class Cardapio implements MenuAgregado {
    private List<ItemCardapio> itens;

    public Cardapio() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemCardapio item) {
        if (item != null) {
            itens.add(item);
        }
    }

    public void limparMenu() {
        itens.clear();
    }

    @Override
    public IteradorCardapio criarIterador() {
        return new IteradorItens(new ArrayList<>(itens));
    }
}
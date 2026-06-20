package hamburgueria;

import java.util.List;
import java.util.NoSuchElementException;

public class IteradorItens implements IteradorCardapio {
    private List<ItemCardapio> itens;
    private int posicao;

    public IteradorItens(List<ItemCardapio> itens) {
        this.itens = itens;
        this.posicao = 0;
    }

    @Override
    public boolean hasNext() {
        if (itens == null) {
            return false;
        }
        return posicao < itens.size();
    }

    @Override
    public ItemCardapio next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Nao ha mais itens no iterador");
        }
        ItemCardapio item = itens.get(posicao);
        posicao++;
        return item;
    }
}
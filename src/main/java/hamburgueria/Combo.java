package hamburgueria;

import java.util.ArrayList;
import java.util.List;

public class Combo implements ItemCardapio {
    private String nome;
    private double descontoDecimal;
    private List<ItemCardapio> itens;

    public Combo(String nome, double descontoDecimal) {
        this.nome = nome;
        this.descontoDecimal = descontoDecimal;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemCardapio item) {
        if (item != null) {
            itens.add(item);
        }
    }

    public void removerItem(ItemCardapio item) {
        itens.remove(item);
    }

    public int getQuantidadeItens() {
        return itens.size();
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        double totalBruto = 0;
        for (ItemCardapio item : itens) {
            totalBruto += item.getPreco();
        }
        return totalBruto * (1.0 - descontoDecimal);
    }
}
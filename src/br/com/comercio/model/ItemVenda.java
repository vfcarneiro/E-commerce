package br.com.comercio.model;

public class ItemVenda {
    private Produto produto;
    private int quantidadeVendida;
    private double precoUnitario;
    private double precoTotalItem;

    public ItemVenda(Produto produto, int quantidadeVendida) {
        this.produto = produto;
        this.quantidadeVendida = quantidadeVendida;
        this.precoUnitario = produto.getPrecoVenda();
        this.precoTotalItem = this.precoUnitario * this.quantidadeVendida;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public double getPrecoTotalItem() {
        return precoTotalItem;
    }
}
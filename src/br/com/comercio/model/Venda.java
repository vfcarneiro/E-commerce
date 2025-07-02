package br.com.comercio.model;

import java.util.ArrayList;
import java.util.List;

public class Venda {
    private int codigoVenda;
    private Vendedor vendedor;
    private List<ItemVenda> itensDaVenda;
    private double valorTotalVenda;

    public Venda(int codigoVenda, Vendedor vendedor) {
        this.codigoVenda = codigoVenda;
        this.vendedor = vendedor;
        this.itensDaVenda = new ArrayList<>();
        this.valorTotalVenda = 0.0;
    }

    public void adicionarItem(ItemVenda item) {
        this.itensDaVenda.add(item);
        this.valorTotalVenda += item.getPrecoTotalItem();
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public List<ItemVenda> getItensDaVenda() {
        return itensDaVenda;
    }

    public double getValorTotalVenda() {
        return valorTotalVenda;
    }
}
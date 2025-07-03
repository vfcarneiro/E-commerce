package br.com.comercio.model;

public class Produto {
    private int codigo;
    private String nome;
    private int quantidadeEstoque;
    private double precoVenda;

    public Produto(int codigo, String nome, int quantidadeEstoque, double precoVenda) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
        this.precoVenda = precoVenda;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    @Override
    public String toString() {
        return "Informações do produto: codigo=" + codigo + ", nome=" + nome + ", estoque=" + quantidadeEstoque + ", preco=R$" + precoVenda ;
    }
}

package br.com.comercio.service;

import br.com.comercio.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gestao {
    private List<Produto> listaDeProdutos = new ArrayList<>();
    private List<Vendedor> listaDeVendedores = new ArrayList<>();
    private List<Venda> listaDeVendas = new ArrayList<>();

    private int proximoCodigoProduto = 1;
    private int proximoNumeroVendedor = 1;
    private int proximoCodigoVenda = 1;

    public void cadastrarProduto(String nome, int qtd, double preco) {
        for (Produto p : listaDeProdutos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                System.out.println("ERRO: Produto já cadastrado!");
                return;
            }
        }
        Produto novoProduto = new Produto(proximoCodigoProduto, nome, qtd, preco);
        listaDeProdutos.add(novoProduto);
        proximoCodigoProduto++;
        System.out.println("Produto cadastrado com sucesso! Código: " + novoProduto.getCodigo());
    }

    public void cadastrarVendedor(String nome, double salario) {
        Vendedor novoVendedor = new Vendedor(proximoNumeroVendedor, nome, salario);
        listaDeVendedores.add(novoVendedor);
        proximoNumeroVendedor++;
        System.out.println("Vendedor cadastrado com sucesso! Número: " + novoVendedor.getNumero());
    }

    public Vendedor buscarVendedorPorNumero(int numero) {
        for (Vendedor v : listaDeVendedores) {
            if (v.getNumero() == numero) {
                return v;
            }
        }
        return null;
    }

    public Produto buscarProdutoPorCodigo(int codigo) {
        for (Produto p : listaDeProdutos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    public void listarProdutos() {
        if (listaDeProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        for (Produto p : listaDeProdutos) {
            System.out.println(p.toString());
        }
    }

    public void listarVendedores() {
        if (listaDeVendedores.isEmpty()) {
            System.out.println("Nenhum vendedor cadastrado.");
            return;
        }
        for (Vendedor v : listaDeVendedores) {
            System.out.println(v.toString());
        }
    }

    public void realizarVenda(int numeroVendedor, Scanner scanner) {
        Vendedor vendedor = buscarVendedorPorNumero(numeroVendedor);
        if (vendedor == null) {
            System.out.println("ERRO: Vendedor não encontrado!");
            return;
        }

        Venda novaVenda = new Venda(proximoCodigoVenda, vendedor);

        while (true) {
            System.out.print("Digite o código do produto (ou digite 0 para finalizar): ");
            int codProd = scanner.nextInt();
            if (codProd == 0) break;

            Produto produto = buscarProdutoPorCodigo(codProd);
            if (produto == null) {
                System.out.println("Erro: Produto não encontrado!");
                continue;
            }

            System.out.print("Digite a quantidade: ");
            int qtdVendida = scanner.nextInt();

            if (qtdVendida <= 0 || qtdVendida > produto.getQuantidadeEstoque()) {
                System.out.println("Erro: Quantidade ou estoque insuficiente! Em estoque: " + produto.getQuantidadeEstoque());
                continue;
            }

            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - qtdVendida);

            ItemVenda item = new ItemVenda(produto, qtdVendida);
            novaVenda.adicionarItem(item);
            System.out.println("Produto adicionado!");
        }

        if (novaVenda.getItensDaVenda().size() > 0) {
            listaDeVendas.add(novaVenda);
            proximoCodigoVenda++;


            double comissao = vendedor.getSalarioFixo() * 0.03;
            vendedor.adicionarComissao(comissao);

            System.out.println("\n--- Venda #" + novaVenda.getCodigoVenda() + " finalizada com sucesso! ---");
            System.out.println("Valor Total: R$ " + String.format("%.2f", novaVenda.getValorTotalVenda()));
            System.out.println("Comissão para o vendedor " + vendedor.getNome() + ": R$ " + String.format("%.2f", comissao));
            System.out.println("Salário total do vendedor: R$ " + String.format("%.2f", vendedor.getSalarioTotal()));

        } else {
            System.out.println("Nenhum item na venda.");
        }
    }
}
import br.com.comercio.service.Gestao;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gestao gestor = new Gestao();
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- SISTEMA DE VENDAS ---");
            System.out.println("1. Cadastrar um produto");
            System.out.println("2. Cadastrar um vendedor");
            System.out.println("3. Listar produtos");
            System.out.println("4. Listar vendedores");
            System.out.println("5. Realizar venda");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nomeProd = scanner.nextLine();
                    System.out.print("Quantidade em estoque: ");
                    int qtdProd = scanner.nextInt();
                    System.out.print("Preço de venda: ");
                    double precoProd = scanner.nextDouble();
                    gestor.cadastrarProduto(nomeProd, qtdProd, precoProd);
                    break;
                case 2:
                    System.out.print("Nome do vendedor: ");
                    String nomeVend = scanner.nextLine();
                    System.out.print("Salário fixo: ");
                    double salarioVend = scanner.nextDouble();
                    gestor.cadastrarVendedor(nomeVend, salarioVend);
                    break;
                case 3:
                    gestor.listarProdutos();
                    break;
                case 4:
                    gestor.listarVendedores();
                    break;
                case 5:
                    System.out.print("Digite o número do vendedor: ");
                    int numVend = scanner.nextInt();
                    gestor.realizarVenda(numVend, scanner);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        scanner.close();
    }
}
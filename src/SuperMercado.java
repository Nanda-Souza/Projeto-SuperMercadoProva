import java.util.Scanner;

public class SuperMercado {
    public static void main(String[] args) {
        //Variaveis de Controle
        Scanner scanner = new Scanner(System.in);
        String inputUsuario;
        Estoque estoque = new Estoque();
        int idProduto = estoque.getTamanhoEstoque() + 1;
        String nomeProduto;
        double precoProduto;
        int quantidadeProduto;



        do{

            System.out.println("\n==== Supermercado DB ====");
            System.out.println("1 - Conferir Catálogo do Estoque");
            System.out.println("2 - Cadastrar Produto");
            System.out.println("3 - Realizar Pedido");
            System.out.println("0 - Sair");

            inputUsuario = scanner.nextLine().trim();

            switch (inputUsuario){

                case "1":
                    System.out.println("Catalogo de produtos:");
                    estoque.imprimeCatalogoDoEstoque();
                    break;

                case "2":
                    System.out.println("\nInsira o nome to produto: ");
                    nomeProduto = scanner.nextLine().trim();

                    System.out.println("\nInsira o preço do produto: ");
                    precoProduto = scanner.nextDouble();

                    System.out.println("\nInsira a quantidade em estoque: ");
                    quantidadeProduto = scanner.nextInt();

                    Produto p = new Produto(idProduto++, nomeProduto, precoProduto, quantidadeProduto);

                    if (estoque.cadastrarProduto(p)){
                        System.out.println("Produto cadastrado com sucesso!");
                    } else {
                        System.out.println("Cadastro não realizado pois o produto já existe!");
                    }
                    break;

                case "3":
                    System.out.println("Pedido Realizado!");
                    break;

                case "0":
                    System.out.println("Fechando o programa");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (!inputUsuario.equals("0"));

    }
}

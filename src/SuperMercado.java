import java.util.Scanner;

public class SuperMercado {
    public static void main(String[] args) {
        //Variaveis de Controle
        Scanner scanner = new Scanner(System.in);
        String inputUsuario;
        Estoque estoque = new Estoque();


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
                    System.out.println("Produto Cadastrado!");
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

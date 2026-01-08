import java.util.Scanner;


public class SuperMercado {
    public static boolean inputValido(String input) {
        return input != null &&
                input.matches("^[12]$");
    }

    public static boolean nomeDeProdutoValido(String nomeProduto) {
        return nomeProduto != null &&
                nomeProduto.matches("^(?=.*[A-Za-zÀ-ÿ])[A-Za-zÀ-ÿ0-9 .,\\\\-]+$") &&
                nomeProduto.length() > 1;
    }

    public static boolean precoValido(String preco){
        return preco != null &&
                preco.matches("^\\d+,\\d{2}$");
    }

    public static boolean quantidadeValida(String quantidade) {
        return quantidade != null &&
                quantidade.matches("\\d+");
    }

    public static void main(String[] args) {
        //Variaveis de Controle
        Scanner scanner = new Scanner(System.in);
        String inputUsuario;
        Estoque estoque = new Estoque();
        Pedido pedido = new Pedido();
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

                    System.out.println("\n Deseja retornar ao menu?");
                    System.out.println("1 - Sim");
                    System.out.println("2 - Não");

                    inputUsuario = scanner.nextLine().trim();

                    while (!inputValido(inputUsuario)){
                        System.out.println("\nOpção inválida, digite 1 para sim e 2 para não:");
                        inputUsuario = scanner.nextLine().trim();
                    }

                    if (inputUsuario.equals("2")){
                        System.out.println("Fechando o programa!");
                        inputUsuario = "0";
                    }
                    break;

                case "2":

                    do {
                        System.out.println("\nInsira o nome to produto: ");
                        nomeProduto = scanner.nextLine().trim();

                        while(!nomeDeProdutoValido(nomeProduto)){
                            System.out.println("Nome do produto inválido, digite um nome de produto com no mínimo 2 caracteres e ao menos uma letra:");
                            nomeProduto = scanner.nextLine().trim();
                        }

                        System.out.println("\nInsira o preço do produto: ");
                        inputUsuario = scanner.nextLine().trim();

                        while(!precoValido(inputUsuario)){
                            System.out.println("Preço inválido. Digite apenas números, usando vírgula para separar os centavos (ex: 100,20):");
                            inputUsuario = scanner.nextLine().trim();
                        }

                        precoProduto = Double.parseDouble(inputUsuario.replace(",", "."));

                        System.out.println("\nInsira a quantidade em estoque: ");
                        inputUsuario = scanner.nextLine().trim();

                        while(!quantidadeValida(inputUsuario)){
                            System.out.println("Quantidade inválida. Digite apenas um numero inteiro:");
                            inputUsuario = scanner.nextLine().trim();

                        }

                        quantidadeProduto = Integer.parseInt(inputUsuario);

                        Produto p = new Produto(idProduto++, nomeProduto, precoProduto, quantidadeProduto);

                        if (estoque.cadastrarProduto(p)){
                            System.out.println("Produto cadastrado com sucesso. Deseja cadastrar um novo produto?");
                            System.out.println("1 - Sim");
                            System.out.println("2 - Não");

                            inputUsuario = scanner.nextLine().trim();

                            while (!inputValido(inputUsuario)){
                                System.out.println("\nOpção inválida, digite 1 para sim e 2 para não:");
                                inputUsuario = scanner.nextLine().trim();
                            }

                        } else {
                            System.out.println("Produto já cadastrado! Deseja cadastrar um novo produto?");
                            System.out.println("1 - Sim");
                            System.out.println("2 - Não");

                            inputUsuario = scanner.nextLine().trim();

                            while (!inputValido(inputUsuario)){
                                System.out.println("\nOpção inválida, digite 1 para sim e 2 para não:");
                                inputUsuario = scanner.nextLine().trim();
                            }

                        }

                    } while (inputUsuario.equals("1"));

                    break;

                case "3":
                    System.out.println("Pedido Realizado!");

                    Produto produtoArroz = estoque.encontraProduto(1);
                    //Produto produtoFeijao = estoque.encontraProduto(2);

                    System.out.println(estoque.temEstoqueOuNao(produtoArroz, 9));
                    System.out.println(estoque.temEstoqueOuNao(produtoArroz, 10));
                    System.out.println(estoque.temEstoqueOuNao(produtoArroz, 11));

                    break;

                case "0":
                    System.out.println("Fechando o programa!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (!inputUsuario.equals("0"));

    }
}

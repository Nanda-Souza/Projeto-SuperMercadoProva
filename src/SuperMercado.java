import java.util.ArrayList;
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

                    boolean pedidoConcluido = false;
                    boolean voltarAoMenu = false;


                    do {

                        System.out.println("Digite o nome do produto: ");
                        nomeProduto = scanner.nextLine().trim();

                        while (!nomeDeProdutoValido(nomeProduto)){
                            System.out.println("Nome do produto inválido, digite um nome de produto com no mínimo 2 caracteres e ao menos uma letra:");
                            nomeProduto = scanner.nextLine().trim();
                        }

                        Produto produtoPedido = estoque.encontraProduto(nomeProduto);

                        if (produtoPedido != null){
                            System.out.println("\nInsira a quantidade em desejada: ");
                            inputUsuario = scanner.nextLine().trim();

                            while(!quantidadeValida(inputUsuario)){
                                System.out.println("Quantidade inválida. Digite apenas um numero inteiro:");
                                inputUsuario = scanner.nextLine().trim();

                            }

                            quantidadeProduto = Integer.parseInt(inputUsuario);

                            if (estoque.temEstoqueOuNao(produtoPedido, quantidadeProduto)){

                                if (pedido.adicionaItemNaLista(produtoPedido, quantidadeProduto)){
                                    System.out.println("Produto adicionado ao pedido com sucesso, deseja concluir o pedido ou adicionar mais produtos? ");
                                    System.out.println("1 - Adicionar outro produto");
                                    System.out.println("2 - Concluir pedido");

                                    inputUsuario = scanner.nextLine().trim();

                                    while (!inputValido(inputUsuario)){
                                        System.out.println("\nOpção inválida, digite 1 para adicionar outro produto ou 2 para concluir o pedido:");
                                        inputUsuario = scanner.nextLine().trim();
                                    }

                                    if (inputUsuario.equals("2")){
                                        pedidoConcluido = true;
                                    }

                                }else {
                                    System.out.println("Este produto já foi adicionado ao pedido, deseja concluir o pedido ou adicionar mais produtos? ");
                                    System.out.println("1 - Adicionar outro produto");
                                    System.out.println("2 - Concluir pedido");

                                    inputUsuario = scanner.nextLine().trim();

                                    while (!inputValido(inputUsuario)){
                                        System.out.println("\nOpção inválida, digite 1 para adicionar outro produto ou 2 para concluir o pedido:");
                                        inputUsuario = scanner.nextLine().trim();
                                    }

                                    if (inputUsuario.equals("2")){
                                        pedidoConcluido = true;
                                    }

                                }



                            } else {
                                System.out.println("Produto indisponivel em estoque, deseja tentar outro produto ou voltar ao menu?");
                                System.out.println("1 - Tentar outro produto");
                                System.out.println("2 - Voltar ao menu principal");

                                inputUsuario = scanner.nextLine().trim();

                                while (!inputValido(inputUsuario)){
                                    System.out.println("\nOpção inválida, digite 1 para tentar outro produto ou 2 para voltar ao menu:");
                                    inputUsuario = scanner.nextLine().trim();
                                }
                                if (inputUsuario.equals("2")){
                                    pedido.limparCarrinho();
                                    voltarAoMenu = true;
                                }
                            }


                        } else {
                            System.out.println("Produto não encontrado, deseja tentar outro produto ou voltar ao menu? ");
                            System.out.println("1 - Tentar outro produto");
                            System.out.println("2 - Voltar ao menu principal");

                            inputUsuario = scanner.nextLine().trim();

                            while (!inputValido(inputUsuario)){
                                System.out.println("\nOpção inválida, digite 1 para tentar outro produto ou 2 para voltar ao menu:");
                                inputUsuario = scanner.nextLine().trim();
                            }
                            if (inputUsuario.equals("2")){
                                pedido.limparCarrinho();
                                voltarAoMenu = true;
                            }

                        }

                    } while (!pedidoConcluido && !voltarAoMenu);


                    if (pedidoConcluido){
                        double valorPago = 0;
                        double valorTotal = pedido.getValorTotalDoPedido();
                        boolean pagamentoRealizado = false;
                        ArrayList<Item> listaDeItems = pedido.getListaDeItems();

                        System.out.println("\n==== Imprimindo Pedido ====: ");
                        pedido.imprimePedido();
                        pedido.imprimeValorTotal();

                        do{
                            System.out.println("\nInsira o valor para pagamento: ");
                            inputUsuario = scanner.nextLine().trim();

                            while(!precoValido(inputUsuario)){
                                System.out.println("Preço inválido. Digite apenas números, usando vírgula para separar os centavos (ex: 100,20):");
                                inputUsuario = scanner.nextLine().trim();
                            }

                            valorPago = Double.parseDouble(inputUsuario.replace(",", "."));

                            if (valorPago < valorTotal){
                                System.out.println("Pagamento não realizado, valor pago inferior ao valor total do pedido.");

                            } else {
                                pagamentoRealizado = true;
                            }

                        } while (!pagamentoRealizado);

                        System.out.println("\n==== Pagamento Realizado! ====");
                        System.out.println("\n==== Dando Baixa em Estoque! ====");

                        for (Item i : listaDeItems ){
                            String nomeDoItem = i.getProduto().getNome();
                            int quantidadeDoItem = i.getQuantidade();

                            estoque.darBaixaEmEstoque(nomeDoItem, quantidadeDoItem);
                        }

                        System.out.println("\n==== Estoque Atualizado! ====");



                    }

                    pedido.limparCarrinho();

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

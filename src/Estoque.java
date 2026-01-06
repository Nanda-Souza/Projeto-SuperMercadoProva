import java.util.ArrayList;

public class Estoque {
    private ArrayList<Produto> listaDeProdutos;


    public Estoque(){

        this.listaDeProdutos = new ArrayList<>();
        inicializaEstoque();
    }

    public void inicializaEstoque(){
        listaDeProdutos.add(new Produto(1, "Arroz", 4.80, 10));
        listaDeProdutos.add(new Produto(2, "Feijão", 6.50, 10));
        listaDeProdutos.add(new Produto(3, "Café Melita", 22.30, 5));
        listaDeProdutos.add(new Produto(4, "Café Premiun", 35.00, 2));
        listaDeProdutos.add(new Produto(5, "Coca Cola", 10.99, 20));
        listaDeProdutos.add(new Produto(6, "Chocolate Preto", 6.00, 13));
        listaDeProdutos.add(new Produto(7, "Chocolate Branco", 4.99, 17));
        listaDeProdutos.add(new Produto(8, "Presunto", 3.30, 10));
        listaDeProdutos.add(new Produto(9, "Queijo", 7.00, 10));
        listaDeProdutos.add(new Produto(10, "Pão de Sanduiche", 9.00, 5));
    }

    public void imprimeCatalogoDoEstoque(){
        for (Produto p : listaDeProdutos){
            System.out.println(p);
        }
    }
    public int getTamanhoEstoque(){
        return listaDeProdutos.size();
    }

    public Produto encontraProduto(String nome){
        for (Produto p : listaDeProdutos){
            if (p.getNome().equalsIgnoreCase(nome)){
                return p;
            }
        }
        return null;
    }

    public Produto encontraProduto(int id){
        for (Produto p : listaDeProdutos){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public boolean cadastrarProduto(Produto produto){

        boolean produtoEncontrado = false;

        for (Produto p : listaDeProdutos){
            if (p.getNome().equalsIgnoreCase(produto.getNome())){
                produtoEncontrado = true;
            }
        }

        if(!produtoEncontrado){
            listaDeProdutos.add(new Produto(produto.getId(), produto.getNome(), produto.getPreco(), produto.getQuantidadeEmEstoque()));
            return true;
        }

        return false;

    }





}

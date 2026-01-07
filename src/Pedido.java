import java.util.ArrayList;

public class Pedido {
    private ArrayList<Item> listaDeItems;
    private double valorTotalDoPedido = 0;


    public Pedido(){

        this.listaDeItems = new ArrayList<>();
    }

    public void calculaValorTotal(){
        double soma = 0;

        for (Item i : listaDeItems){
            soma += i.getValorDoItem();

        }
        this.valorTotalDoPedido = soma;
    }

    public boolean adicionaItemNaLista(Produto produto, int quantidade){

        boolean itemEncontrado = false;

        if(listaDeItems.size() > 0 && listaDeItems != null){

            for (Item i : listaDeItems){
                if(i.getProduto().getNome().equalsIgnoreCase(produto.getNome())){
                    itemEncontrado = true;
                    break;
                }
            }

        }

        if(!itemEncontrado){
            listaDeItems.add(new Item(produto, quantidade));
            calculaValorTotal();
            return true;
        }

        return false;

    }

    public void imprimePedido(){
        for (Item i : this.listaDeItems){
            System.out.println(i);
        }
    }

    public void imprimeValorTotal(){
        System.out.println("Valor total do pedido R$: " + valorTotalDoPedido);
        }

    public void limparCarrinho(){
        this.listaDeItems.clear();
        this.valorTotalDoPedido = 0;
    }

    public ArrayList<Item> getListaDeItems() {return listaDeItems;}

    public double getValorTotalDoPedido() {return valorTotalDoPedido;}

    public void setListaDeItems(ArrayList<Item> listaDeItems) {
        this.listaDeItems = listaDeItems;
    }

    public void setValorTotalDoPedido(double valorTotalDoPedido) {
        this.valorTotalDoPedido = valorTotalDoPedido;
    }
}

import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.RoundingMode;


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

        if(!listaDeItems.isEmpty()){

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

    public double calculaTroco(double valorPago, Pedido pedido){
        double valorTotalDoPedido = pedido.getValorTotalDoPedido();
        double troco = valorTotalDoPedido - valorPago;
        //Multiplica por 100 arredondando pra cima e dividi por 100 para evitar troco com mais de 2 casas decimais.
        double trocoPreciso = Math.ceil(troco * 100) / 100;



        return trocoPreciso;

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

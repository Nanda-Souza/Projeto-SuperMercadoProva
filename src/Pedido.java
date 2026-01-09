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
        double troco = valorPago - valorTotalDoPedido;
        //Multiplica por 100 arredondando pra cima e dividi por 100 para evitar troco com mais de 2 casas decimais.
        double trocoPreciso = Math.ceil(troco * 100) / 100;

        return trocoPreciso;

    }

    public void menorQuantidadeDeNotas(double troco){
        int notaDeCem = 0;
        int notaDeCinquenta = 0;
        int notaDeVinte = 0;
        int notaDeDez = 0;
        int notaDeCinco = 0;
        int notaDeDois = 0;

        do{
            if (troco >= 100){
                notaDeCem++;
                troco -= 100;

            } else if (troco >= 50) {
                notaDeCinquenta++;
                troco -= 50;

            } else if (troco >= 20) {
                notaDeVinte++;
                troco -= 20;

            } else if (troco >= 10) {
                notaDeDez++;
                troco -= 10;

            } else if (troco >= 5) {
                notaDeCinco++;
                troco -= 5;

            } else if (troco >= 2) {
                notaDeDois++;
                troco -= 2;

            }

        }while (troco >= 2);

        if (notaDeCem > 0){
            System.out.println(notaDeCem + " nota(s) de R$ 100");
        }

        if (notaDeCinquenta > 0){
            System.out.println(notaDeCinquenta + " nota(s) de R$ 50");
        }

        if (notaDeVinte > 0){
            System.out.println(notaDeVinte + " nota(s) de R$ 20");
        }

        if (notaDeDez > 0){
            System.out.println(notaDeDez + " nota(s) de R$ 10");
        }

        if (notaDeCinco > 0){
            System.out.println(notaDeCinco + " nota(s) de R$ 5");
        }

        if (notaDeDois > 0){
            System.out.println(notaDeDois + " nota(s) de R$ 2");
        }

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

public class Item {
    private Produto produto;
    private Integer quantidade;
    private Double valorDoItem;

    public Item(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
        defineValorTotal();
    }

    public void defineValorTotal() {
        this.valorDoItem = quantidade * produto.getPreco();
    }

    public Produto getProduto(){ return produto;}

    public int getQuantidade(){ return quantidade;}

    public Double getValorDoItem() { return valorDoItem; }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return  "Nome do Item: " + produto.getNome() + "\n" +
                "Quantidade: " + quantidade + "\n" +
                "Valor do Item: " + valorDoItem + "\n" +
                "-----------------------------------------";
    }

}

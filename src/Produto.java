public class Produto {
    private Integer id;
    private String nome;
    private Double preco;
    private Integer quantidadeEmEstoque;

    public Produto(int id, String nome, double preco, int quantidadeEmEstoque){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public double getPreco(){
        return preco;
    }

    public int getQuantidadeEmEstoque(){
        return quantidadeEmEstoque;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setQuantidadeEmEstoque(Integer quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    @Override
    public String toString() {
        return  "Id: " + id + "\n" +
                "Nome: " + nome + "\n" +
                "Preço: " + preco + "\n" +
                "Quantidade em Estoque: " + quantidadeEmEstoque + "\n" +
                "-----------------------------------------";
    }

}

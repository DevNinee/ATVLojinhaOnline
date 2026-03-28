package model;

public class Produto {
    private int idProduto;
    private String nome;
    private double preco;
    private int estoque;

    public Produto(int idProduto, String nome, double preco, int estoque) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public int getIdProduto() { return idProduto; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getEstoque() { return estoque; }

    public void reduzirEstoque(int quantidade) {
        this.estoque -= quantidade;
    }
}
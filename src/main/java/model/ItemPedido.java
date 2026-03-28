package model;

public class ItemPedido {
    private int idItemPedido;
    private int quantidade;
    private Produto produto;

    public ItemPedido(int idItemPedido, int quantidade, Produto produto) {
        this.idItemPedido = idItemPedido;
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public int getIdItemPedido() { return idItemPedido; }
    public int getQuantidade() { return quantidade; }
    public Produto getProduto() { return produto; }

    public double getSubtotal() {
        return produto.getPreco() * quantidade;
    }
}
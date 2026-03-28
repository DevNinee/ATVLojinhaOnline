package service;

import model.Produto;
import repository.MockDatabase;
import java.util.List;

public class ProdutoService {

    public List<Produto> listarProdutos() {
        return MockDatabase.produtos;
    }

    public Produto buscarPorId(int id) {
        return MockDatabase.buscarProduto(id);
    }

    public void reduzirEstoque(int id, int quantidade) {
        Produto p = buscarPorId(id);

        if (p != null) {
            if (p.getEstoque() >= quantidade) {
                p.reduzirEstoque(quantidade);
                System.out.println("Estoque atualizado!");
            } else {
                System.out.println("Estoque insuficiente!");
            }
        } else {
            System.out.println("Produto não encontrado!");
        }
    }
}
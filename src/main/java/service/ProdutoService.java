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

    public boolean reduzirEstoque(int id, int quantidade) {
        Produto produto = MockDatabase.buscarProduto(id);
        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return false;
        }
        if (produto.getEstoque() < quantidade) {
            System.out.println("Estoque insuficiente para: " + produto.getNome());
            return false;
        }
        produto.reduzirEstoque(quantidade);
        System.out.println("Estoque atualizado. Novo estoque de '" + produto.getNome() + "': " + produto.getEstoque());
        return true;
    }
}

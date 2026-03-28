package controller;

import model.Produto;
import service.ProdutoService;
import java.util.List;

public class ProdutoController {

    private ProdutoService service = new ProdutoService();

    public List<Produto> listar() {
        return service.listarProdutos();
    }

    public Produto buscar(int id) {
        return service.buscarPorId(id);
    }

    public boolean reduzirEstoque(int id, int quantidade) {
        return service.reduzirEstoque(id, quantidade);
    }

}
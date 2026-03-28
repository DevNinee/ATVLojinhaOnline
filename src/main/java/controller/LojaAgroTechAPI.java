package controller;

import model.*;

public class LojaAgroTechAPI {

    public static void main(String[] args) {

        ClienteController clienteController = new ClienteController();
        ProdutoController produtoController = new ProdutoController();
        PedidoController pedidoController = new PedidoController();
        PagamentoController pagamentoController = new PagamentoController();
        
        // identificação do cliente
        Cliente cliente = clienteController.buscar(1);

        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        System.out.println("Cliente identificado: " + cliente.getNome());
        
        // lista de produtos
        System.out.println("\nProdutos disponíveis:");

        for (Produto p : produtoController.listar()) {
            System.out.println(
                    p.getIdProduto() + " - " +
                            p.getNome() + " | R$ " +
                            p.getPreco() + " | Estoque: " +
                            p.getEstoque()
            );
        }

        //seleção de produtos
        
        int idProdutoEscolhido = 101;
        Produto produto = produtoController.buscar(idProdutoEscolhido);

        if (produto == null) {
            System.out.println("Produto não encontrado!");
            return;
        }

        if (produto.getEstoque() <= 0) {
            System.out.println("Produto sem estoque!");
            return;
        }

        System.out.println("\nProduto selecionado: " + produto.getNome());

        
        // criar pedido
        
        Pedido pedido = pedidoController.criarPedido(cliente.getIdCliente());

        System.out.println("Pedido criado com ID: " + pedido.getIdPedido());

        // processar o pagamento
        
        Pagamento pagamento = pagamentoController.criarPagamento(
                pedido.getIdPedido(),
                produto.getPreco()
        );

        pagamentoController.processarPagamento(pagamento);

        
        // finalização da compra
        
        if ("PAGO".equals(pagamento.getStatus())) {

            produtoController.reduzirEstoque(produto.getIdProduto(), 1);
            pedidoController.confirmar(pedido);

            System.out.println("\nCompra finalizada com sucesso!");

        } else {

            pedidoController.cancelar(pedido);

            System.out.println("\nCompra não realizada.");
        }
    }
}

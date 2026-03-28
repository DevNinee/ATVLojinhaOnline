package controller;

import model.Cliente;
import model.ItemPedido;
import model.Pagamento;
import model.Pedido;
import model.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * LojaAgroTechAPI — Ponto de entrada da simulação do sistema de lojinha online.
 *
 * Arquitetura: cliente-servidor monolítica.
 * Todas as funcionalidades do backend estão concentradas nesta aplicação servidora.
 * A comunicação com o sistema externo de pagamento é feita via Singleton (PaymentGateway).
 */
public class LojaAgroTechAPI {

    public static void main(String[] args) {
        System.out.println("=== LOJA AGROTECH — SIMULAÇÃO DO SISTEMA ===\n");

        ClienteController clienteController     = new ClienteController();
        ProdutoController produtoController     = new ProdutoController();
        PedidoController  pedidoController      = new PedidoController();
        PagamentoController pagamentoController = new PagamentoController();

        // ─────────────────────────────────────────────
        // 1. IDENTIFICAÇÃO DO CLIENTE
        // ─────────────────────────────────────────────
        System.out.println("--- PASSO 1: IDENTIFICAÇÃO DO CLIENTE ---");
        int clienteId = 1;
        Cliente cliente = clienteController.buscar(clienteId);

        if (cliente == null) {
            System.out.println("Cliente não encontrado. Encerrando.");
            return;
        }
        System.out.println("Cliente identificado: " + cliente.getNome() + " <" + cliente.getEmail() + ">\n");

        // ─────────────────────────────────────────────
        // 2. LISTAGEM DE PRODUTOS
        // ─────────────────────────────────────────────
        System.out.println("--- PASSO 2: LISTAGEM DE PRODUTOS ---");
        List<Produto> catalogo = produtoController.listar();
        for (Produto p : catalogo) {
            System.out.printf("  [%d] %-30s R$ %,.2f  |  Estoque: %d%n",
                    p.getIdProduto(), p.getNome(), p.getPreco(), p.getEstoque());
        }
        System.out.println();

        // ─────────────────────────────────────────────
        // 3. SELEÇÃO DE PRODUTO COM ESTOQUE INDISPONÍVEL
        // ─────────────────────────────────────────────
        System.out.println("--- PASSO 3: TENTATIVA DE COMPRA — PRODUTO SEM ESTOQUE (Drone de Pulverização) ---");
        boolean droneDisponivel = produtoController.reduzirEstoque(102, 1);
        if (!droneDisponivel) {
            System.out.println("Produto sem estoque. Cliente deve selecionar outro produto.\n");
        }

        // ─────────────────────────────────────────────
        // 4. CRIAÇÃO DO PEDIDO COM PRODUTO DISPONÍVEL
        // ─────────────────────────────────────────────
        System.out.println("--- PASSO 4: CRIAÇÃO DO PEDIDO — Sensor de Umidade IoT ---");
        Pedido pedido = pedidoController.criarPedido(clienteId);

        List<ItemPedido> itens = new ArrayList<>();
        Produto sensor = produtoController.buscar(101);
        int quantidade = 2;

        boolean reservado = produtoController.reduzirEstoque(sensor.getIdProduto(), quantidade);
        if (!reservado) {
            System.out.println("Estoque insuficiente para o sensor. Encerrando pedido.");
            pedidoController.cancelar(pedido);
            return;
        }

        ItemPedido item = new ItemPedido(1, quantidade, sensor);
        itens.add(item);

        double total = itens.stream().mapToDouble(ItemPedido::getSubtotal).sum();
        System.out.printf("  Item: %s x%d — Subtotal: R$ %,.2f%n", sensor.getNome(), quantidade, total);
        System.out.printf("  Total do pedido: R$ %,.2f%n%n", total);

        // ─────────────────────────────────────────────
        // 5. PROCESSAMENTO DE PAGAMENTO (via Singleton)
        // ─────────────────────────────────────────────
        System.out.println("--- PASSO 5: PROCESSAMENTO DE PAGAMENTO ---");
        Pagamento pagamento = pagamentoController.criarPagamento(pedido.getIdPedido(), total);
        pagamentoController.processarPagamento(pagamento);

        // ─────────────────────────────────────────────
        // 6. CONFIRMAÇÃO OU FALHA
        // ─────────────────────────────────────────────
        System.out.println("\n--- PASSO 6: RESULTADO FINAL ---");
        if ("PAGO".equals(pagamento.getStatus())) {
            pedidoController.confirmar(pedido);
            pagamentoController.finalizarPagamento(pagamento);
            System.out.println("✓ Pedido #" + pedido.getIdPedido() + " finalizado com sucesso!");
        } else {
            pedidoController.cancelar(pedido);
            System.out.println("✗ Pedido #" + pedido.getIdPedido() + " cancelado por falha no pagamento.");
        }

        System.out.println("\n=== FIM DA SIMULAÇÃO ===");
    }
}

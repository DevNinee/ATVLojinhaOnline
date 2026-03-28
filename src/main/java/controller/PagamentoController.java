package controller;

import model.Pagamento;
import service.PagamentoService;

public class PagamentoController {

    private PagamentoService service = new PagamentoService();

    public Pagamento criarPagamento(int pedidoId, double valor) {
        return service.gerarBoleto(pedidoId, valor);
    }

    public void processarPagamento(Pagamento pagamento) {
        service.processarPagamento(pagamento);
    }

    public void finalizarPagamento(Pagamento pagamento) {
        service.confirmarPedido(pagamento);
    }
}
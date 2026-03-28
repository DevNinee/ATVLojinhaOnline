package controller;

import model.Pagamento;
import service.PagamentoService;

public class PagamentoController {

    private PagamentoService service = PagamentoService.getInstance();

    public Pagamento criarPagamento(int pedidoId, double valor) {
        return service.gerarBoleto(pedidoId, valor);
    }

    public void processarPagamento(Pagamento pagamento, boolean pago) {
        service.verificarPagamento(pagamento, pago);
    }

    public void finalizarPagamento(Pagamento pagamento) {
        service.confirmarPedido(pagamento);
    }
}

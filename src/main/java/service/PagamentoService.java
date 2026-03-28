package service;

import model.Pagamento;

public class PagamentoService {

    private static PagamentoService instancia;

    private PagamentoService() {}

    public static PagamentoService getInstance() {
        if (instancia == null) {
            instancia = new PagamentoService();
        }
        return instancia;
    }

    public Pagamento gerarBoleto(int pedidoId, double valor) {
        Pagamento pagamento = new Pagamento();
        pagamento.setPedidoId(pedidoId);
        pagamento.setValor(valor);
        pagamento.setStatus("PENDENTE");

        System.out.println("Boleto gerado para o pedido " + pedidoId);

        return pagamento;
    }

    public void verificarPagamento(Pagamento pagamento, boolean pago) {
        if (pago) {
            pagamento.setStatus("PAGO");
            System.out.println("Pagamento aprovado");
        } else {
            pagamento.setStatus("ERRO");
            System.out.println("Pagamento recusado");
        }
    }

    public void confirmarPedido(Pagamento pagamento) {
        if ("PAGO".equals(pagamento.getStatus())) {
            System.out.println("Pedido confirmado e recibo gerado");
        } else {
            System.out.println("Pedido não confirmado");
        }
    }
}

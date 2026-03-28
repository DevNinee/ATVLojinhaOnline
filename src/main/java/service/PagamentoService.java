package service;

import model.Pagamento;

public class PagamentoService {

    private PaymentGateway gateway = PaymentGateway.getInstance();

    public Pagamento gerarBoleto(int pedidoId, double valor) {
        Pagamento pagamento = new Pagamento();
        pagamento.setPedidoId(pedidoId);
        pagamento.setValor(valor);
        pagamento.setStatus("PENDENTE");

        System.out.println("Boleto gerado para o pedido " + pedidoId);

        return pagamento;
    }

    public void processarPagamento(Pagamento pagamento) {
        boolean pago = gateway.processarPagamento(pagamento.getValor());

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
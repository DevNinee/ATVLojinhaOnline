package service;

public class PaymentGateway {

    private static PaymentGateway instancia;

    private PaymentGateway() {}

    public static PaymentGateway getInstance() {
        if (instancia == null) {
            instancia = new PaymentGateway();
        }
        return instancia;
    }

    public boolean processarPagamento(double valor) {
        System.out.println("Conectando com sistema externo...");
        return Math.random() > 0.3;
    }
}
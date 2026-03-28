package service;

/**
 * PaymentGateway — Classe responsável pela comunicação com o sistema externo de
 * pagamento.
 *
 * PADRAO SINGLETON aplicado aqui.
 *
 * Motivo: a conexao com um gateway de pagamento externo e um recurso unico e
 * sensivel.
 * Nao faz sentido criar varios objetos para isso — seria como abrir varias
 * linhas
 * telefonicas para o mesmo banco ao mesmo tempo. Com o Singleton, garantimos
 * que
 * toda a aplicacao usa sempre a mesma instancia para processar pagamentos,
 * evitando conflitos, multiplas conexoes abertas e inconsistencia de dados.
 */
public class PaymentGateway {

    // Guarda a unica instancia da classe. Inicio com null e tem a instancia criada
    // uma vez.
    private static PaymentGateway instancia;

    // Construtor privado: impede que outros trechos do codigo criem novas
    // instancias
    // com "new PaymentGateway()". A unica forma de obter o objeto e pelo
    // getInstance().
    private PaymentGateway() {
    }

    /**
     * Ponto de acesso global ao Singleton.
     * Se ainda nao existe uma instancia, cria. Se ja existe, retorna a mesma.
     * Dessa forma, nao importa quantas vezes seja chamado — sempre e o mesmo
     * objeto.
     */
    public static PaymentGateway getInstance() {
        if (instancia == null) {
            instancia = new PaymentGateway(); // cria apenas na primeira chamada
        }
        return instancia; // nas proximas chamadas, retorna o objeto ja existente
    }

    /**
     * Simula o envio de uma requisicao ao sistema externo de pagamento.
     * Retorna true se aprovado, false se recusado.
     * Na simulacao, 70% das tentativas sao aprovadas.
     */
    public boolean processarPagamento(double valor) {
        System.out.println("Conectando com sistema externo...");
        return Math.random() > 0.3;
    }
}
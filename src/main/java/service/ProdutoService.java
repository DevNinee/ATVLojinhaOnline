package service;

import model.Pedido;
import java.time.LocalDateTime;

public class PedidoService {

    public Pedido criarPedido(int clienteId) {
        Pedido pedido = new Pedido();
        pedido.setIdPedido((int) (Math.random() * 1000));
        pedido.setClienteId(clienteId);
        pedido.setData(LocalDateTime.now());
        pedido.setStatus("CRIADO");

        System.out.println("Pedido criado para o cliente " + clienteId);

        return pedido;
    }

    public void atualizarStatus(Pedido pedido, String status) {
        pedido.setStatus(status);
        System.out.println("Status do pedido atualizado para: " + status);
    }

    public void confirmarPedido(Pedido pedido) {
        pedido.setStatus("CONFIRMADO");
        System.out.println("Pedido confirmado!");
    }

    public void cancelarPedido(Pedido pedido) {
        pedido.setStatus("CANCELADO");
        System.out.println("Pedido cancelado!");
    }
}

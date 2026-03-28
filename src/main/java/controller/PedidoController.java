package controller;

import model.Pedido;
import service.PedidoService;

public class PedidoController {

    private PedidoService service = PedidoService.getInstance();

    public Pedido criarPedido(int clienteId) {
        return service.criarPedido(clienteId);
    }

    public void atualizarStatus(Pedido pedido, String status) {
        service.atualizarStatus(pedido, status);
    }

    public void confirmar(Pedido pedido) {
        service.confirmarPedido(pedido);
    }

    public void cancelar(Pedido pedido) {
        service.cancelarPedido(pedido);
    }
}
package model;

import java.time.LocalDateTime;

public class Pedido {

    private int idPedido;
    private LocalDateTime data;
    private String status;
    private int clienteId;

    public Pedido() {
    }

    public Pedido(int idPedido, LocalDateTime data, String status, int clienteId) {
        this.idPedido = idPedido;
        this.data = data;
        this.status = status;
        this.clienteId = clienteId;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
}
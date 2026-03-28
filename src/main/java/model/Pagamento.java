package model;

public class Pagamento {

    private int idPagamento;
    private String status;
    private double valor;
    private int pedidoId;

    public Pagamento() {
    }

    public Pagamento(int idPagamento, String status, double valor, int pedidoId) {
        this.idPagamento = idPagamento;
        this.status = status;
        this.valor = valor;
        this.pedidoId = pedidoId;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }
}
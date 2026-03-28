package controller;

import model.Cliente;
import service.ClienteService;
import java.util.List;

public class ClienteController {

    private ClienteService service = new ClienteService();

    public List<Cliente> listar() {
        return service.listarClientes();
    }

    public Cliente buscar(int id) {
        return service.buscarPorId(id);
    }
}
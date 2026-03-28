package service;

import model.Cliente;
import repository.MockDatabase;
import java.util.List;

public class ClienteService {

    public List<Cliente> listarClientes() {
        return MockDatabase.clientes;
    }

    public Cliente buscarPorId(int id) {
        for (Cliente c : MockDatabase.clientes) {
            if (c.getIdCliente() == id) {
                return c;
            }
        }
        return null;
    }
}
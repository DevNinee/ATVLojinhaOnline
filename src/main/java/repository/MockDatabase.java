package repository;

import model.Cliente;
import model.Produto;
import java.util.ArrayList;
import java.util.List;

public class MockDatabase {
    public static List<Cliente> clientes = new ArrayList<>();
    public static List<Produto> produtos = new ArrayList<>();

    static {
        // Clientes cadastrados estaticamente conforme requisito da atividade
        clientes.add(new Cliente(1, "Fazenda da Serra", "contato@fazendaserra.com"));
        clientes.add(new Cliente(2, "Agro Tech Ltda", "compras@agrotech.com.br"));
        clientes.add(new Cliente(3, "João da Silva", "joao.silva@email.com"));

        // Produto 101 tem estoque, o 102 não tem — permite testar o fluxo de estoque indisponível
        produtos.add(new Produto(101, "Sensor de Umidade IoT", 450.00, 9));
        produtos.add(new Produto(102, "Drone de Pulverização", 15000.00, 0));
        produtos.add(new Produto(103, "Kit Irrigação Inteligente", 2300.00, 5));
    }

    public static Produto buscarProduto(int id) {
        return produtos.stream().filter(p -> p.getIdProduto() == id).findFirst().orElse(null);
    }
}
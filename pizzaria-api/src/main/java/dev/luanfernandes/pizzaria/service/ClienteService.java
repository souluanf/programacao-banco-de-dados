package dev.luanfernandes.pizzaria.service;

import dev.luanfernandes.pizzaria.domain.entity.Cliente;
import dev.luanfernandes.pizzaria.domain.entity.Pedido;
import java.util.List;

public interface ClienteService {
    void adicionarPedido(Long clienteId, Pedido pedido);

    List<Pedido> getPedidos(Long clienteId);

    Cliente buscarClientePorId(Long clienteId);

    Cliente atualizarCliente(Long clienteId, Cliente clienteAtualizado);

    Void deletarCliente(Long clienteId);

    Cliente criarCliente(Cliente cliente);
}

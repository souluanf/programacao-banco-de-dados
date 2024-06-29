package dev.luanfernandes.pizzaria.service.impl;

import dev.luanfernandes.pizzaria.domain.entity.Cliente;
import dev.luanfernandes.pizzaria.domain.entity.Pedido;
import dev.luanfernandes.pizzaria.repository.ClienteRepository;
import dev.luanfernandes.pizzaria.repository.PedidoRepository;
import dev.luanfernandes.pizzaria.service.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final PedidoRepository pedidoRepository;

    @Override
    public void adicionarPedido(Long clienteId, Pedido pedido) {
        Cliente cliente = clienteRepository
                .findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        pedido.setCliente(cliente);
        cliente.getPedidos().add(pedido);
        pedidoRepository.save(pedido);
        clienteRepository.save(cliente);
    }

    @Override
    public List<Pedido> getPedidos(Long clienteId) {
        Cliente cliente = clienteRepository
                .findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        return cliente.getPedidos();
    }

    @Override
    public Cliente buscarClientePorId(Long clienteId) {
        return clienteRepository
                .findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
    }

    @Override
    public Cliente atualizarCliente(Long clienteId, Cliente clienteAtualizado) {
        Cliente cliente = clienteRepository
                .findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        cliente.setNome(clienteAtualizado.getNome());
        cliente.setEndereco(clienteAtualizado.getEndereco());
        cliente.setTelefone(clienteAtualizado.getTelefone());
        return clienteRepository.save(cliente);
    }

    @Override
    public Void deletarCliente(Long clienteId) {
        Cliente cliente = clienteRepository
                .findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        clienteRepository.delete(cliente);
        return null;
    }

    @Override
    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}

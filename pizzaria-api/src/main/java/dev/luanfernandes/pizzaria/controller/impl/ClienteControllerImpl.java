package dev.luanfernandes.pizzaria.controller.impl;

import dev.luanfernandes.pizzaria.controller.ClienteController;
import dev.luanfernandes.pizzaria.domain.entity.Cliente;
import dev.luanfernandes.pizzaria.domain.request.ClienteRequest;
import dev.luanfernandes.pizzaria.domain.response.ClienteResponse;
import dev.luanfernandes.pizzaria.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClienteControllerImpl implements ClienteController {

    private final ClienteService clienteService;

    @Override
    public ResponseEntity<ClienteResponse> criarCliente(ClienteRequest clienteRequest) {
        ClienteResponse cliente = clienteService.criarCliente(clienteRequest);
        return ResponseEntity.ok(cliente);
    }

    @Override
    public ResponseEntity<Cliente> buscarClientePorId(Long clienteId) {
        return ResponseEntity.ok(clienteService.buscarClientePorId(clienteId));
    }

    @Override
    public ResponseEntity<List<ClienteResponse>> buscarTodosClientes() {
        return ResponseEntity.ok(clienteService.buscarTodosClientes());
    }

    @Override
    public ResponseEntity<Cliente> atualizarCliente(Long clienteId, Cliente clienteAtualizado) {
        return ResponseEntity.ok(clienteService.atualizarCliente(clienteId, clienteAtualizado));
    }

    @Override
    public ResponseEntity<Void> deletarCliente(Long clienteId) {
        clienteService.deletarCliente(clienteId);
        return ResponseEntity.noContent().build();
    }
}

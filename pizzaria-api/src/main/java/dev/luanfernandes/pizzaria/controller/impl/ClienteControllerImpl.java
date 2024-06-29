package dev.luanfernandes.pizzaria.controller.impl;

import dev.luanfernandes.pizzaria.controller.ClienteController;
import dev.luanfernandes.pizzaria.domain.entity.Cliente;
import dev.luanfernandes.pizzaria.domain.mapper.ClienteMapper;
import dev.luanfernandes.pizzaria.domain.request.ClienteRequest;
import dev.luanfernandes.pizzaria.domain.response.ClienteResponse;
import dev.luanfernandes.pizzaria.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class ClienteControllerImpl implements ClienteController {

    private final ClienteService clienteService;
    private final ClienteMapper clienteMapper;

    @Override
    public ResponseEntity<ClienteResponse> criarCliente(ClienteRequest clienteRequest) {
        Cliente cliente = clienteService.criarCliente(clienteMapper.map(clienteRequest));
        return ok(clienteMapper.map(cliente));
    }

    @Override
    public ResponseEntity<Cliente> buscarClientePorId(Long clienteId) {
        return ok(clienteService.buscarClientePorId(clienteId));
    }

    @Override
    public ResponseEntity<Cliente> atualizarCliente(Long clienteId, Cliente clienteAtualizado) {
        return ok(clienteService.atualizarCliente(clienteId, clienteAtualizado));
    }

    @Override
    public ResponseEntity<Void> deletarCliente(Long clienteId) {
        clienteService.deletarCliente(clienteId);
        return ResponseEntity.noContent().build();
    }
}

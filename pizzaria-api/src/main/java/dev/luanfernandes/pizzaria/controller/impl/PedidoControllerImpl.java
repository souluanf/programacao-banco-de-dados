package dev.luanfernandes.pizzaria.controller.impl;

import static org.springframework.http.ResponseEntity.ok;

import dev.luanfernandes.pizzaria.controller.PedidoController;
import dev.luanfernandes.pizzaria.domain.entity.Pedido;
import dev.luanfernandes.pizzaria.service.PedidoService;
import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PedidoControllerImpl implements PedidoController {

    private final PedidoService pedidoService;

    @Override
    public ResponseEntity<List<Pedido>> getPedidos(Long clienteId) {
        return ok(pedidoService.getPedidos(clienteId));
    }

    @Override
    public ResponseEntity<Void> adicionarPedido(Long clienteId, Pedido pedido) {
        return ok(pedidoService.adicionarPedido(clienteId, pedido));
    }

    @Override
    public ResponseEntity<BigDecimal> calcularTotal(Long pedidoId) {
        BigDecimal total = pedidoService.calcularTotal(pedidoId);
        return ok(total);
    }

    @Override
    public ResponseEntity<String> verificarStatusEntrega(Long pedidoId) {
        String status = pedidoService.verificarStatusEntrega(pedidoId);
        return ok(status);
    }
}

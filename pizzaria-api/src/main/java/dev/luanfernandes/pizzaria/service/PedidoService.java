package dev.luanfernandes.pizzaria.service;

import dev.luanfernandes.pizzaria.domain.entity.Pedido;
import java.math.BigDecimal;
import java.util.List;

public interface PedidoService {
    BigDecimal calcularTotal(Long pedidoId);

    String verificarStatusEntrega(Long pedidoId);

    Void adicionarPedido(Long clienteId, Pedido pedido);

    List<Pedido> getPedidos(Long clienteId);
}

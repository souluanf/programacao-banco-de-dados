package dev.luanfernandes.pizzaria.service;

public interface EntregaService {
    void confirmarRecebimento(Long entregaId, String codigoDeEntrega);

    boolean verificarPagamento(Long entregaId);
}

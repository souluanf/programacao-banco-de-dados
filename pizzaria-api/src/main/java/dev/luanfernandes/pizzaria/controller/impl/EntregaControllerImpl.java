package dev.luanfernandes.pizzaria.controller.impl;

import dev.luanfernandes.pizzaria.controller.EntregaController;
import dev.luanfernandes.pizzaria.service.EntregaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EntregaControllerImpl implements EntregaController {

    private final EntregaService entregaService;

    @Override
    public ResponseEntity<Void> confirmarRecebimento(Long entregaId, String codigoDeEntrega) {
        entregaService.confirmarRecebimento(entregaId, codigoDeEntrega);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Boolean> verificarPagamento(Long entregaId) {
        boolean pagamentoConfirmado = entregaService.verificarPagamento(entregaId);
        return ResponseEntity.ok(pagamentoConfirmado);
    }
}

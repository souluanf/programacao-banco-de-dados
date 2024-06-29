package dev.luanfernandes.pizzaria.service.impl;

import dev.luanfernandes.pizzaria.domain.entity.Entrega;
import dev.luanfernandes.pizzaria.repository.EntregaRepository;
import dev.luanfernandes.pizzaria.service.EntregaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntregaServiceImpl implements EntregaService {

    private final EntregaRepository entregaRepository;

    @Override
    public void confirmarRecebimento(Long entregaId, String codigoDeEntrega) {
        Entrega entrega = entregaRepository
                .findById(entregaId)
                .orElseThrow(() -> new EntityNotFoundException("Entrega não encontrada"));
        if (!entrega.getCodigoDeEntrega().equals(codigoDeEntrega)) {
            throw new RuntimeException("Código de entrega inválido");
        }
        entrega.setStatusRecebido(true);
        entregaRepository.save(entrega);
    }

    @Override
    public boolean verificarPagamento(Long entregaId) {
        Entrega entrega = entregaRepository
                .findById(entregaId)
                .orElseThrow(() -> new EntityNotFoundException("Entrega não encontrada"));
        return entrega.isPagamentoConfirmado();
    }
}

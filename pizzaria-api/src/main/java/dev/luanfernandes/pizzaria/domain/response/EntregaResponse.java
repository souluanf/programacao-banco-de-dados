package dev.luanfernandes.pizzaria.domain.response;

import java.time.LocalDate;
import java.time.LocalTime;

public record EntregaResponse(
        LocalDate dataEntrega,
        LocalTime horaEntrega,
        String tipoPagamento,
        String codigoDeEntrega,
        String enderecoEntrega,
        boolean statusRecebido,
        boolean pagamentoConfirmado
) {}

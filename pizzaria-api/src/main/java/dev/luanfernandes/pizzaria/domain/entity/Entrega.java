package dev.luanfernandes.pizzaria.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataEntrega;
    private LocalTime horaEntrega;
    private String tipoPagamento;
    private String codigoDeEntrega;
    private String enderecoEntrega;
    private boolean statusRecebido;
    private boolean pagamentoConfirmado;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
}

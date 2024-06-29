package dev.luanfernandes.pizzaria.repository;

import dev.luanfernandes.pizzaria.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {}

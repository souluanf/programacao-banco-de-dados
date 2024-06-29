package dev.luanfernandes.pizzaria.repository;

import dev.luanfernandes.pizzaria.domain.entity.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {}

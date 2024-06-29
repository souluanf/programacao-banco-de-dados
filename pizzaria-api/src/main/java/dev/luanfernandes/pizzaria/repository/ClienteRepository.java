package dev.luanfernandes.pizzaria.repository;

import dev.luanfernandes.pizzaria.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {}

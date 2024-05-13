package dev.luanfernandes.gestao.repository;

import dev.luanfernandes.gestao.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByNome(String nome);
    Aluno findByEmail(String email);
    Aluno findByCpf(String cpf);
}
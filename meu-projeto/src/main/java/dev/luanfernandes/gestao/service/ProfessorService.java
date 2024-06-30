package dev.luanfernandes.gestao.service;

import dev.luanfernandes.gestao.entity.Professor;

import java.util.List;

public interface ProfessorService {
    void adicionarProfessor(Professor professor);
    void removerProfessor(Long id);
    void atualizarProfessor(Professor professor);
    List<Professor> listarProfessores();
}

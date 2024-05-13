package dev.luanfernandes.gestao.service;

import dev.luanfernandes.gestao.entity.Turma;

import java.util.List;

public interface TurmaService {
    void criarTurma(Turma turma);
    void removerTurma(Long id);
    void atualizarTurma(Turma turma);
    List<Turma> listarTurmasPorCurso(Long cursoId);
}
package dev.luanfernandes.gestao.service;

import dev.luanfernandes.gestao.entity.Curso;

import java.util.List;

public interface CursoService {
    void criarCurso(Curso curso);
    void removerCurso(Long id);
    void atualizarCurso(Curso curso);
    List<Curso> listarCursos();
}

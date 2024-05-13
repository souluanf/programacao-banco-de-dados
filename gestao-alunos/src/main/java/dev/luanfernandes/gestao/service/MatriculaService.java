package dev.luanfernandes.gestao.service;

import dev.luanfernandes.gestao.entity.Aluno;
import dev.luanfernandes.gestao.entity.Curso;
import dev.luanfernandes.gestao.entity.Matricula;

import java.util.List;
import java.util.UUID;

public interface MatriculaService {
    UUID matricularAluno(Aluno aluno, Curso curso);
    void cancelarMatricula(Long id);
    List<Matricula> listarMatriculasPorCurso(Long cursoId);
    List<Matricula> listarMatriculasPorAluno(Long alunoId);
}

package dev.luanfernandes.gestao.service;

import dev.luanfernandes.gestao.entity.Aluno;

import java.util.List;

public interface AlunoService {
    void adicionarAluno(Aluno aluno);
    void removerAluno(Long id);
    void atualizarAluno(Aluno aluno);
    List<Aluno> buscarAlunoPorNome(String nome);
    Aluno buscarAlunoPorId(Long id);
    Aluno buscarAlunoPorCpf(String cpf);
    Aluno buscarAlunoPorEmail(String email);
    List<Aluno> listarAlunos();
}

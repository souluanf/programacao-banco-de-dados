package dev.luanfernandes.gestao.service.impl;

import dev.luanfernandes.gestao.entity.Aluno;
import dev.luanfernandes.gestao.repository.AlunoRepository;
import dev.luanfernandes.gestao.repository.CursoRepository;
import dev.luanfernandes.gestao.repository.MatriculaRepository;
import dev.luanfernandes.gestao.repository.TurmaRepository;
import dev.luanfernandes.gestao.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Component
@RequiredArgsConstructor
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;
    private final MatriculaRepository matriculaRepository;
    private final TurmaRepository turmaRepository;



    @Override
    public void adicionarAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    @Override
    public void removerAluno(Long id) {
        alunoRepository.deleteById(id);
    }

    @Override
    public void atualizarAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    @Override
    public List<Aluno> buscarAlunoPorNome(String nome) {
        return alunoRepository.findByNome(nome);
    }

    @Override
    public Aluno buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id).orElse(null);
    }

    @Override
    public Aluno buscarAlunoPorCpf(String cpf) {
        return alunoRepository.findByCpf(cpf);
    }

    @Override
    public Aluno buscarAlunoPorEmail(String email) {
        return alunoRepository.findByEmail(email);
    }

    @Override
    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }
}

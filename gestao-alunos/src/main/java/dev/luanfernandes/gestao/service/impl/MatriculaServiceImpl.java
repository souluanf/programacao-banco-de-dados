package dev.luanfernandes.gestao.service.impl;

import dev.luanfernandes.gestao.entity.Aluno;
import dev.luanfernandes.gestao.entity.Curso;
import dev.luanfernandes.gestao.entity.Matricula;
import dev.luanfernandes.gestao.repository.MatriculaRepository;
import dev.luanfernandes.gestao.service.MatriculaService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class MatriculaServiceImpl implements MatriculaService {

    private final MatriculaRepository matriculaRepository;

    public MatriculaServiceImpl(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    @Override
    public UUID matricularAluno(Aluno aluno, Curso curso) {
        Matricula matricula = new Matricula();
        matricula.setAluno(aluno);
        matricula.setCurso(curso);
        matricula.setDataMatricula(new Date());
        matriculaRepository.save(matricula);
        return matricula.getId();
    }

    @Override
    public void cancelarMatricula(Long id) {
        matriculaRepository.deleteById(id);
    }

    @Override
    public List<Matricula> listarMatriculasPorCurso(Long cursoId) {
        return matriculaRepository.findByCursoId(cursoId);
    }

    @Override
    public List<Matricula> listarMatriculasPorAluno(Long alunoId) {
        return matriculaRepository.findByAlunoId(alunoId);
    }
}

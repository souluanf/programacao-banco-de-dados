package dev.luanfernandes.gestao.service.impl;

import dev.luanfernandes.gestao.entity.Curso;
import dev.luanfernandes.gestao.repository.CursoRepository;
import dev.luanfernandes.gestao.service.CursoService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public void criarCurso(Curso curso) {
        cursoRepository.save(curso);
    }

    @Override
    public void removerCurso(Long id) {
        cursoRepository.deleteById(id);
    }

    @Override
    public void atualizarCurso(Curso curso) {
        cursoRepository.save(curso);
    }

    @Override
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }
}

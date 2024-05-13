package dev.luanfernandes.gestao.service.impl;

import dev.luanfernandes.gestao.entity.Turma;
import dev.luanfernandes.gestao.repository.TurmaRepository;
import dev.luanfernandes.gestao.service.TurmaService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TurmaServiceImpl implements TurmaService {

    private final TurmaRepository turmaRepository;

    public TurmaServiceImpl(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    @Override
    public void criarTurma(Turma turma) {
        turmaRepository.save(turma);
    }

    @Override
    public void removerTurma(Long id) {
        turmaRepository.deleteById(id);
    }

    @Override
    public void atualizarTurma(Turma turma) {
        turmaRepository.save(turma);
    }

    @Override
    public List<Turma> listarTurmasPorCurso(Long cursoId) {
        return turmaRepository.findByCursoId(cursoId);
    }
}

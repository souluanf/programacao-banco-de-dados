package dev.luanfernandes.gestao.service.impl;

import dev.luanfernandes.gestao.entity.Professor;
import dev.luanfernandes.gestao.repository.ProfessorRepository;
import dev.luanfernandes.gestao.service.ProfessorService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public void adicionarProfessor(Professor professor) {
        professorRepository.save(professor);
    }

    @Override
    public void removerProfessor(Long id) {
        professorRepository.deleteById(id);
    }

    @Override
    public void atualizarProfessor(Professor professor) {
        professorRepository.save(professor);
    }

    @Override
    public List<Professor> listarProfessores() {
        return professorRepository.findAll();
    }
}

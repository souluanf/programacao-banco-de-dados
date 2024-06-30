package dev.luanfernandes.gestao;

import dev.luanfernandes.gestao.entity.Aluno;
import dev.luanfernandes.gestao.entity.Curso;
import dev.luanfernandes.gestao.entity.Professor;
import dev.luanfernandes.gestao.entity.Turma;
import dev.luanfernandes.gestao.service.AlunoService;
import dev.luanfernandes.gestao.service.CursoService;
import dev.luanfernandes.gestao.service.MatriculaService;
import dev.luanfernandes.gestao.service.ProfessorService;
import dev.luanfernandes.gestao.service.TurmaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Date;


@Slf4j
@Configuration
@Profile({"dev", "local"})
public class InitDB implements CommandLineRunner {
    private final AlunoService alunoService;
    private final CursoService cursoService;
    private final MatriculaService matriculaService;
    private final ProfessorService professorService;
    private final TurmaService turmaService;

    public InitDB(AlunoService alunoService, CursoService cursoService, MatriculaService matriculaService, ProfessorService professorService, TurmaService turmaService) {
        this.alunoService = alunoService;
        this.cursoService = cursoService;
        this.matriculaService = matriculaService;
        this.professorService = professorService;
        this.turmaService = turmaService;
    }

    @Override
    public void run(String... args) {

        // Criar alunos
        Aluno aluno1 = new Aluno("Maria Silva", "maria.silva@example.com", "123.456.789-00", new Date());
        alunoService.adicionarAluno(aluno1);
        Aluno aluno2 = new Aluno("Carlos Souza", "carlos.souza@example.com", "987.654.321-00", new Date());
        alunoService.adicionarAluno(aluno2);

        // Criar cursos
        Curso curso1 = new Curso("Engenharia de Software", "Curso de formação em Engenharia de Software.");
        cursoService.criarCurso(curso1);
        Curso curso2 = new Curso("Ciência da Computação", "Curso de formação em Ciência da Computação.");
        cursoService.criarCurso(curso2);


        // Criar professores
        Professor professor1 = new Professor("João Pereira", "email@email.com", "123.456.789-00", "Doutor", "Informática");
        professorService.adicionarProfessor(professor1);

        // Criar turmas
        Turma turma1 = new Turma("2024.1", "Segundas e Quartas 19-21h", curso1, professor1);
        turmaService.criarTurma(turma1);

        // Matricular alunos
        matriculaService.matricularAluno(aluno1, curso1);
        matriculaService.matricularAluno(aluno1, curso2);
        matriculaService.matricularAluno(aluno2, curso1);

        // Verificar alunos matriculados
        alunoService.listarAlunos().forEach(aluno -> {
            log.info("Aluno: {}", aluno.getNome());
            aluno.getMatriculas().forEach(matricula -> log.info("Matrícula: {}", matricula.getId()));
        });
    }
}

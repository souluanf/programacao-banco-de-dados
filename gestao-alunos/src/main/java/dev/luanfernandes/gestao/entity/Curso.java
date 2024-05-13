package dev.luanfernandes.gestao.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "curso",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Matricula> matriculas;

    @OneToMany(mappedBy = "curso",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Turma> turmas;

    public Curso(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
}

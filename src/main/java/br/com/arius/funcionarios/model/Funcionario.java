package br.com.arius.funcionarios.model;
import javax.persistence.*;

/**
 * Autor: Jackson
 * Classe: Funcionario
 * Criação da tabela no banco de dados e cardinalidade para a classe especialidade
 */


@Entity
@Table(name ="tecnicos")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idEspecialidade")
    private Especialidade especialidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
}

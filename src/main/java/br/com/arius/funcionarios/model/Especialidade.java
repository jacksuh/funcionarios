package br.com.arius.funcionarios.model;
import javax.persistence.*;

/**
 *
 * Classe para declaração de dados e persistencia com o banco de dados, sera criado a tabela especialidades no banco de dados.
 *
 * Autor: Jackson Santos
 */

@Entity
@Table(name = "especialidades")
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}

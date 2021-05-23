package br.com.arius.funcionarios.controller.dto;

import br.com.arius.funcionarios.model.Especialidade;
import org.modelmapper.ModelMapper;

/**
 * Classe EspecialidadeDto - Data Transfer Object, responsavel para tratamento de dados passados ao front-end, tratamento de conversão utilizado o Mapper.
 * Autor: Jackson Santos
 *
 */

public class EspecialidadeDto {

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


    public static EspecialidadeDto create(Especialidade especialidade){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(especialidade, EspecialidadeDto.class);
    }

}

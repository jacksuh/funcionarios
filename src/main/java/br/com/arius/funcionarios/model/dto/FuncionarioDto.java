package br.com.arius.funcionarios.model.dto;


import br.com.arius.funcionarios.model.Funcionario;
import org.modelmapper.ModelMapper;

/**
 * Autor: Jackson
 * Classe: Funcionario Dto para utilização do front end  e conversão do objeto
 */

public class FuncionarioDto {

    private Long id;
    private String nome;
    private EspecialidadeDto especialidadeDto;


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

    public EspecialidadeDto getEspecialidadeDto() {
        return especialidadeDto;
    }

    public void setEspecialidadeDto(EspecialidadeDto especialidadeDto) {
        this.especialidadeDto = especialidadeDto;
    }

    public static FuncionarioDto create(Funcionario funcionario){
        ModelMapper modelMapper = new ModelMapper();

        FuncionarioDto map = modelMapper.map(funcionario, FuncionarioDto.class);
        EspecialidadeDto espDto = new EspecialidadeDto();
        espDto.setId(funcionario.getEspecialidade().getId());
        espDto.setDescricao(funcionario.getEspecialidade().getDescricao());
        map.setEspecialidadeDto(espDto);
        return map;
    }
}

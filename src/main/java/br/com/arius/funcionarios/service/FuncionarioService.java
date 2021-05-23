package br.com.arius.funcionarios.service;
import br.com.arius.funcionarios.model.Especialidade;
import br.com.arius.funcionarios.model.Funcionario;
import br.com.arius.funcionarios.controller.dto.FuncionarioDto;
import br.com.arius.funcionarios.repository.EspecialidadeRepository;
import br.com.arius.funcionarios.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Modelo para tratamento de dados e persistencia para o modelo Funcionario (regra de negocio).
 * Autor: Jackson Santos
 */


@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    @Autowired
    EspecialidadeRepository especialidadeRepository;

    public List<FuncionarioDto> getTodos() {
        return repository.findAll().stream().map(FuncionarioDto::create).collect(Collectors.toList());
    }


    public Funcionario salvarFuncionario(FuncionarioDto dto) {
        Long idDescricao = dto.getEspecialidadeDto().getId();
        Especialidade especialidade =
                especialidadeRepository.findById(idDescricao)
                        .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Especialidade não encontrada"));

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(dto.getNome());
        funcionario.setEspecialidade(especialidade);

        return repository.save(funcionario);
    }

    public Optional<FuncionarioDto> getFuncionarioById(Long id) {
        return repository.findById(id).map(FuncionarioDto::create);
    }


    public Funcionario atualizarFuncionario(FuncionarioDto dto, Long id) {
        Optional<Funcionario> optional = repository.findById(id);

        Especialidade esp = new Especialidade();
        esp.setId(dto.getEspecialidadeDto().getId());
        esp.setDescricao(dto.getEspecialidadeDto().getDescricao());

        if (optional.isPresent()) {
            Funcionario db = optional.get();
            db.setNome(dto.getNome());
            db.setEspecialidade(esp);

            return repository.save(db);
        } else {
            throw new RuntimeException("Não foi possivel atualizar o cadastro");
        }
    }


    public void deletarFuncionario(Long id){
        Optional<Funcionario> funcionario = repository.findById(id);
        if(funcionario.isPresent()){
            repository.deleteById(id);
        }
    }

}

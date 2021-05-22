package br.com.arius.funcionarios.service;


import br.com.arius.funcionarios.model.Especialidade;
import br.com.arius.funcionarios.model.dto.EspecialidadeDto;
import br.com.arius.funcionarios.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EspecialidadeService {

    @Autowired
    EspecialidadeRepository repository;



    public List<EspecialidadeDto> getAll() {
        return repository.findAll().stream().map(EspecialidadeDto::create).collect(Collectors.toList());
    }



    public EspecialidadeDto insert(Especialidade dto){
       return EspecialidadeDto.create(repository.save(dto));
    }


    public Optional<EspecialidadeDto> getTecnicoById(Long id) {
        return repository.findById(id).map(EspecialidadeDto::create);
    }


    public EspecialidadeDto update(Especialidade especialidade, Long id) {
        Optional<Especialidade> optional = repository.findById(id);
        if (optional.isPresent()) {
            Especialidade db = optional.get();

            db.setDescricao(especialidade.getDescricao());

            repository.save(db);

            return EspecialidadeDto.create(db);
        } else {
            throw new RuntimeException("Não foi possivel atualizar o cadastro");
        }
    }


    public void delete(Long id){
        Optional<Especialidade> funcionario = repository.findById(id);
        if(funcionario.isPresent()){
            repository.deleteById(id);
        }
    }


}

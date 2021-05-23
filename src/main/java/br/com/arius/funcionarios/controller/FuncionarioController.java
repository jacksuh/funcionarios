package br.com.arius.funcionarios.controller;
import br.com.arius.funcionarios.model.Funcionario;
import br.com.arius.funcionarios.controller.dto.FuncionarioDto;
import br.com.arius.funcionarios.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Classe responsavel para tratamento do front-end  com os metodos Salvar/Atualizar/Deletar/pesquisar por Id para Funcionario.
 * Autor: Jackson Santos
 *
 */

@RestController
@RequestMapping("/api/funcionario")
@CrossOrigin("http://localhost:4200")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;


    @GetMapping
    public ResponseEntity<List<FuncionarioDto>>obterTodos(){
        List<FuncionarioDto> tecnico = service.getTodos();
        return ResponseEntity.ok(tecnico);
    }

    @PostMapping
    public ResponseEntity<FuncionarioDto> salvarFuncionario(@RequestBody FuncionarioDto funcionarioDto){
        Funcionario tec = service.salvarFuncionario(funcionarioDto);
        return ResponseEntity.ok(FuncionarioDto.create(tec));
    }


    @GetMapping("/{id}")
    public ResponseEntity buscarFuncionarioId(@PathVariable("id") Long id){
        Optional<FuncionarioDto> tecnico = service.getFuncionarioById(id);
        return ResponseEntity.ok(tecnico);
    }


    @PutMapping("/{id}")
    public ResponseEntity atualizarFuncionario(@PathVariable("id") Long id, @RequestBody FuncionarioDto dto){

        dto.setId(id);

        Funcionario f = service.atualizarFuncionario(dto,id);

        return f != null?
                ResponseEntity.ok(f) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarFuncionario(@PathVariable("id") Long id){
        service.deletarFuncionario(id);

        return ResponseEntity.ok().build();
    }
}

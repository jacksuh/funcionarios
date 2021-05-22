package br.com.arius.funcionarios.controller;

import br.com.arius.funcionarios.model.Especialidade;
import br.com.arius.funcionarios.model.dto.EspecialidadeDto;
import br.com.arius.funcionarios.service.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/especialidade")
@CrossOrigin("http://localhost:4200")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeService service;


    @GetMapping
    public ResponseEntity<List<EspecialidadeDto>>obterTodos(){
        List<EspecialidadeDto> tecnico = service.getAll();
        return ResponseEntity.ok(tecnico);
    }

    @PostMapping
    public ResponseEntity<EspecialidadeDto> post(@RequestBody Especialidade especialidade){
        EspecialidadeDto tipo = service.insert(especialidade);

        return ResponseEntity.ok(tipo);
    }


    @GetMapping("/{id}")
    public ResponseEntity buscarPorID(@PathVariable("id") Long id){
        Optional<EspecialidadeDto> tecnico = service.getTecnicoById(id);
        return ResponseEntity.ok(tecnico);
    }


    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable("id") Long id, @RequestBody Especialidade especialidade){

        especialidade.setId(id);

        EspecialidadeDto f = service.update(especialidade,id);

        return f != null?
                ResponseEntity.ok(f) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        service.delete(id);

        return ResponseEntity.ok().build();
    }
}

package br.com.arius.funcionarios.repository;

import br.com.arius.funcionarios.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;



public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {



}

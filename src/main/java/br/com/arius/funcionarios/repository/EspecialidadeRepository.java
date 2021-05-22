package br.com.arius.funcionarios.repository;

import br.com.arius.funcionarios.model.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {
}

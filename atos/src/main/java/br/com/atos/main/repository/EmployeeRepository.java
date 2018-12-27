package br.com.atos.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.atos.main.model.Employee;
import br.com.atos.main.model.Projects;

/**
 * Interface responsável pelas transações do Banco de dados da Classe Employee
 * @author Claudio Junior
 *
 */

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("select e from Employee e JOIN e.skill s where s.id_skill =:id")
	List<Employee> findByNome(@Param("id")Integer id);

}

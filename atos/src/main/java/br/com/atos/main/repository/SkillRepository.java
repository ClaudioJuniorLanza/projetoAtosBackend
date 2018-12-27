package br.com.atos.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.atos.main.model.Skill;

/**
 * Interface responsável pelas transações do Banco de dados da Classe Skill
 * @author Claudio Junior
 *
 */

public interface SkillRepository extends JpaRepository<Skill, Integer> {

	/**
	 * Método de busca pelas Skills cadastradas eliminando repetições de 
	 * Skill, se houver
	 * @return Lista de Skills
	 */
	
	@Query("select DISTINCT s.descricao from Skill s")
	List<Skill> findByUnique();
}

package br.com.atos.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.atos.main.model.Projects;

/**
 * Interface responsável pelas transações do Banco de dados da Classe Project
 * @author Claudio Junior
 *
 */

public interface ProjectRepository extends JpaRepository<Projects, Integer> {

}

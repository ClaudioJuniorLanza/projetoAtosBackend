package br.com.atos.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atos.main.model.Employee;
import br.com.atos.main.model.Projects;
import br.com.atos.main.repository.ProjectRepository;


/**
 * Classe de serviço Project responsável
 * pela comunicação com a Interface Repository
 * de Project
 * @author Claudio Junior
 *
 */

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository pr;

	public Projects inserirProject(Projects project) {
		
		Projects projectInserido = pr.save(project);
		return projectInserido;
	}

	public List<Projects> buscarTodosEmployee() {
		
		List<Projects> arrayproj = pr.findAll();
		return arrayproj;
	}
	
	public void removerProject(Integer id)
	{
		pr.deleteById(id);

	}
	
	public Projects atualizarProject(Projects project, Integer id)
	{
		
		Optional<Projects> verificaProj = pr.findById(id);
		
		if(!verificaProj.isPresent())
			return null;
		
		Projects projectEncontrado = verificaProj.get();
		
		projectEncontrado.setName(project.getName());
		projectEncontrado.setCustomer(project.getCustomer());
		projectEncontrado.setValueOfProject(project.getValueOfProject());
		projectEncontrado.setDtBegin(project.getDtBegin());
		projectEncontrado.setDtEnd(project.getDtEnd());
		//projectEncontrado.setEmployee(project.getEmployee());
		//clienteEncontrado.setDataAtualizacao(new Date());
		
		pr.save(projectEncontrado);
		
		
		return projectEncontrado;
	}

}

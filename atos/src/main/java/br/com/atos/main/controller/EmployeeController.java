package br.com.atos.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.atos.main.model.Employee;
import br.com.atos.main.model.Projects;
import br.com.atos.main.service.EmployeeService;
import br.com.atos.main.utils.Retorno;

/**
 * Classe Responsável por receber as requisições
 * destinadas a ações de Employees
 * @author Claudio Junior
 *
 */


@RestController
public class EmployeeController {

	@Autowired
	EmployeeService es;
	
	/**
	 * Método de salvar Employee
	 * @param employee Dados de Employee com cascade em Skill e Certification 
	 * @return Retorna mensagem de status da transação
	 */
	
	@CrossOrigin
	@RequestMapping(value = "/salvarEmployee", method=RequestMethod.POST)
	public Retorno gravarEmployee(@RequestBody Employee employee)
	{
		Employee employeeSalvo = es.inserirEmployee(employee);
		Retorno ret = new Retorno();
		ret.setIdRetorno(employeeSalvo.getId_employee());
		ret.setMensagem(ret.getMensageminsere());
		return ret;
	}
	
	/**
	 * Método de buscar todos os dados de Employee
	 * @return Lista de Employee cadastrados
	 */
	
	@CrossOrigin
	@RequestMapping(value = "/consultarEmployee", method=RequestMethod.GET)
	public List<Employee> retornarEmployee()
	{
		List<Employee> emp = es.buscarTodosEmployee();
		return emp;
	}
	
	
	/**
	 * Método de deletar Employee pelo Id
	 * @param id Id do Employee
	 * @return Mensagem de retorno da ação de exclusao
	 */
	
	@CrossOrigin
	@RequestMapping(value = "/removeremployee/{id}", method=RequestMethod.DELETE)
	public Retorno deletarEmployee(@PathVariable Integer id)
	{
		es.removerEmployee(id);
		Retorno ret = new Retorno();
		ret.setIdRetorno(id);
		String msg = ret.getMensagemdeleta();
		ret.setMensagem(msg);
		
		return ret;
	}
	
	/**
	 * Método para atualizar um Employee
	 * @param employee Dados de Employee
	 * @param id Id do Employee que será atualizado
	 * @return Retorna mensagem de ação do update
	 */
	
	@CrossOrigin
	@RequestMapping(value = "/atualizaremployee/{id}", method=RequestMethod.PUT)
	public Retorno alterarProject(@RequestBody Employee employee, @PathVariable Integer id)
	{
		
		Employee verificaEmp = es.atualizarEmployee(employee, id);
		
		if(verificaEmp.getId_employee()!= null)
		{
			Retorno ret = new Retorno();
			ret.setIdRetorno(verificaEmp.getId_employee());
			String msg = ret.getMensagematualiza();
			ret.setMensagem(msg);
			
			return ret;
		}
		return null;
		
	}
	
	
}

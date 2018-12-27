package br.com.atos.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atos.main.model.Employee;
import br.com.atos.main.repository.EmployeeRepository;

/**
 * Classe de serviço Employee responsável
 * pela comunicação com a Interface Repository
 * de Employees
 * @author Claudio Junior
 *
 */

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository er;
	
	public Employee inserirEmployee(Employee employee) {
		
		Employee employeeInserido = er.save(employee);
		return employeeInserido;
	}

	
	public List<Employee> buscarTodosEmployee() {
		List<Employee> arrayemp = er.findAll();
		return arrayemp;
	}
	
	public void removerEmployee(Integer id)
	{
		er.deleteById(id);

	}
	
	public Employee atualizarEmployee(Employee employee, Integer id)
	{
		
		Optional<Employee> verificaEmp = er.findById(id);
		
		if(!verificaEmp.isPresent())
			return null;
		
		Employee employeeEncontrado = verificaEmp.get();
		
		employeeEncontrado.setName(employee.getName());
		employeeEncontrado.setRole(employee.getRole());
		employeeEncontrado.setGcm(employee.getGcm());
		employeeEncontrado.setManager(employee.getManager());
		employeeEncontrado.setSalary(employee.getSalary());
		employeeEncontrado.setProject(employee.getProject());
		
		er.save(employeeEncontrado);
		
		
		return employeeEncontrado;
	}
	
}

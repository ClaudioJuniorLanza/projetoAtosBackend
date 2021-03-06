package br.com.atos.main.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * Classe Associativa derivada da associação
 * ManyToMay de Employee com Skill
 * @author Claudio Junior
 *
 */


@Entity
@Table(name = "employee_skill")
@JsonIgnoreType
public class EmployeeSkill implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_employee")
	private Integer employee;
	@Id
	@Column(name = "id_skill")
	private Integer skill;
	
	public EmployeeSkill(){}
	
	public EmployeeSkill(Integer employee, Integer skill){
		this.employee = employee;
		this.skill = skill;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((skill == null) ? 0 : skill.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeSkill other = (EmployeeSkill) obj;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (skill == null) {
			if (other.skill != null)
				return false;
		} else if (!skill.equals(other.skill))
			return false;
		return true;
	}

	public Integer getEmployee() {
		return employee;
	}

	public void setEmployee(Integer employee) {
		this.employee = employee;
	}

	public Integer getSkill() {
		return skill;
	}

	public void setSkill(Integer skill) {
		this.skill = skill;
	}
	
	
	
	
}

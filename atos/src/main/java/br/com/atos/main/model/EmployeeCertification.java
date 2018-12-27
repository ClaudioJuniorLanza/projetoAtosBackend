package br.com.atos.main.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * Classe associativa derivada da relação
 * entre Employee e Certification
 * @author Claudio Junior
 *
 */


@Entity
@Table(name = "employee_certification")
@JsonIgnoreType
public class EmployeeCertification implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_employee")
	private Integer employee;
	@Id
	@Column(name = "id_certification")
	private Integer certification;
	
	public EmployeeCertification(){}
	
	public EmployeeCertification(Integer employee, Integer certification){
		this.employee = employee;
		this.certification = certification;
	}
	
	public Integer getEmployee() {
		return employee;
	}
	public void setEmployee(Integer employee) {
		this.employee = employee;
	}
	public Integer getCertification() {
		return certification;
	}
	public void setCertification(Integer certification) {
		this.certification = certification;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((certification == null) ? 0 : certification.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
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
		EmployeeCertification other = (EmployeeCertification) obj;
		if (certification == null) {
			if (other.certification != null)
				return false;
		} else if (!certification.equals(other.certification))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		return true;
	}
}

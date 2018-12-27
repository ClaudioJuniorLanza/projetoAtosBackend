package br.com.atos.main.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * Classe model de Employees
 * que contém relação com Projects, Skill e Certification
 * Employee - Project: ManyToOne
 * Employee - Skill: ManyToMany
 * Employee - Certification: ManyToMany
 * @author Claudio Junior
 *
 */

@Entity
@Table(name = "employee")
@JsonView
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_employee;
	@NotNull
	@Column(name = "name", length = 120)
	private String name;
	@NotNull
	@Column(name = "role", length = 100)
	private String role;
	@NotNull
	private Double salary;
	@NotNull
	@Column(name = "manager", length = 120)
	private String manager;
	private int gcm;
	
	@ManyToOne
	private Projects project;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "employee_skill",
		joinColumns = @JoinColumn(name = "id_employee"),
		inverseJoinColumns = @JoinColumn(name = "id_skill")
			)
	private List<Skill> skill = new ArrayList<Skill>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_certification",
		joinColumns = @JoinColumn(name = "id_employee"),
		inverseJoinColumns = @JoinColumn(name = "id_certification")
			)
	private List<Certification> certification = new ArrayList<Certification>();
	
	public Employee(){}
	
	public Integer getId_employee() {
		return id_employee;
	}
	public void setId_employee(Integer id_employee) {
		this.id_employee = id_employee;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public int getGcm() {
		return gcm;
	}
	public void setGcm(int gcm) {
		this.gcm = gcm;
	}
	public Projects getProject() {
		return project;
	}
	public void setProject(Projects project) {
		this.project = project;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_employee == null) ? 0 : id_employee.hashCode());
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
		Employee other = (Employee) obj;
		if (id_employee == null) {
			if (other.id_employee != null)
				return false;
		} else if (!id_employee.equals(other.id_employee))
			return false;
		return true;
	}


	public List<Certification> getCertification() {
		return certification;
	}

	public void setCertification(List<Certification> certification) {
		this.certification = certification;
	}
	
	public List<Skill> getSkill() {
		return skill;
	}

	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}

}

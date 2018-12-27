package br.com.atos.main.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * Classe model de Skills
 * que contém relação com Employee
 * @author Claudio Junior
 *
 */


@Entity
@Table(name = "skill")
@JsonView
public class Skill implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_skill;
	@NotNull
	private String descricao;
	
	@ManyToMany(mappedBy = "skill")
	private List<Employee> employee = new ArrayList<Employee>();
	
	public Skill(){}
	
	public Skill(String descricao){
		this.descricao = descricao;
	}

	public Integer getId_skill() {
		return id_skill;
	}

	public void setId_skill(Integer id_skill) {
		this.id_skill = id_skill;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_skill == null) ? 0 : id_skill.hashCode());
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
		Skill other = (Skill) obj;
		if (id_skill == null) {
			if (other.id_skill != null)
				return false;
		} else if (!id_skill.equals(other.id_skill))
			return false;
		return true;
	}


}

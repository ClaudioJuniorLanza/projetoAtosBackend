package br.com.atos.main.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * Classe model de Certification
 * que contém relação ManyToMany com Employee
 * @author Claudio Junior
 *
 */


@Entity
@Table(name = "certification")
@JsonView
public class Certification implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_certification;
	@NotNull
	private String descricao;

	@ManyToMany(mappedBy = "certification")
	private List<Employee> employee = new ArrayList<Employee>();
	
	public Certification(){}
	
	public Certification(String descricao){
		this.descricao = descricao;
	}

	public Integer getId_certification() {
		return id_certification;
	}

	public void setId_certification(Integer id_certification) {
		this.id_certification = id_certification;
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
		result = prime * result + ((id_certification == null) ? 0 : id_certification.hashCode());
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
		Certification other = (Certification) obj;
		if (id_certification == null) {
			if (other.id_certification != null)
				return false;
		} else if (!id_certification.equals(other.id_certification))
			return false;
		return true;
	}
	
}

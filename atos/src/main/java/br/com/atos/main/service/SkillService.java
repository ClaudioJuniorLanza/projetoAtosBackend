package br.com.atos.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atos.main.model.Employee;
import br.com.atos.main.model.Skill;
import br.com.atos.main.repository.SkillRepository;

/**
 * Classe de serviço Skill responsável
 * pela comunicação com a Interface Repository
 * de Skills
 * @author Claudio Junior
 *
 */


@Service
public class SkillService {

	@Autowired
	SkillRepository sr;
	
	public List<Skill> buscarTodasSkill() {
		List<Skill> arrayemp = sr.findByUnique();
		return arrayemp;
	}
}
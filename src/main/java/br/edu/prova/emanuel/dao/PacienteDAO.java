package br.edu.prova.emanuel.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;


import br.edu.prova.emanuel.model.Paciente;


@Stateful
public class PacienteDAO {
	
	@Inject
	private EntityManager em;
	
	public Paciente findById(Long id) {
		return em.find(Paciente.class, id);
	}
	
	public List<Paciente> findAllHQL(){
		return em.createQuery("SELECT a FROM Paciente a", Paciente.class).getResultList();
	}
	
	public void save(Paciente u) {
		em.persist(u);
	}
	
	public void update(Paciente u) {
		em.merge(u);
	}
	
	public void delete(Paciente u) {
		em.remove(em.getReference(Paciente.class, u.getId_paciente()));
	}
	
	
}

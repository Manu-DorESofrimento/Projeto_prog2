package br.edu.prova.emanuel.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;


import br.edu.prova.emanuel.model.Profissional;


@Stateful
public class ProfissionalDAO {
	
	@Inject
	private EntityManager em;
	
	public Profissional findById(Long id) {
		return em.find(Profissional.class, id);
	}
	
	public List<Profissional> findAllHQL(){
		return em.createQuery("SELECT a FROM Profissional a", Profissional.class).getResultList();
	}
	
	public void save(Profissional u) {
		em.persist(u);
	}
	
	public void update(Profissional u) {
		em.merge(u);
	}
	
	public void delete(Profissional u) {
		em.remove(em.getReference(Profissional.class, u.getId_profissional()));
	}
	
	
}

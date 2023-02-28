package br.edu.projeto.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.edu.projeto.model.Pacientes;

//Classe DAO responsável pelas regras de negócio envolvendo operações de persistência de dados
//Indica-se a acriação de um DAO específico para cada Modelo

//Anotação EJB que indica que Bean (objeto criado para a classe) será comum para toda a aplicação
//Isso faz com que recursos computacionais sejam otimizados
@Stateful
public class PacientesDAO implements Serializable{

	@Inject
	//Cria a conexão e controla a transação com o SGBD (usado pelo Hibernate)
    private EntityManager em;
	
	public Pacientes encontrarId(Integer id) {
        return em.find(Pacientes.class, id);
    }
	
	//Query usando a API Criteria do Hibernate
	//Indicada para consultas complexas
	public Boolean ehUsuarioUnico(String u) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Pacientes> criteria = cb.createQuery(Pacientes.class);
        Root<Pacientes> paciente = criteria.from(Pacientes.class);
        criteria.select(paciente);
        criteria.where(cb.like(paciente.get("nome"), u));
        if (em.createQuery(criteria).getResultList().isEmpty())
        	return true;
        return false;
    }
	
	//Query usando a linguagem HQL do Hibernate
	//Idnicada para consultas simples
	public List<Pacientes> listarTodos() {
	    return em.createQuery("SELECT a FROM Usuario a ", Pacientes.class).getResultList();      
	}
	
	public void salvar(Pacientes u) {
		em.persist(u);
	}
	
	public void atualizar(Pacientes u) {
		em.merge(u);
	}
	
	public void excluir(Pacientes u) {
		em.remove(em.getReference(Pacientes.class, u.getId()));
	}
	
}

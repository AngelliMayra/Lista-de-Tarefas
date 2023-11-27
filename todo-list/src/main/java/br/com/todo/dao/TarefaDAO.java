package br.com.todo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.todo.model.Tarefa;

@Repository
public class TarefaDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	public TarefaDAO() {
		
	}

	@Transactional (readOnly = false)
	public void salvar(Tarefa tarefa) {
		entityManager.persist(tarefa);
		
		
	}

	@Transactional (readOnly = true)
	public List<Tarefa> getAll() {
		String jpql = "from Tarefa u";
		TypedQuery<Tarefa> consulta = entityManager.createQuery(jpql, Tarefa.class);
		
		return consulta.getResultList();
	}
	
	public Tarefa getId(int id) {
		return null;
		
	}
	
	public void excluir (int id) {
		
	}
	
	public void editar(int id, Tarefa tarefa) {
		
		
	}

}

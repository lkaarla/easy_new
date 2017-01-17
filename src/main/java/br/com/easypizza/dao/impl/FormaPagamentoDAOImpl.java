package br.com.easypizza.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.easypizza.dao.impl.EntityManagerUtil;
import br.com.easypizza.dao.FormaPagamentoDAO;
import br.com.easypizza.entidade.FormaPagamento;
import br.com.easypizza.exception.EasyPizzaDataBaseException;

public class FormaPagamentoDAOImpl implements FormaPagamentoDAO {

	EntityManager em = EntityManagerUtil.getEntityManager();

	@Override
	public void incluir(FormaPagamento formaPagamento) throws EasyPizzaDataBaseException {
		try{
		    //Inicia a transa��o com o banco.
			em.getTransaction().begin();
			
			//Persiste o objeto na tabela
			em.persist(formaPagamento);
			
			//Se der tudo certo, comita a transa��o
			em.getTransaction().commit();
			
			}catch(Exception e){
				//Caso ocorra alguma falha desfaz a transa��o
				em.getTransaction().rollback();
				throw new EasyPizzaDataBaseException("N�o foi possivel inserir o login na base de dados.", e);
			}finally{
				//Encerra a utiliza��o do entity manager e fecha a conex�o
				em.close();
			}
		
	}

	@Override
	public void excluirPorId(int idFormaPagamento) throws EasyPizzaDataBaseException {
		try{
			//Inicia a transa��o com o banco	
			em.getTransaction().begin();
			
			//Monta a query a ser executa pelo banco
			Query query = em.createQuery("DELETE FROM Login e WHERE e.idForma = :id");
			query.setParameter("id", idFormaPagamento);
			query.executeUpdate();
			
			//Se der tudo certo, comita a transa��o
			em.getTransaction().commit();
			}catch(Exception e){
				//Desfaz a transa��o
				em.getTransaction().rollback();
				throw new EasyPizzaDataBaseException("N�o foi possivel deletar o login na base de dados.", e);
			}finally{
				em.close();
			}
		
	}

	@Override
	public void excluir(FormaPagamento formaPagamento) throws EasyPizzaDataBaseException {
		try{
		    //Inicia a transa��o com o banco.
			em.getTransaction().begin();
			
			//Remove o usuario da lista
			em.remove(formaPagamento); 
			
			//Se der tudo certo, comita a transa��o
			em.getTransaction().commit();
			}catch(Exception e){
				//Caso ocorra alguma falha desfaz a transa��o
				em.getTransaction().rollback();
				throw new EasyPizzaDataBaseException("N�o foi possivel deletar o login na base de dados.", e);
			}finally{
				//Encerra a utiliza��o do entity manager e fecha a conex�o
				em.close();
			}
	}

	@Override
	public void alterar(FormaPagamento formaPagamento) throws EasyPizzaDataBaseException {
		try{
		    //Inicia a transa��o com o banco.
			em.getTransaction().begin();
			
			//Atualizar
			em.merge(formaPagamento); 
			
			//Se der tudo certo, comita a transa��o
			em.getTransaction().commit();
			}catch(Exception e){
				//Caso ocorra alguma falha desfaz a transa��o
				em.getTransaction().rollback();
				throw new EasyPizzaDataBaseException("N�o foi possivel alterar o login na base de dados.", e);
			}finally{
				//Encerra a utiliza��o do entity manager e fecha a conex�o
				em.close();
			}
	}

	@Override
	public FormaPagamento buscarFormaPagamentoPorId(int id) {
		FormaPagamento formaPagamento = em.find(FormaPagamento.class, id);
		return formaPagamento;
	}

	
}

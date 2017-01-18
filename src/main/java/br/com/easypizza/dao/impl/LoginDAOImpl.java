package br.com.easypizza.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.easypizza.dao.LoginDAO;
import br.com.easypizza.entidade.Login;
import br.com.easypizza.exception.EasyPizzaDataBaseException;

@Repository
public class LoginDAOImpl implements LoginDAO{

	EntityManager em = EntityManagerUtil.getEntityManager();

	/**
	 * Inclui um login na base dados
	 */
	@Override
	public void incluir(Login login) throws EasyPizzaDataBaseException {
		try{
		    //Inicia a transa��o com o banco.
			em.getTransaction().begin();
			
			//Persiste o objeto na tabela
			em.persist(login);
			
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

	/**
	 * Exclui um login por id
	 */
	@Override
	public void excluirPorId(int idLogin) throws EasyPizzaDataBaseException {
		try{
			//Inicia a transa��o com o banco	
			em.getTransaction().begin();
			
			//Monta a query a ser executa pelo banco
			Query query = em.createQuery("DELETE FROM Login e WHERE e.idLogin = :id");
			query.setParameter("id", idLogin);
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

	/**
	 * Exclui um login da base de dados
	 */
	@Override
	public void excluir(Login login) throws EasyPizzaDataBaseException {
		try{
		    //Inicia a transa��o com o banco.
			em.getTransaction().begin();
			
			//Remove o usuario da lista
			em.remove(login); 
			
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
	public void alterar(Login login) throws EasyPizzaDataBaseException {
		try{
		    //Inicia a transa��o com o banco.
			em.getTransaction().begin();
			
			//Atualizar
			em.merge(login); 
			
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

	/**
	 * Busca um login por id
	 */
	@Override
	public Login buscarLoginPorId(int id) {
		Login login = em.find(Login.class, id);
		return login;
	}

	/**
	 * Busca um login por email
	 */
	@Override
	public Login buscarLoginPorEmail(String email) {
		
		//Quando fazemos buscas no banco, n�o precisamos criar transa��es.
		TypedQuery<Login> query = em.createQuery("SELECT e FROM Login e WHERE e.login = :login", Login.class);
		query.setParameter("login", email);
		Login login = query.getSingleResult();
		return login;
	}

	@Override
	public Login buscarSenhaPorSenhaCad(String senha) {
		TypedQuery<Login> query = em.createQuery("SELECT e FROM Login e Where e.senha =:senha", Login.class);
		query.setParameter("senha", senha);
		Login senhax = query.getSingleResult();
		return senhax;
	}
	
	
}

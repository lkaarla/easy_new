package br.com.easypizza.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.easypizza.dao.TipoUsuarioDAO;
import br.com.easypizza.entidade.TipoUsuario;
import br.com.easypizza.exception.EasyPizzaDataBaseException;

public class TipoUsuarioDAOImpl implements TipoUsuarioDAO {

	EntityManager em = EntityManagerUtil.getEntityManager();
	
	/**
	 * Inclui um tipo de usuário na base de dados
	 * @throws EasyPizzaDataBaseException Exceção lançada quando não é possivel inserir o registro na base de dados.
	 */
	@Override
	public void incluir(TipoUsuario tipoUsuario) throws EasyPizzaDataBaseException {
		try{
	    //Inicia a transação com o banco.
		em.getTransaction().begin();
		
		//Persiste o objeto na tabela
		em.persist(tipoUsuario);
		
		//Se der tudo certo, comita a transação
		em.getTransaction().commit();
		
		}catch(Exception e){
			//Caso ocorra alguma falha desfaz a transação
			em.getTransaction().rollback();
			throw new EasyPizzaDataBaseException("Não foi possivel inserir tipo usuário na base de dados.", e);
		}finally{
			//Encerra a utilização do entity manager e fecha a conexão
			em.close();
		}
	}


	@Override
	public void alterar(TipoUsuario tipoUsuario) throws EasyPizzaDataBaseException {
		try{
		    //Inicia a transação com o banco.
			em.getTransaction().begin();
			
			//Atualizar o tipo usuario
			em.merge(tipoUsuario); 
			
			//Se der tudo certo, comita a transação
			em.getTransaction().commit();
			}catch(Exception e){
				//Caso ocorra alguma falha desfaz a transação
				em.getTransaction().rollback();
				throw new EasyPizzaDataBaseException("Não foi possivel alterar tipo usuário na base de dados.", e);
			}finally{
				//Encerra a utilização do entity manager e fecha a conexão
				em.close();
			}
	}

	@Override
	public TipoUsuario buscarTipoUsuarioPorId(int id) {
		TipoUsuario tipoUsuarioComId = em.find(TipoUsuario.class, id);
		return tipoUsuarioComId;
	}

	/**
	 * Exclui um tipo usuário por id
	 */
	@Override
	public void excluirPorId(int idTipoUsuario) throws EasyPizzaDataBaseException {
		try{
		//Inicia a transação com o banco	
		em.getTransaction().begin();
		
		//Monta a query a ser executa pelo banco
		Query query = em.createQuery("DELETE FROM TipoUsuario e WHERE e.idTipoUsuario = :id");
		query.setParameter("id", idTipoUsuario);
		query.executeUpdate();
		
		//Se der tudo certo, comita a transação
		em.getTransaction().commit();
		}catch(Exception e){
			//Desfaz a transação
			em.getTransaction().rollback();
			throw new EasyPizzaDataBaseException("Não foi possivel deletar tipo usuário na base de dados.", e);
		}finally{
			em.close();
		}
		
	}

	/**
	 * Exclui um tipo usuário do banco
	 */
	@Override
	public void excluir(TipoUsuario tipoUsuario) throws EasyPizzaDataBaseException {
		try{
		    //Inicia a transação com o banco.
			em.getTransaction().begin();
			
			//Remove o usuario da lista
			em.remove(tipoUsuario); 
			
			//Se der tudo certo, comita a transação
			em.getTransaction().commit();
			}catch(Exception e){
				//Caso ocorra alguma falha desfaz a transação
				em.getTransaction().rollback();
				throw new EasyPizzaDataBaseException("Não foi possivel deletar tipo usuário na base de dados.", e);
			}finally{
				//Encerra a utilização do entity manager e fecha a conexão
				em.close();
			}
		
	}

	
}

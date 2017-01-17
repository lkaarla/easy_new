package br.com.easypizza.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.easypizza.dao.TipoUsuarioDAO;
import br.com.easypizza.entidade.TipoUsuario;
import br.com.easypizza.exception.EasyPizzaDataBaseException;

public class TipoUsuarioDAOImpl implements TipoUsuarioDAO {

	EntityManager em = EntityManagerUtil.getEntityManager();
	
	/**
	 * Inclui um tipo de usu�rio na base de dados
	 * @throws EasyPizzaDataBaseException Exce��o lan�ada quando n�o � possivel inserir o registro na base de dados.
	 */
	@Override
	public void incluir(TipoUsuario tipoUsuario) throws EasyPizzaDataBaseException {
		try{
	    //Inicia a transa��o com o banco.
		em.getTransaction().begin();
		
		//Persiste o objeto na tabela
		em.persist(tipoUsuario);
		
		//Se der tudo certo, comita a transa��o
		em.getTransaction().commit();
		
		}catch(Exception e){
			//Caso ocorra alguma falha desfaz a transa��o
			em.getTransaction().rollback();
			throw new EasyPizzaDataBaseException("N�o foi possivel inserir tipo usu�rio na base de dados.", e);
		}finally{
			//Encerra a utiliza��o do entity manager e fecha a conex�o
			em.close();
		}
	}


	@Override
	public void alterar(TipoUsuario tipoUsuario) throws EasyPizzaDataBaseException {
		try{
		    //Inicia a transa��o com o banco.
			em.getTransaction().begin();
			
			//Atualizar o tipo usuario
			em.merge(tipoUsuario); 
			
			//Se der tudo certo, comita a transa��o
			em.getTransaction().commit();
			}catch(Exception e){
				//Caso ocorra alguma falha desfaz a transa��o
				em.getTransaction().rollback();
				throw new EasyPizzaDataBaseException("N�o foi possivel alterar tipo usu�rio na base de dados.", e);
			}finally{
				//Encerra a utiliza��o do entity manager e fecha a conex�o
				em.close();
			}
	}

	@Override
	public TipoUsuario buscarTipoUsuarioPorId(int id) {
		TipoUsuario tipoUsuarioComId = em.find(TipoUsuario.class, id);
		return tipoUsuarioComId;
	}

	/**
	 * Exclui um tipo usu�rio por id
	 */
	@Override
	public void excluirPorId(int idTipoUsuario) throws EasyPizzaDataBaseException {
		try{
		//Inicia a transa��o com o banco	
		em.getTransaction().begin();
		
		//Monta a query a ser executa pelo banco
		Query query = em.createQuery("DELETE FROM TipoUsuario e WHERE e.idTipoUsuario = :id");
		query.setParameter("id", idTipoUsuario);
		query.executeUpdate();
		
		//Se der tudo certo, comita a transa��o
		em.getTransaction().commit();
		}catch(Exception e){
			//Desfaz a transa��o
			em.getTransaction().rollback();
			throw new EasyPizzaDataBaseException("N�o foi possivel deletar tipo usu�rio na base de dados.", e);
		}finally{
			em.close();
		}
		
	}

	/**
	 * Exclui um tipo usu�rio do banco
	 */
	@Override
	public void excluir(TipoUsuario tipoUsuario) throws EasyPizzaDataBaseException {
		try{
		    //Inicia a transa��o com o banco.
			em.getTransaction().begin();
			
			//Remove o usuario da lista
			em.remove(tipoUsuario); 
			
			//Se der tudo certo, comita a transa��o
			em.getTransaction().commit();
			}catch(Exception e){
				//Caso ocorra alguma falha desfaz a transa��o
				em.getTransaction().rollback();
				throw new EasyPizzaDataBaseException("N�o foi possivel deletar tipo usu�rio na base de dados.", e);
			}finally{
				//Encerra a utiliza��o do entity manager e fecha a conex�o
				em.close();
			}
		
	}

	
}

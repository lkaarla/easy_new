package br.com.easypizza.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.easypizza.dao.PedidoDAO;
import br.com.easypizza.entidade.Pedido;
import br.com.easypizza.exception.EasyPizzaDataBaseException;

@Repository

public class PedidoDAOImpl implements PedidoDAO {
	EntityManager em = EntityManagerUtil.getEntityManager();


	@Override
	public void incluir(Pedido cp) throws EasyPizzaDataBaseException {
		try{
		    //Inicia a transa��o com o banco.
				em.getTransaction().begin();
				
				//Persiste o objeto na tabela
				em.persist(cp);
				//Se der tudo certo, comita a transa��o
				em.getTransaction().commit();
				
				}
				catch(Exception e){
					//Caso ocorra alguma falha desfaz a transa��o
					em.getTransaction().rollback();
					throw new EasyPizzaDataBaseException("N�o foi possivel inserir o pedido na base de dados.", e);
				}
				finally{
					//Encerra a utiliza��o do entity manager e fecha a conex�o
					em.close();		
		}
	}

	@Override
	public void excluirPorId(int idPedido) throws EasyPizzaDataBaseException {
		try{
			//Inicia a transa��o com o banco	
			em.getTransaction().begin();
			
			//Monta a query a ser executa pelo banco
			Query query = em.createQuery("DELETE FROM Pedido e WHERE e.idPedido = :idPedido");
			query.setParameter("idPedido", idPedido);
			query.executeUpdate();
			
			//Se der tudo certo, comita a transa��o
			em.getTransaction().commit();
			}catch(Exception e){
				//Desfaz a transa��o
				em.getTransaction().rollback();
				throw new EasyPizzaDataBaseException("N�o foi possivel deletar o pedido na base de dados.", e);
			}finally{
				em.close();
			}
	}

	@Override
	public void excluir(Pedido cp) throws EasyPizzaDataBaseException {
		try{
		    //Inicia a transa��o com o banco.
			em.getTransaction().begin();
			
			//Atualizar
			em.merge(cp); 
			
			//Se der tudo certo, comita a transa��o
			em.getTransaction().commit();
			}
		catch(Exception e){
				//Caso ocorra alguma falha desfaz a transa��o
				em.getTransaction().rollback();
				throw new EasyPizzaDataBaseException("N�o foi possivel alterar o pedido na base de dados.", e);
			}finally{
				//Encerra a utiliza��o do entity manager e fecha a conex�o
				em.close();
			}			
	}

	@Override
	public void alterar(Pedido pedido) throws EasyPizzaDataBaseException {
		try{
		    //Inicia a transa��o com o banco.
			em.getTransaction().begin();
			
			//Atualizar
			em.merge(pedido); 
			
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
	public Pedido buscarPedidoPorId(int idPedido) {
		Pedido pedido = em.find(Pedido.class, idPedido);
		return pedido;
	}

}

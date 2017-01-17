package br.com.easypizza.dao.impl;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.easypizza.dao.PedidoItemDAO;
import br.com.easypizza.entidade.PedidoItem;
import br.com.easypizza.exception.EasyPizzaDataBaseException;

@Repository

public class PedidoItemDAOImpl implements PedidoItemDAO {

	EntityManager em = EntityManagerUtil.getEntityManager();

	@Override
	public void incluir(PedidoItem cpi) throws EasyPizzaDataBaseException {
		try {
			// Inicia a transa��o com o banco.
			em.getTransaction().begin();

			// Persiste o objeto na tabela
			em.persist(cpi);

			// Se der tudo certo, comita a transa��o
			em.getTransaction().commit();

		} catch (Exception e) {
			// Caso ocorra alguma falha desfaz a transa��o
			em.getTransaction().rollback();
			
			throw new EasyPizzaDataBaseException("N�o foi possivel inserir o pedido na base de dados.", e);
		} finally {
			// Encerra a utiliza��o do entity manager e fecha a conex�o
			em.close();
		}
	}

	@Override
	public void alterar(PedidoItem pedidoItem) throws EasyPizzaDataBaseException {
		try {
			// Inicia a transa��o com o banco.
			em.getTransaction().begin();

			// Atualizar
			em.merge(pedidoItem);

			// Se der tudo certo, comita a transa��o
			em.getTransaction().commit();
		} catch (Exception e) {
			// Caso ocorra alguma falha desfaz a transa��o
			em.getTransaction().rollback();
			throw new EasyPizzaDataBaseException("N�o foi possivel alterar o pedido na base de dados.", e);
		} finally {
			// Encerra a utiliza��o do entity manager e fecha a conex�o
			em.close();
		}
	}

	@Override
	public void excluir(PedidoItem pedidoItem) throws EasyPizzaDataBaseException {
		try {
			// Inicia a transa��o com o banco.
			em.getTransaction().begin();

			// Remove o usuario da lista
			em.remove(pedidoItem);

			// Se der tudo certo, comita a transa��o
			em.getTransaction().commit();
		} catch (Exception e) {
			// Caso ocorra alguma falha desfaz a transa��o
			em.getTransaction().rollback();
			throw new EasyPizzaDataBaseException("N�o foi possivel deletar o pedido na base de dados.", e);
		} finally {
			// Encerra a utiliza��o do entity manager e fecha a conex�o
			em.close();
		}

	}

	@Override
	public PedidoItem buscarPedidoPorId(int idPedidoItem) {
		PedidoItem pedidoItem = em.find(PedidoItem.class, idPedidoItem);
		return pedidoItem;
	}

}

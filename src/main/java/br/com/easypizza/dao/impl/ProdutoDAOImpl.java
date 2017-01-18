package br.com.easypizza.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.easypizza.dao.ProdutoDAO;
import br.com.easypizza.entidade.Produto;
import br.com.easypizza.exception.EasyPizzaDataBaseException;

public class ProdutoDAOImpl implements ProdutoDAO{
	
	EntityManager em = EntityManagerUtil.getEntityManager();

	@Override
	public void incluir(Produto produto) throws EasyPizzaDataBaseException {
		try{
		    //Inicia a transação com o banco.
			em.getTransaction().begin();
			
			//Persiste o objeto na tabela
			em.persist(produto);
			
			//Se der tudo certo, comita a transação
			em.getTransaction().commit();
			
			}catch(Exception e){
				//Caso ocorra alguma falha desfaz a transação
				em.getTransaction().rollback();
				throw new EasyPizzaDataBaseException("Não foi possivel inserir o produto na base de dados.", e);
			}finally{
				//Encerra a utilização do entity manager e fecha a conexão
				em.close();
			}
	}

	@Override
	public void excluirPorId(int idProduto) throws EasyPizzaDataBaseException {
		try{
			//Inicia a transação com o banco	
			em.getTransaction().begin();
			
			//Monta a query a ser executa pelo banco
			Query query = em.createQuery("DELETE FROM Produto e WHERE e.idProduto = :id");
			query.setParameter("id", idProduto);
			query.executeUpdate();
			
			//Se der tudo certo, comita a transação
			em.getTransaction().commit();
			}catch(Exception e){
				//Desfaz a transação
				em.getTransaction().rollback();
				throw new EasyPizzaDataBaseException("Não foi possivel deletar o produto na base de dados.", e);
			}finally{
				em.close();
			}
		
	}

	@Override
	public void excluir(Produto produto) throws EasyPizzaDataBaseException {
		try{
		    //Inicia a transação com o banco.
			em.getTransaction().begin();
			
			//Remove o usuario da lista
			em.remove(produto); 
			
			//Se der tudo certo, comita a transação
			em.getTransaction().commit();
			}catch(Exception e){
				//Caso ocorra alguma falha desfaz a transação
				em.getTransaction().rollback();
				throw new EasyPizzaDataBaseException("Não foi possivel deletar o produto na base de dados.", e);
			}finally{
				//Encerra a utilização do entity manager e fecha a conexão
				em.close();
			}
	}

	@Override
	public void alterar(Produto produto) throws EasyPizzaDataBaseException {
		try{
		    //Inicia a transação com o banco.
			em.getTransaction().begin();
			
			//Atualizar
			em.merge(produto); 
			
			//Se der tudo certo, comita a transação
			em.getTransaction().commit();
			}catch(Exception e){
				//Caso ocorra alguma falha desfaz a transação
				em.getTransaction().rollback();
				throw new EasyPizzaDataBaseException("Não foi possivel alterar o produto na base de dados.", e);
			}finally{
				//Encerra a utilização do entity manager e fecha a conexão
				em.close();
			}
	}

	@Override
	public Produto buscarProdutoPorId(int id) {
		Produto produto = em.find(Produto.class, id);
		return produto;
	}

	@Override
	public List<Produto> listarTodosProdutos() throws EasyPizzaDataBaseException {
		Query query = em.createQuery("string pro from Produto pro");
		List<Produto> listarProduto = query.getResultList();
		em.close();
		return listarProduto;
	}

}

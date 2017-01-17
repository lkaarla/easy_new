package br.com.easypizza.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.easypizza.dao.ClienteDAO;
import br.com.easypizza.entidade.Cliente;
import br.com.easypizza.exception.EasyPizzaDataBaseException;

public class ClienteDAOImpl implements ClienteDAO {

	EntityManager em = EntityManagerUtil.getEntityManager();

	@Override
	public void incluir(Cliente cliente) throws EasyPizzaDataBaseException {
		try{
		    //Inicia a transação com o banco.
			em.getTransaction().begin();
			
			//Persiste o objeto na tabela
			em.persist(cliente);
			
			//Se der tudo certo, comita a transação
			em.getTransaction().commit();
			
			}catch(Exception e){
				//Caso ocorra alguma falha desfaz a transação
				em.getTransaction().rollback();
				throw new EasyPizzaDataBaseException("Não foi possivel inserir o login na base de dados.", e);
			}finally{
				//Encerra a utilização do entity manager e fecha a conexão
				em.close();
			}
	}

	@Override
	public void excluirPorId(int idCliente) throws EasyPizzaDataBaseException {
		try{
			//Inicia a transação com o banco	
			em.getTransaction().begin();
			
			//Monta a query a ser executa pelo banco
			Query query = em.createQuery("DELETE FROM Cliente e WHERE e.idCliente = :id");
			query.setParameter("id", idCliente);
			query.executeUpdate();
			
			//Se der tudo certo, comita a transação
			em.getTransaction().commit();
			}catch(Exception e){
				//Desfaz a transação
				em.getTransaction().rollback();
				throw new EasyPizzaDataBaseException("Não foi possivel deletar o login na base de dados.", e);
			}finally{
				em.close();
			}
		
	}

	@Override
	public void excluir(Cliente cliente) throws EasyPizzaDataBaseException {
		try{
		    //Inicia a transação com o banco.
			em.getTransaction().begin();
			
			//Remove o usuario da lista
			em.remove(cliente); 
			
			//Se der tudo certo, comita a transação
			em.getTransaction().commit();
			}catch(Exception e){
				//Caso ocorra alguma falha desfaz a transação
				em.getTransaction().rollback();
				throw new EasyPizzaDataBaseException("Não foi possivel deletar o login na base de dados.", e);
			}finally{
				//Encerra a utilização do entity manager e fecha a conexão
				em.close();
			}
	}

	@Override
	public void alterar(Cliente cliente) throws EasyPizzaDataBaseException {
		try{
		    //Inicia a transação com o banco.
			em.getTransaction().begin();
			
			//Atualizar
			em.merge(cliente); 
			
			//Se der tudo certo, comita a transação
			em.getTransaction().commit();
			}catch(Exception e){
				//Caso ocorra alguma falha desfaz a transação
				em.getTransaction().rollback();
				throw new EasyPizzaDataBaseException("Não foi possivel alterar o login na base de dados.", e);
			}finally{
				//Encerra a utilização do entity manager e fecha a conexão
				em.close();
			}
	}

	@Override
	public Cliente buscarClientePorId(int id) {
		Cliente cliente = em.find(Cliente.class, id);
		return cliente;
	}

	@Override
	public Cliente buscarClientePorNome(String nome) {
		//Quando fazemos buscas no banco, não precisamos criar transações.
		TypedQuery<Cliente> query = em.createQuery("SELECT e FROM Cliente e WHERE e.nome = :nome", Cliente.class);
		query.setParameter("nome", nome);
		Cliente cliente = query.getSingleResult();
		return cliente;
	}

}

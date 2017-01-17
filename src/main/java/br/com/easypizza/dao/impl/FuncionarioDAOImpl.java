package br.com.easypizza.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.easypizza.dao.FuncionarioDAO;
import br.com.easypizza.entidade.Funcionario;
import br.com.easypizza.exception.EasyPizzaDataBaseException;


public class FuncionarioDAOImpl implements FuncionarioDAO {
	
	EntityManager em = EntityManagerUtil.getEntityManager();

	@Override
	public void incluir(Funcionario funcionario) throws EasyPizzaDataBaseException {
		try{
		    //Inicia a transa��o com o banco.
			em.getTransaction().begin();
			
			//Persiste o objeto na tabela
			em.persist(funcionario);
			
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
	public void excluirPorId(int idFuncionario) throws EasyPizzaDataBaseException {
		try{
			//Inicia a transa��o com o banco	
			em.getTransaction().begin();
			
			//Monta a query a ser executa pelo banco
			Query query = em.createQuery("DELETE FROM Funcionario e WHERE e.idFuncionario = :id");
			query.setParameter("id", idFuncionario);
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
	public void excluir(Funcionario funcionario) throws EasyPizzaDataBaseException {
		try{
		    //Inicia a transa��o com o banco.
			em.getTransaction().begin();
			
			//Remove o usuario da lista
			em.remove(funcionario); 
			
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
	public void alterar(Funcionario funcionario) throws EasyPizzaDataBaseException {
		try{
		    //Inicia a transa��o com o banco.
			em.getTransaction().begin();
			
			//Atualizar
			em.merge(funcionario); 
			
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
	public Funcionario buscarFuncionarioPorId(int id) {
		Funcionario funcionario = em.find(Funcionario.class, id);
		return funcionario;
	}

	@Override
	public Funcionario buscarFuncionarioPorNome(String nome) {
		//Quando fazemos buscas no banco, n�o precisamos criar transa��es.
		TypedQuery<Funcionario> query = em.createQuery("SELECT e FROM Funcionario e WHERE e.nome = :nome", Funcionario.class);
		query.setParameter("nome", nome);
		Funcionario funcionario = query.getSingleResult();
		return funcionario;
	}

	
}

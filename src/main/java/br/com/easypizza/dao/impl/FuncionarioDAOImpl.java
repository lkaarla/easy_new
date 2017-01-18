package br.com.easypizza.dao.impl;

import java.util.List;

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
		    //Inicia a transação com o banco.
			em.getTransaction().begin();
			
			//Persiste o objeto na tabela
			em.persist(funcionario);
			
			//Se der tudo certo, comita a transação
			em.getTransaction().commit();
			
			}catch(Exception e){
				//Caso ocorra alguma falha desfaz a transação
				em.getTransaction().rollback();
				throw new EasyPizzaDataBaseException("Não foi possivel inserir o funcionário na base de dados.", e);
			}finally{
				//Encerra a utilização do entity manager e fecha a conexão
				em.close();
			}
	}

	@Override
	public void excluirPorMatricula(int matricula) throws EasyPizzaDataBaseException {
		try{
			//Inicia a transação com o banco	
			em.getTransaction().begin();
			
			//Monta a query a ser executa pelo banco
			Query query = em.createQuery("DELETE FROM Funcionario e WHERE e.idFuncionario = :id");
			query.setParameter("id", matricula);
			query.executeUpdate();
			
			//Se der tudo certo, comita a transação
			em.getTransaction().commit();
			}catch(Exception e){
				//Desfaz a transação
				em.getTransaction().rollback();
				throw new EasyPizzaDataBaseException("Não foi possivel deletar o funcionário na base de dados.", e);
			}finally{
				em.close();
			}
	}

	@Override
	public void excluir(Funcionario funcionario) throws EasyPizzaDataBaseException {
		try{
		    //Inicia a transação com o banco.
			em.getTransaction().begin();
			
			//Remove o usuario da lista
			em.remove(funcionario); 
			
			//Se der tudo certo, comita a transação
			em.getTransaction().commit();
			}catch(Exception e){
				//Caso ocorra alguma falha desfaz a transação
				em.getTransaction().rollback();
				throw new EasyPizzaDataBaseException("Não foi possivel deletar o funcionário na base de dados.", e);
			}finally{
				//Encerra a utilização do entity manager e fecha a conexão
				em.close();
			}
	}

	@Override
	public void alterar(Funcionario funcionario) throws EasyPizzaDataBaseException {
		try{
		    //Inicia a transação com o banco.
			em.getTransaction().begin();
			
			//Atualizar
			em.merge(funcionario); 
			
			//Se der tudo certo, comita a transação
			em.getTransaction().commit();
			}catch(Exception e){
				//Caso ocorra alguma falha desfaz a transação
				em.getTransaction().rollback();
				throw new EasyPizzaDataBaseException("Não foi possivel alterar o funcionário na base de dados.", e);
			}finally{
				//Encerra a utilização do entity manager e fecha a conexão
				em.close();
			}
	}

	@Override
	public Funcionario buscarFuncionarioPorMatricula(int matricula) {
		Funcionario funcionario = em.find(Funcionario.class, matricula);
		return funcionario;
	}

	@Override
	public Funcionario buscarFuncionarioPorNome(String nome) {
		//Quando fazemos buscas no banco, não precisamos criar transações.
		TypedQuery<Funcionario> query = em.createQuery("SELECT e FROM Funcionario e WHERE e.nome = :nome", Funcionario.class);
		query.setParameter("nome", nome);
		Funcionario funcionario = query.getSingleResult();
		return funcionario;
	}

	@Override
	public List<Funcionario> listarTodosFuncionarios() throws EasyPizzaDataBaseException {
		Query query = em.createQuery("Select f from Funcionario f");
		List<Funcionario> listarFuncionario = query.getResultList();
		em.close();
		return listarFuncionario;
		
	}

	
}

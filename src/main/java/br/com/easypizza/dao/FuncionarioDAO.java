package br.com.easypizza.dao;

import java.util.List;

import br.com.easypizza.entidade.Funcionario;
import br.com.easypizza.exception.EasyPizzaDataBaseException;

public interface FuncionarioDAO {
	

	public void incluir(Funcionario funcionario) throws EasyPizzaDataBaseException;
	public void excluirPorMatricula (int matricula) throws EasyPizzaDataBaseException;
	public void excluir (Funcionario funcionario) throws EasyPizzaDataBaseException;
	public void alterar(Funcionario funcionario) throws EasyPizzaDataBaseException;
	public Funcionario buscarFuncionarioPorMatricula(int matricula) throws EasyPizzaDataBaseException;
	public Funcionario buscarFuncionarioPorNome(String nome) throws EasyPizzaDataBaseException; 
	public List<Funcionario> listarTodosFuncionarios() throws EasyPizzaDataBaseException;
	
	

}

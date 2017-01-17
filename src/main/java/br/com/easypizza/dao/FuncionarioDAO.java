package br.com.easypizza.dao;

import br.com.easypizza.entidade.Funcionario;
import br.com.easypizza.exception.EasyPizzaDataBaseException;

public interface FuncionarioDAO {
	

	public void incluir(Funcionario funcionario) throws EasyPizzaDataBaseException;
	public void excluirPorId (int idFuncionario) throws EasyPizzaDataBaseException;
	public void excluir (Funcionario funcionario) throws EasyPizzaDataBaseException;
	public void alterar(Funcionario funcionario) throws EasyPizzaDataBaseException;
	public Funcionario buscarFuncionarioPorId(int id);
	public Funcionario buscarFuncionarioPorNome(String nome); 

	

}

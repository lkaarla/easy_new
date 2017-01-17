package br.com.easypizza.dao;

import br.com.easypizza.entidade.Login;
import br.com.easypizza.exception.EasyPizzaDataBaseException;

public interface LoginDAO {
	
	public void incluir(Login login) throws EasyPizzaDataBaseException;
	public void excluirPorId (int idLogin) throws EasyPizzaDataBaseException;
	public void excluir (Login login) throws EasyPizzaDataBaseException;
	public void alterar(Login login) throws EasyPizzaDataBaseException;
	public Login buscarLoginPorId(int id);
	public Login buscarLoginPorEmail(String email); 

}

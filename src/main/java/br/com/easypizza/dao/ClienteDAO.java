package br.com.easypizza.dao;
import br.com.easypizza.entidade.Cliente;
import br.com.easypizza.exception.EasyPizzaDataBaseException;

public interface ClienteDAO {
	
	public void incluir(Cliente cliente) throws EasyPizzaDataBaseException;
	public void excluirPorId (int idCliente) throws EasyPizzaDataBaseException;
	public void excluir (Cliente cliente) throws EasyPizzaDataBaseException;
	public void alterar(Cliente cliente) throws EasyPizzaDataBaseException;
	public Cliente buscarClientePorId(int id);
	public Cliente buscarClientePorNome(String nome); 

}

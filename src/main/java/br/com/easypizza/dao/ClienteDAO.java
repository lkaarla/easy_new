package br.com.easypizza.dao;
import java.util.List;

import br.com.easypizza.entidade.Cliente;
import br.com.easypizza.exception.EasyPizzaDataBaseException;

public interface ClienteDAO {
	
	public void incluir(Cliente cliente) throws EasyPizzaDataBaseException;
	public void excluirPorCpf(int cpf) throws EasyPizzaDataBaseException;
	public void alterar(Cliente cliente) throws EasyPizzaDataBaseException;
	public Cliente buscarClientePorNome(String nome) throws EasyPizzaDataBaseException;
	public List<Cliente> listarTodosClientes() throws EasyPizzaDataBaseException;
	void excluir(Cliente cliente) throws EasyPizzaDataBaseException;
	
	
}

package br.com.easypizza.service;

import java.util.List;

import br.com.easypizza.exception.EasyPizzaDataBaseException;
import br.com.easypizza.exception.EasyPizzaServiceException;
import br.com.easypizza.vo.ClienteVO;



public interface ClienteService {

	public void salvarCliente(ClienteVO clienteVO) throws EasyPizzaServiceException, EasyPizzaDataBaseException;
	public List<ClienteVO> listarTodosClientes() throws EasyPizzaServiceException, EasyPizzaDataBaseException;
	public void alterarCliente(ClienteVO clienteVO)  throws EasyPizzaServiceException, EasyPizzaDataBaseException;
	public void excluirPorCpf(int cpf) throws EasyPizzaServiceException, EasyPizzaDataBaseException;
	public ClienteVO consultarClientePorNome(String nome) throws EasyPizzaServiceException, EasyPizzaDataBaseException;
	public void excluir(ClienteVO clienteVO) throws EasyPizzaServiceException, EasyPizzaDataBaseException;
}

package br.com.easypizza.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easypizza.dao.ClienteDAO;
import br.com.easypizza.entidade.Cliente;
import br.com.easypizza.exception.EasyPizzaDataBaseException;
import br.com.easypizza.exception.EasyPizzaServiceException;
import br.com.easypizza.service.ClienteService;
import br.com.easypizza.vo.ClienteVO;
import br.com.easypizza.vo.converter.Converter;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired(required=true)
	private ClienteDAO dao;
	
	@Override
	@Transactional
	public void salvarCliente(ClienteVO clienteVO) throws EasyPizzaServiceException, EasyPizzaDataBaseException{
		Cliente cliente = Converter.converterVoParaCliente(clienteVO);
		dao.incluir(cliente);
		
	}

	@Override
	public List<ClienteVO> listarTodosClientes() throws EasyPizzaServiceException, EasyPizzaDataBaseException{
		List<Cliente> listarCliente = dao.listarTodosClientes();
		return Converter.converterListaClienteParaListaVo(listarCliente);
	}

	@Override
	@Transactional
	public void alterarCliente(ClienteVO clienteVO) throws EasyPizzaServiceException, EasyPizzaDataBaseException{
		Cliente cliente = Converter.converterVoParaCliente(clienteVO);
		dao.alterar(cliente);
		
	}

	@Override
	@Transactional
	public void excluirPorCpf(int cpf) throws EasyPizzaServiceException, EasyPizzaDataBaseException{
		dao.excluirPorCpf(cpf);
		
	}

	
	@Override
	public ClienteVO consultarClientePorNome(String nome) throws EasyPizzaServiceException, EasyPizzaDataBaseException{
		Cliente cliente = dao.buscarClientePorNome(nome);
		return Converter.converterClienteParaVO(cliente);
	}

	@Override
	public void excluir(ClienteVO clienteVO) throws EasyPizzaServiceException, EasyPizzaDataBaseException{
		Cliente cliente = Converter.converterVoParaCliente(clienteVO);
		dao.excluir(cliente);
	}
	
}

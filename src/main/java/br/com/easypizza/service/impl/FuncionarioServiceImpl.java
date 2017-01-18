package br.com.easypizza.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.easypizza.dao.FuncionarioDAO;
import br.com.easypizza.entidade.Funcionario;
import br.com.easypizza.exception.EasyPizzaDataBaseException;
import br.com.easypizza.exception.EasyPizzaServiceException;
import br.com.easypizza.service.FuncionarioService;
import br.com.easypizza.vo.FuncionarioVO;
import br.com.easypizza.vo.converter.Converter;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
	
	@Autowired(required=true)
	private FuncionarioDAO dao;
	
	@Override
	@Transactional
	public void salvarFuncionario(FuncionarioVO funcionarioVO) throws EasyPizzaServiceException, EasyPizzaDataBaseException{
		Funcionario funcionario = Converter.converterVoParaFuncionario(funcionarioVO);
		dao.incluir(funcionario);
		
	}

	@Override
	public List<FuncionarioVO> listarTodosFuncionarios() throws EasyPizzaServiceException, EasyPizzaDataBaseException{
		List<Funcionario> listaFuncionario = dao.listarTodosFuncionarios();
		return Converter.converterListaFuncionarioParaListaVo(listaFuncionario);
	}

	@Override
	@Transactional
	public void alterarFuncionario(FuncionarioVO funcionarioVO) throws EasyPizzaServiceException, EasyPizzaDataBaseException{
		Funcionario funcionario = Converter.converterVoParaFuncionario(funcionarioVO);
		dao.alterar(funcionario);
		
	}
	
	@Override
	public FuncionarioVO consultarFuncionarioPorNome(String nome) throws EasyPizzaServiceException, EasyPizzaDataBaseException{
		Funcionario funcionario = dao.buscarFuncionarioPorNome(nome);
		return Converter.converterFuncionarioParaVO(funcionario);
	}


	@Override
	public FuncionarioVO consultarFuncionarioPorMatricula(int matricula) throws EasyPizzaServiceException, EasyPizzaDataBaseException{
		Funcionario funcionario = dao.buscarFuncionarioPorMatricula(matricula);
		return Converter.converterFuncionarioParaVO(funcionario);	
	}

	@Override
	public void excluirFuncionario(FuncionarioVO funcionarioVO) throws EasyPizzaServiceException, EasyPizzaDataBaseException{
		Funcionario funcionario = Converter.converterVoParaFuncionario(funcionarioVO);
		dao.excluir(funcionario);
	}

	@Override
	public void excluirPorMatricula(int matricula) throws EasyPizzaServiceException, EasyPizzaDataBaseException {
		dao.excluirPorMatricula(matricula);
	}
	
	

}

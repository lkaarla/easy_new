package br.com.easypizza.service;

import java.util.List;

import br.com.easypizza.exception.EasyPizzaDataBaseException;
import br.com.easypizza.exception.EasyPizzaServiceException;
import br.com.easypizza.vo.FuncionarioVO;

public interface FuncionarioService {
	
	public void salvarFuncionario(FuncionarioVO funcionarioVO) throws EasyPizzaServiceException, EasyPizzaDataBaseException;
	public List<FuncionarioVO> listarTodosFuncionarios() throws EasyPizzaServiceException, EasyPizzaDataBaseException;
	public void alterarFuncionario(FuncionarioVO funcionarioVO) throws EasyPizzaServiceException, EasyPizzaDataBaseException;
	public void excluirFuncionario(FuncionarioVO funcionarioVO) throws EasyPizzaServiceException, EasyPizzaDataBaseException;
	public FuncionarioVO consultarFuncionarioPorMatricula(int matricula) throws EasyPizzaServiceException, EasyPizzaDataBaseException;
	public FuncionarioVO consultarFuncionarioPorNome(String nome) throws EasyPizzaServiceException, EasyPizzaDataBaseException;
	public void excluirPorMatricula(int matricula) throws EasyPizzaServiceException, EasyPizzaDataBaseException;

}

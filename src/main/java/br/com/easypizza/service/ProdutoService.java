package br.com.easypizza.service;

import java.util.List;

import br.com.easypizza.exception.EasyPizzaDataBaseException;
import br.com.easypizza.exception.EasyPizzaServiceException;
import br.com.easypizza.vo.ProdutoVO;


public interface ProdutoService {


	public void salvarProduto(ProdutoVO produtoVO) throws EasyPizzaServiceException, EasyPizzaDataBaseException;
	public void excluirProduto(ProdutoVO produtoVO) throws EasyPizzaServiceException, EasyPizzaDataBaseException;
	public void alterarProduto(ProdutoVO produtoVO) throws EasyPizzaServiceException, EasyPizzaDataBaseException;
	public List<ProdutoVO> listarTodosProdutos() throws EasyPizzaServiceException, EasyPizzaDataBaseException;
	public ProdutoVO consultarProdutoPorId(int idProduto) throws EasyPizzaServiceException, EasyPizzaDataBaseException;
	public void excluirPorId(int idProduto) throws EasyPizzaServiceException, EasyPizzaDataBaseException;
}


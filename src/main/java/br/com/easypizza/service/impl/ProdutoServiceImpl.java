

package br.com.easypizza.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easypizza.dao.ProdutoDAO;
import br.com.easypizza.entidade.Produto;
import br.com.easypizza.exception.EasyPizzaDataBaseException;
import br.com.easypizza.exception.EasyPizzaServiceException;
import br.com.easypizza.service.ProdutoService;
import br.com.easypizza.vo.ProdutoVO;
import br.com.easypizza.vo.converter.Converter;

@Service
public class ProdutoServiceImpl implements ProdutoService{
	

	@Autowired(required=true)
	private ProdutoDAO dao;

	@Override
	@Transactional
	public void salvarProduto(ProdutoVO produtoVO) throws EasyPizzaServiceException, EasyPizzaDataBaseException{
		Produto produto = Converter.converterVoParaProduto(produtoVO);
		dao.incluir(produto);
	}
	
	@Override
	@Transactional
	public void excluirPorId(int idProduto) throws EasyPizzaServiceException, EasyPizzaDataBaseException{
		dao.excluirPorId(idProduto);
		
	}

	@Override
	@Transactional
	public void alterarProduto(ProdutoVO produtoVO) throws EasyPizzaServiceException, EasyPizzaDataBaseException{
		Produto produto = Converter.converterVoParaProduto(produtoVO);
		dao.alterar(produto);
		
	}

	@Override
	public List<ProdutoVO> listarTodosProdutos() throws EasyPizzaServiceException, EasyPizzaDataBaseException{
		List<Produto> listaProduto = dao.listarTodosProdutos();
		return Converter.converterListaProdutoParaListaVo(listaProduto);
	}

	@Override
	public ProdutoVO consultarProdutoPorId(int idProduto) throws EasyPizzaServiceException, EasyPizzaDataBaseException{
		Produto produto = dao.buscarProdutoPorId(idProduto);
		return Converter.converterProdutoParaVO(produto);
	}

	@Override
	public void excluirProduto(ProdutoVO produtoVO) throws EasyPizzaServiceException, EasyPizzaDataBaseException{
		Produto produto = Converter.converterVoParaProduto(produtoVO);
		dao.excluir(produto);
	}


}

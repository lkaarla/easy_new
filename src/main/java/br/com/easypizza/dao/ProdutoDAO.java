package br.com.easypizza.dao;

import java.util.List;

import br.com.easypizza.entidade.Produto;
import br.com.easypizza.exception.EasyPizzaDataBaseException;

public interface ProdutoDAO {
	

	public void incluir(Produto produto) throws EasyPizzaDataBaseException;
	public void excluirPorId (int idProduto) throws EasyPizzaDataBaseException;
	public void excluir (Produto produto) throws EasyPizzaDataBaseException;
	public void alterar(Produto produto) throws EasyPizzaDataBaseException;
	public Produto buscarProdutoPorId(int id) throws EasyPizzaDataBaseException; 
	public List<Produto> listarTodosProdutos() throws EasyPizzaDataBaseException;

}

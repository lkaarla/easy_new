package br.com.easypizza.dao;

import br.com.easypizza.entidade.FormaPagamento;
import br.com.easypizza.exception.EasyPizzaDataBaseException;

public interface FormaPagamentoDAO {

	public void incluir(FormaPagamento formaPagamento) throws EasyPizzaDataBaseException;
	public void excluirPorId (int idFormaPagamento) throws EasyPizzaDataBaseException;
	public void excluir (FormaPagamento formaPagamento) throws EasyPizzaDataBaseException;
	public void alterar(FormaPagamento formaPagamento) throws EasyPizzaDataBaseException;
	public FormaPagamento buscarFormaPagamentoPorId(int id);
	
}

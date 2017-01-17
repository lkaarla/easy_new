package br.com.easypizza.dao;

import br.com.easypizza.entidade.Pedido;
import br.com.easypizza.exception.EasyPizzaDataBaseException;

public interface PedidoDAO {
	
	public void incluir(Pedido cp) throws EasyPizzaDataBaseException;
	public void excluirPorId (int idPedido) throws EasyPizzaDataBaseException;
	public void excluir (Pedido cp) throws EasyPizzaDataBaseException;
	public void alterar(Pedido cp) throws EasyPizzaDataBaseException;
	public Pedido buscarPedidoPorId(int idPedido); 
	

}

package br.com.easypizza.dao;

import br.com.easypizza.entidade.PedidoItem;
import br.com.easypizza.exception.EasyPizzaDataBaseException;

public interface PedidoItemDAO {
	
	public void incluir(PedidoItem cpi) throws EasyPizzaDataBaseException;
	public void excluir (PedidoItem cpi) throws EasyPizzaDataBaseException;
	public void alterar(PedidoItem cpi) throws EasyPizzaDataBaseException;
	public PedidoItem buscarPedidoPorId(int idPedidoItem); 

}

package br.com.easypizza.service;

import java.util.List;

import br.com.easypizza.exception.EasyPizzaDataBaseException;
import br.com.easypizza.exception.EasyPizzaServiceException;
import br.com.easypizza.vo.PedidoItemVO;



public interface PedidoItemService {

	public void salvarPedidoItem(PedidoItemVO pedidoItemVO) throws EasyPizzaServiceException, EasyPizzaDataBaseException;
	public PedidoItemVO consultarPedidoItemPorId(int idPedidoItem) throws EasyPizzaServiceException, EasyPizzaDataBaseException;
	public List<PedidoItemVO> listarTodasPedidoItem() throws EasyPizzaServiceException, EasyPizzaDataBaseException;
	void excluirPedidoItem(PedidoItemVO cpiVO) throws EasyPizzaServiceException, EasyPizzaDataBaseException;
}

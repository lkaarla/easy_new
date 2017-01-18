package br.com.easypizza.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easypizza.dao.PedidoItemDAO;
import br.com.easypizza.entidade.PedidoItem;
import br.com.easypizza.exception.EasyPizzaDataBaseException;
import br.com.easypizza.exception.EasyPizzaServiceException;
import br.com.easypizza.service.PedidoItemService;
import br.com.easypizza.vo.PedidoItemVO;
import br.com.easypizza.vo.converter.Converter;

@Service
public class PedidoItemServiceImpl implements PedidoItemService {
	
	@Autowired(required=true)
	private PedidoItemDAO dao;

	@Override
	@Transactional
	public void salvarPedidoItem(PedidoItemVO pedidoItemVO) throws EasyPizzaServiceException, EasyPizzaDataBaseException{
		PedidoItem pedidoItem  = Converter.converterVoParaPedidoItem(pedidoItemVO);
		dao.incluir(pedidoItem);
		
	}

	@Override
	public PedidoItemVO consultarPedidoItemPorId(int idPedidoItem) throws EasyPizzaServiceException, EasyPizzaDataBaseException{
		PedidoItem pedidoItem = dao.buscarPedidoPorId(idPedidoItem);
		return Converter.converterPedidoItemParaVO(pedidoItem);
	}

	@Override
	public List<PedidoItemVO> listarTodasPedidoItem() throws EasyPizzaServiceException, EasyPizzaDataBaseException{
		List<PedidoItem> listaPedidoItem = dao.listarTodosPedidoItem();
		return Converter.converterListaPedidoItemParaListaVo(listaPedidoItem);
	}


	@Override
	public void excluirPedidoItem(PedidoItemVO cpiVO) throws EasyPizzaServiceException, EasyPizzaDataBaseException{
		PedidoItem pedidoItem = Converter.converterVoParaPedidoItem(cpiVO);
		dao.excluir(pedidoItem);
	}
	
	

}

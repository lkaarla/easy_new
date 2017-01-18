package br.com.easypizza.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.easypizza.exception.EasyPizzaDataBaseException;
import br.com.easypizza.exception.EasyPizzaServiceException;
import br.com.easypizza.service.PedidoItemService;
import br.com.easypizza.service.ProdutoService;
import br.com.easypizza.vo.PedidoItemVO;
import br.com.easypizza.vo.ProdutoVO;


@ManagedBean(name = "MBProduto")
@SessionScoped
public class ProdutoController extends AbstractController{

	private static final String TELA_LISTA_TODOS = null;
	private static final String TELA_CADASTRAR_PRODUTOS = null;
	public static String TELA_CADASTRAR_PRODUTO = "/produto/cadastrar_produto.xhtml";
	public static String TELA_LISTAR_TODOS = "/produto/listar_todos_produtos.xhtml";
	
		@Autowired
		private ProdutoService produtoService;

		//private List<ProdutoVO> listaProdutoVO;
		
		public ProdutoService getProdutoService() {
			return produtoService;
		}


		public void setProdutoService(ProdutoService produtoService) {
			this.produtoService = produtoService;
		}


		public List<PedidoItemVO> getPedidoItemService() {
			return pedidoItemService;
		}


		public void setPedidoItemService(List<PedidoItemVO> pedidoItemService) {
			this.pedidoItemService = pedidoItemService;
		}


		public List<ProdutoVO> getListaExclusao() {
			return listaExclusao;
		}


		public void setListaExclusao(List<ProdutoVO> listaExclusao) {
			this.listaExclusao = listaExclusao;
		}


		public List<PedidoItemVO> getListaPedidoItemVO() {
			return listaPedidoItemVO;
		}


		public void setListaPedidoItemVO(List<PedidoItemVO> listaPedidoItemVO) {
			this.listaPedidoItemVO = listaPedidoItemVO;
		}


		public PedidoItemVO getPedidoItemVO() {
			return pedidoItemVO;
		}


		public void setPedidoItemVO(PedidoItemVO pedidoItemVO) {
			this.pedidoItemVO = pedidoItemVO;
		}


		public void setListaProdutoVO(List<ProdutoVO> listaProdutoVO) {
			this.listaProdutoVO = listaProdutoVO;
		}

		@Autowired
		private List<PedidoItemVO> pedidoItemService;

		private List<ProdutoVO> listaExclusao = new ArrayList<ProdutoVO>();
		private List<PedidoItemVO> listaPedidoItemVO;
		private List<ProdutoVO> listaProdutoVO;
		private ProdutoVO produto = new ProdutoVO();
		private PedidoItemVO pedidoItemVO = new PedidoItemVO();
		
		@PostConstruct
		private void init()  throws EasyPizzaServiceException, EasyPizzaDataBaseException {
			super.getConfigSpring();
			this.listaPedidoItemVO = ((PedidoItemService) pedidoItemService).listarTodasPedidoItem();
		}
		

		public ProdutoVO getProduto() {
			return produto;
		}

		public void setProduto(ProdutoVO employee) {
			this.produto = produto;
		}

		public String salvar()  throws EasyPizzaServiceException, EasyPizzaDataBaseException {
			// Calling Business Service
			produtoService.salvarProduto(produto);
			// Add message
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Produto gravado com sucesso!"));

			this.limparCampos();
			return "";
		}
		
		public String excluir(ProdutoVO produtoVO, int idProduto) throws EasyPizzaServiceException, EasyPizzaDataBaseException {
			if(produtoVO != null && produtoVO.getIdProduto() != 0){
				this.produtoService.excluirPorId(produtoVO.getIdProduto());		
			}
			this.listaProdutoVO = produtoService.listarTodosProdutos();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Produto excluido com sucesso!"));
			return "";
		}

		/**
		 * @return the listaClienteVO
		 */
		public List<ProdutoVO> getListaProdutoVO() {
			return listaProdutoVO;
		}

		private void limparCampos()  throws EasyPizzaServiceException, EasyPizzaDataBaseException {
			this.getProduto().setDescricao(null);
			this.getProduto().setPreco(null);
			
		}
		
		public String chamarTelaListarTodosProduto() throws EasyPizzaServiceException, EasyPizzaDataBaseException {
			listaProdutoVO = produtoService.listarTodosProdutos();
			return TELA_LISTA_TODOS;
		}
		
		public String chamarTelaCadastro(){
			return TELA_CADASTRAR_PRODUTOS;
		}
}

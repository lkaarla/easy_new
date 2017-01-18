package br.com.easypizza.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.easypizza.exception.EasyPizzaDataBaseException;
import br.com.easypizza.exception.EasyPizzaServiceException;
import br.com.easypizza.service.ClienteService;
import br.com.easypizza.vo.ClienteVO;


@ManagedBean(name = "MBCliente")
@SessionScoped
public class ClienteController extends AbstractController{
	
	public static String TELA_LISTA_TODOS = "/cliente/listar_todos_clientes.xhtml";
	public static String TELA_CADASTRAR_CLIENTE = "/cliente/cadastrar_cliente.xhtml";
	
	@Autowired
	private ClienteService clienteService;

	private List<ClienteVO> listaClienteVO;

	@PostConstruct
	private void init() {
		super.getConfigSpring();
	}

	private ClienteVO cliente = new ClienteVO();

	public ClienteVO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVO employee) {
		this.cliente = cliente;
	}

	public String salvar() throws EasyPizzaServiceException, EasyPizzaDataBaseException {
		// Calling Business Service
		clienteService.salvarCliente(cliente);
		// Add message
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Cliente gravado com sucesso!"));

		this.limparCampos();
		return "";
	}
	
	public String excluir(ClienteVO clienteVO) throws EasyPizzaServiceException, EasyPizzaDataBaseException {
		if(clienteVO != null && clienteVO.getCpf() != 0){
			this.clienteService.excluirPorCpf(clienteVO.getCpf());			
		}
		this.listaClienteVO = clienteService.listarTodosClientes();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Cliente excluido com sucesso!"));
		return "";
	}
	

	/**
	 * @return the listaClienteVO
	 */
	public List<ClienteVO> getListaClienteVO() throws EasyPizzaServiceException, EasyPizzaDataBaseException  {
		return listaClienteVO;
	}

	private void limparCampos() {
		this.getCliente().setNome(null);
		this.getCliente().setCidade(null);
		this.getCliente().setBairro(null);
		this.getCliente().setEndereco(null);
		this.getCliente().setComplemento(null);
		this.getCliente().setContatoUm(null);
		this.getCliente().setContatoDois(null);
		this.getCliente().setEmail(null);
	}
	
	public String chamarTelaListarTodosClientes() throws EasyPizzaServiceException, EasyPizzaDataBaseException {
		listaClienteVO = clienteService.listarTodosClientes();
		return TELA_LISTA_TODOS;
	}
	
	public String chamarTelaCadastro() throws EasyPizzaServiceException, EasyPizzaDataBaseException {
		return TELA_CADASTRAR_CLIENTE;
	}


}

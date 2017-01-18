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
import br.com.easypizza.service.FuncionarioService;
import br.com.easypizza.vo.FuncionarioVO;
import br.com.easypizza.vo.ProdutoVO;

@ManagedBean(name = "MBFuncionario")
@SessionScoped
public class FuncionarioController extends AbstractController{

	public static String TELA_LISTA_TODOS = "/funcionario/listar_todos_funcionarios.xhtml";
	public static String TELA_CADASTRAR_FUNCIONARIOS = "/funcionario/cadastrar_funcionario.xhtml";
	
	@Autowired
	private FuncionarioService funcionarioService;

	private List<FuncionarioVO> listaFuncionarioVO;

	@PostConstruct
	private void init() {
		super.getConfigSpring();
		
	}
	
	private FuncionarioVO funcionario = new FuncionarioVO();

	public FuncionarioVO getFuncionario() throws EasyPizzaServiceException, EasyPizzaDataBaseException {
		return funcionario;
	}

	public void setFuncionario(FuncionarioVO employee){
		this.funcionario = funcionario;
	}

	public String salvar() throws EasyPizzaServiceException, EasyPizzaDataBaseException {
		// Calling Business Service
		funcionarioService.salvarFuncionario(funcionario);
		// Add message
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Funcionario gravado com sucesso!"));

		this.limparCampos();
		return "";
	}
	
	public String excluir(FuncionarioVO funcionarioVO, int matricula) throws EasyPizzaServiceException, EasyPizzaDataBaseException {
		if(funcionarioVO != null && funcionarioVO.getMatricula() != 0){
			this.funcionarioService.excluirPorMatricula(funcionarioVO.getMatricula());			
		}
		this.listaFuncionarioVO = funcionarioService.listarTodosFuncionarios();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Funcionario excluido com sucesso!"));
		return "";
	}

	/**
	 * @return the listaClienteVO
	 */
	public List<FuncionarioVO> getListaFuncionarioVO() {
		return listaFuncionarioVO;
	}

	private void limparCampos() throws EasyPizzaServiceException, EasyPizzaDataBaseException {
		this.getFuncionario().setNome(null);
		this.getFuncionario().setCidade(null);
		this.getFuncionario().setBairro(null);
		this.getFuncionario().setEndereco(null);
		this.getFuncionario().setComplemento(null);
		this.getFuncionario().setContatoUm(null);
		this.getFuncionario().setContatoDois(null);
		this.getFuncionario().setEmail(null);
		this.getFuncionario().setEmail(null);
		this.getFuncionario().setNome(null);
	}
	
	public String chamarTelaListarTodosFuncionario() throws EasyPizzaServiceException, EasyPizzaDataBaseException {
		listaFuncionarioVO = funcionarioService.listarTodosFuncionarios();
		return TELA_LISTA_TODOS;
	}
	
	public String chamarTelaCadastro() throws EasyPizzaServiceException, EasyPizzaDataBaseException {
		return TELA_CADASTRAR_FUNCIONARIOS;
	}
}

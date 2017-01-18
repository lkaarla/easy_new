package br.com.easypizza.vo.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.easypizza.entidade.Cliente;
import br.com.easypizza.entidade.Funcionario;
import br.com.easypizza.entidade.Login;
import br.com.easypizza.entidade.PedidoItem;
import br.com.easypizza.entidade.Produto;
import br.com.easypizza.vo.ClienteVO;
import br.com.easypizza.vo.FuncionarioVO;
import br.com.easypizza.vo.LoginVO;
import br.com.easypizza.vo.PedidoItemVO;
import br.com.easypizza.vo.ProdutoVO;



public class Converter {

	/**
	 * Converter uma classe VO para uma entidade Login
	 * VO --> Login
	 * @param LoginVO
	 * @return
	 */
	
	public static Login converterVoParaLogin(LoginVO loginVO){
		Login login = new Login();
		
		login.setLogin(loginVO.getLogin());
		login.setSenha(loginVO.getSenha());
		return login;
	}
	/**
	 * Converter uma classe VO para uma entidade Cliente
	 * VO --> Cliente
	 * @param clienteVO
	 * @return
	 */

	public static Cliente converterVoParaCliente(ClienteVO clienteVO){
		
		Cliente cliente = new Cliente();
		
		
		cliente.setCpf(clienteVO.getCpf());
		cliente.setNome(clienteVO.getNome());
		cliente.setCidade(clienteVO.getCidade());
		cliente.setBairro(clienteVO.getBairro());
		cliente.setEndereco(clienteVO.getEndereco());
		cliente.setComplemento(clienteVO.getComplemento());
		cliente.setContatoUm(clienteVO.getContatoUm());
		cliente.setContatoDois(clienteVO.getContatoDois());
		cliente.setEmail(clienteVO.getEmail());
		return cliente;
		
	}


	/**
	 * Converter uma entidade em uma classe vo cliente
	 * Cliente --> VO
	 * @param cliente
	 * @return
	 */
	public static ClienteVO converterClienteParaVO(Cliente cliente){
		ClienteVO clienteVo = new ClienteVO();
		clienteVo.setCpf(cliente.getCpf());
		clienteVo.setNome(cliente.getNome());
		clienteVo.setCidade(cliente.getCidade());
		clienteVo.setBairro(cliente.getBairro());
		clienteVo.setEndereco(cliente.getEndereco());
		clienteVo.setComplemento(cliente.getComplemento());
		clienteVo.setContatoUm(cliente.getContatoUm());
		clienteVo.setContatoDois(cliente.getContatoDois());
		clienteVo.setEmail(cliente.getEmail());
		
		return clienteVo;
	}
	
	/**
	 * Converter uma lista de entidade cliente em uma lista de entidade vo
	 * 
	 * @param listaEntidade
	 * @return
	 */
	public static List<ClienteVO> converterListaClienteParaListaVo(List<Cliente> listaEntidade){
		
		List<ClienteVO> listClienteVO = new ArrayList<ClienteVO>();
		if(listaEntidade != null && !listaEntidade.isEmpty()){
			for(Cliente cliente : listaEntidade){
				ClienteVO clienteVO = converterClienteParaVO(cliente);
				listClienteVO.add(clienteVO);
			}
		}
		return listClienteVO;
	}
	
	
	
	public static Funcionario converterVoParaFuncionario(FuncionarioVO funcionarioVO){
		Funcionario funcionario = new Funcionario();
		
		funcionario.setNome(funcionarioVO.getNome());
		funcionario.setCidade(funcionarioVO.getCidade());
		funcionario.setBairro(funcionarioVO.getBairro());
		funcionario.setEndereco(funcionarioVO.getEndereco());
		funcionario.setComplemento(funcionarioVO.getComplemento());
		funcionario.setContatoUm(funcionarioVO.getContatoUm());
		funcionario.setContatoDois(funcionarioVO.getContatoDois());
		funcionario.setEmail(funcionarioVO.getEmail());
		return funcionario;
	}
	
	/**
	 * Converter uma entidade em uma classe vo cliente
	 * Cliente --> VO
	 * @param cliente
	 * @return
	 */
	public static FuncionarioVO converterFuncionarioParaVO(Funcionario funcionario){
		FuncionarioVO funcionarioVo = new FuncionarioVO();
		funcionarioVo.setMatricula(funcionario.getMatricula());
		funcionarioVo.setNome(funcionario.getNome());
		funcionarioVo.setCidade(funcionario.getCidade());
		funcionarioVo.setBairro(funcionario.getBairro());
		funcionarioVo.setEndereco(funcionario.getEndereco());
		funcionarioVo.setComplemento(funcionario.getComplemento());
		funcionarioVo.setContatoUm(funcionario.getContatoUm());
		funcionarioVo.setContatoDois(funcionario.getContatoDois());
		funcionarioVo.setEmail(funcionario.getEmail());
		
		return funcionarioVo;
	}
	
	public static PedidoItemVO converterPedidoItemParaVO(PedidoItem pedidoItem){
		PedidoItemVO pedidoItemVO = new PedidoItemVO();
		
		pedidoItemVO.setIdPedidoItem(pedidoItem.getIdPedidoItem());
		return pedidoItemVO;
	}
	
	
	/**
	 * Converter uma lista de entidade cliente em uma lista de entidade vo
	 * 
	 * @param listaEntidade
	 * @return
	 */
	public static List<FuncionarioVO> converterListaFuncionarioParaListaVo(List<Funcionario> listaEntidade){
		
		List<FuncionarioVO> listFuncionarioVO = new ArrayList<FuncionarioVO>();
		if(listaEntidade != null && !listaEntidade.isEmpty()){
			for(Funcionario funcionario : listaEntidade){
				FuncionarioVO funcionarioVO = converterFuncionarioParaVO(funcionario);
				listFuncionarioVO.add(funcionarioVO);
			}
		}
		return listFuncionarioVO;
	}
	
	
	
	
	/**
	 * Converter um classe vo em uma entidade Produto
	 * @param produtoVO
	 * @return
	 */
	public static Produto converterVoParaProduto(ProdutoVO produtoVO){
		Produto produto = new Produto();
		//Produto produto = converterVoParaProduto(produtoVO.getProdutoVO());
		
		produto.setIdProduto(produtoVO.getIdProduto());
		produto.setDescricao(produtoVO.getDescricao());
		produto.setPreco(produtoVO.getPreco());
		return produto;
	}
	
	/**
	 * Converter uma entidade Produto em uma classe VO
	 * @param produto
	 * @return
	 */
	public static ProdutoVO converterProdutoParaVO(Produto produto){
		ProdutoVO produtoVO = new ProdutoVO();
		//CategoriaVO categoriaVO = converterCategoriaParaVO(produto.getCategoria());
		
		produtoVO.setIdProduto(produto.getIdProduto());
		produtoVO.setDescricao(produto.getDescricao());
		produtoVO.setPreco(produto.getPreco());
		return produtoVO;
	}
	
	/**
	 * Converter uma lista de entidade Produto em uma lista de Produto vo
	 * @param listaEntidade
	 * @return
	 */
	public static List<ProdutoVO> converterListaProdutoParaListaVo(List<Produto> listaEntidade){
		
		List<ProdutoVO> listProdutoVO = new ArrayList<ProdutoVO>();
		if(listaEntidade != null && !listaEntidade.isEmpty()){
			for(Produto produto : listaEntidade){
				ProdutoVO produtoVO = converterProdutoParaVO(produto);
				listProdutoVO.add(produtoVO);
			}
		}
		return listProdutoVO;
	}
	

	
	public static List<PedidoItemVO> converterListaPedidoItemParaListaVo(List<PedidoItem> listaEntidade){
		
		List<PedidoItemVO> listPedidoItemVO = new ArrayList<PedidoItemVO>();
		if(listaEntidade != null && !listaEntidade.isEmpty()){
			for(PedidoItem pedidoItem : listaEntidade){
				PedidoItemVO pedidoItemVO = converterPedidoItemParaVO(pedidoItem);
				listPedidoItemVO.add(pedidoItemVO);
			}
		}
		return listPedidoItemVO;
	}

	public static PedidoItem converterVoParaPedidoItem(PedidoItemVO pedidoItemVO) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

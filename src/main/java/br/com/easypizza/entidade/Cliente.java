package br.com.easypizza.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="cad_cliente")
public class Cliente extends Pessoa{
	
	@Column (name = "cpfCliente")
	private int cpf;
	
	@Column (name = "senha")
	private String senha;
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@ManyToOne
	@JoinColumn(name="id_login")
	private Login login;

	@OneToMany(mappedBy="cadCliente")
	private List<Pedido> cadPedidos;

	
	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	public Login getLogin() {
		return this.login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<Pedido> getCadPedidos() {
		return this.cadPedidos;
	}

	public void setCadPedidos(List<Pedido> cadPedidos) {
		this.cadPedidos = cadPedidos;
	}



}
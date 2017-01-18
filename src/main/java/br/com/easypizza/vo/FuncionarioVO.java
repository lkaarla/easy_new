package br.com.easypizza.vo;

import java.io.Serializable;

public class FuncionarioVO implements Serializable{

private static final long serialVersionUID = 1L;
	
	private int matricula;
	private String nome;
	private String cidade;
	private String bairro;
	private String endereco;
	private String complemento;
	private String contatoUm;
	private String contatoDois;
	private String Email;

	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getContatoUm() {
		return contatoUm;
	}
	public void setContatoUm(String contatoUm) {
		this.contatoUm = contatoUm;
	}
	public String getContatoDois() {
		return contatoDois;
	}
	public void setContatoDois(String contatoDois) {
		this.contatoDois = contatoDois;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
	
}

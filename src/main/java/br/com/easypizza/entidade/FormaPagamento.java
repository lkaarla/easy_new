package br.com.easypizza.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="cad_forma_pagamento")
public class FormaPagamento{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_forma")
	private int idForma;

	@Column(name="desc_forma")
	private String descForma;

	@OneToMany(mappedBy="cadFormaPagamento")
	private List<Pedido> cadPedidos;

	public FormaPagamento() {
	}

	public int getIdForma() {
		return this.idForma;
	}

	public void setIdForma(int idForma) {
		this.idForma = idForma;
	}

	public String getDescForma() {
		return this.descForma;
	}

	public void setDescForma(String descForma) {
		this.descForma = descForma;
	}

	public List<Pedido> getCadPedidos() {
		return this.cadPedidos;
	}

	public void setCadPedidos(List<Pedido> cadPedidos) {
		this.cadPedidos = cadPedidos;
	}



}
package br.com.easypizza.entidade;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="cad_pedido_item")
public class PedidoItem {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido_item")
	private int idPedidoItem;

	@Column(name="preco_unit")
	private BigDecimal precoUnit;

	@Column(name="quant_vendida")
	private int quantVendida;

	@ManyToOne
	@JoinColumn(name="id_pedido", insertable=false, updatable=false)
	private Pedido cadPedido;

	@ManyToOne
	@JoinColumn(name="id_produto", insertable=false, updatable=false)
	private Produto cadProduto;

	public PedidoItem() {
	}


	public int getIdPedidoItem() {
		return idPedidoItem;
	}


	public BigDecimal getPrecoUnit() {
		return this.precoUnit;
	}

	public void setPrecoUnit(BigDecimal precoUnit) {
		this.precoUnit = precoUnit;
	}

	public int getQuantVendida() {
		return this.quantVendida;
	}

	public void setQuantVendida(int quantVendida) {
		this.quantVendida = quantVendida;
	}

	public Pedido getCadPedido() {
		return this.cadPedido;
	}

	public void setCadPedido(Pedido cadPedido) {
		this.cadPedido = cadPedido;
	}

	public Produto getCadProduto() {
		return this.cadProduto;
	}

	public void setCadProduto(Produto cadProduto) {
		this.cadProduto = cadProduto;
	}

}
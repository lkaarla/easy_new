package br.com.easypizza.entidade;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="cad_pedido")
public class Pedido{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pedido")
	private int idPedido;

	private BigDecimal troco;

	@Column(name="val_pedido")
	private BigDecimal valPedido;

	@Column(name="valor_pago")
	private BigDecimal valorPago;

	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cadCliente;

	@ManyToOne
	@JoinColumn(name="id_forma")
	private FormaPagamento cadFormaPagamento;

	@OneToMany(mappedBy="cadPedido", cascade = CascadeType.ALL)
	private List<PedidoItem> cadPedidoItems;

	public Pedido() {
	}

	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public BigDecimal getTroco() {
		return this.troco;
	}

	public void setTroco(BigDecimal troco) {
		this.troco = troco;
	}

	public BigDecimal getValPedido() {
		return this.valPedido;
	}

	public void setValPedido(BigDecimal valPedido) {
		this.valPedido = valPedido;
	}

	public BigDecimal getValorPago() {
		return this.valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public Cliente getCadCliente() {
		return this.cadCliente;
	}

	public void setCadCliente(Cliente cadCliente) {
		this.cadCliente = cadCliente;
	}

	public FormaPagamento getCadFormaPagamento() {
		return this.cadFormaPagamento;
	}

	public void setCadFormaPagamento(FormaPagamento cadFormaPagamento) {
		this.cadFormaPagamento = cadFormaPagamento;
	}

	public List<PedidoItem> getCadPedidoItems() {
		return this.cadPedidoItems;
	}

	public void setCadPedidoItems(List<PedidoItem> cadPedidoItems) {
		this.cadPedidoItems = cadPedidoItems;
	}



}
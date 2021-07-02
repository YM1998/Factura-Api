package co.com.system.invoice.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="factura")
public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_factura")
	private Long idFactura;

	private double costo;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;
	private double iva;
	private double precio;
	private double subtotal;
	private double total;

	@OneToMany(mappedBy="factura")
	private List<InvoiceDetail> detalleFacturas;


	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Person cliente;

	@ManyToOne
	@JoinColumn(name="id_vendedor")
	private Person vendedor;


}
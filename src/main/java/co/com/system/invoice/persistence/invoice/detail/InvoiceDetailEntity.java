package co.com.system.invoice.persistence.invoice.detail;

import co.com.system.invoice.persistence.product.ProductEntity;
import co.com.system.invoice.persistence.invoice.InvoiceEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the detalle_factura database table.
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="invoice_detail")
public class InvoiceDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
	private Long  id;

	@Column  private Integer amount;
    @Column private double cost;
    @Column private double iva;
    @Column private double price;
    @Column private double subtotal;
    @Column private double total;
	@ManyToOne
	@JoinColumn(name="invoice_id")
	private InvoiceEntity invoice;
	@ManyToOne
	@JoinColumn(name="product_id")
	private ProductEntity product;
}



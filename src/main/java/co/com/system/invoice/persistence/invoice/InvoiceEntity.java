package co.com.system.invoice.persistence.invoice;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import co.com.system.invoice.persistence.invoice.detail.InvoiceDetailEntity;
import co.com.system.invoice.persistence.person.PersonEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="invoice")
public class InvoiceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column private Long id;
	@Column private double cost;
	@Column private LocalDate createdAt;
	@Column private double iva;
	@Column private double subtotal;
	@Column private double total;

	@OneToMany(mappedBy="invoice",fetch = FetchType.LAZY)
	private List<InvoiceDetailEntity> invoiceDetailEntities;


	@ManyToOne
	@JoinColumn(name="client_id")
	private PersonEntity client;

	@ManyToOne
	@JoinColumn(name="seller_id")
	private PersonEntity seller;


}
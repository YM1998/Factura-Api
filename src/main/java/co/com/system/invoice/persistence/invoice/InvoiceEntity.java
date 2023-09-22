package co.com.system.invoice.persistence.invoice;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;


import co.com.system.invoice.persistence.client.ClientEntity;
import co.com.system.invoice.persistence.invoice.detail.InvoiceDetailEntity;
import co.com.system.invoice.persistence.payment.type.PaymentTypeEntity;
import co.com.system.invoice.persistence.user.UserEntity;
import co.com.system.invoice.persistence.sellingpoint.SellingPointEntity;
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
	@Column private Double cost;
	@Column private LocalDate createdAt;
	@Column private Double iva;
	@Column private Double subtotal;
	@Column private Double total;


	@OneToMany(mappedBy="invoice", cascade = CascadeType.ALL)
	private List<InvoiceDetailEntity> invoiceDetailEntities;


	@ManyToOne
	@JoinColumn(name="client_id")
	private ClientEntity client;

	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity user;

	@ManyToOne
	@JoinColumn(name="selling_point_id")
	private SellingPointEntity sellingPoint;

	@ManyToOne
	@JoinColumn(name="payment_type_id")
	private PaymentTypeEntity paymentType;


}
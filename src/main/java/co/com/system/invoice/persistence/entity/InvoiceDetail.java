package co.com.system.invoice.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the detalle_factura database table.
 *
 */
/*@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="detalle_factura")*/
public class InvoiceDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_detalle_factura")
	private Integer idDetalleFactura;

	@Temporal(TemporalType.DATE)
	private Date cantidad;

	private double costo;

	private double iva;

	private double precio;

	private double subtotal;

	private double total;


	@ManyToOne
	@JoinColumn(name="id_factura")
	private Invoice invoice;

	@ManyToOne
	@JoinColumn(name="id_producto")
	private Product product;


	static int[] myArray= {1, 2, 9,
                           2, 5, 3,
                           5, 1, 5};

    public static void main(String[] args) {

        int[] myArrayResultado= new int[3];
        Integer res=null;

        for (int i = 0; i < 9; i=i+3) {
            int resInt = myArray[i] + myArray[i+1]+ myArray[i+2];
            if(res==null){
                res=resInt;
                myArrayResultado[0]=i+1;
                myArrayResultado[1]=i+2;
                myArrayResultado[2]=i+3;
            }else if(res<resInt) {
                myArrayResultado[0]=i+1;
                myArrayResultado[1]=i+2;
                myArrayResultado[2]=i+3;
            }
        }
        System.out.println(myArrayResultado[0]+" "+myArrayResultado[1]+" "+myArrayResultado[2]);
    }
}



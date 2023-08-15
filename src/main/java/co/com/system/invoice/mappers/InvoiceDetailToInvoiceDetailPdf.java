package co.com.system.invoice.mappers;

import co.com.system.invoice.model.InvoiceDetail;
import co.com.system.invoice.model.InvoiceDetailPdf;
import org.springframework.stereotype.Component;

@Component
public class InvoiceDetailToInvoiceDetailPdf {


    public InvoiceDetailPdf toInvoiceDetailPdf(InvoiceDetail invoiceDetail) {
        return InvoiceDetailPdf.builder()
                .subtotal(String.format("%,d", invoiceDetail.getSubtotal().longValue()))
                .id(invoiceDetail.getId())
                .iva(String.format("%,d", invoiceDetail.getIva().longValue()))
                .total((String.format("%,d", invoiceDetail.getTotal().longValue())))
                .price(String.format("%,d", invoiceDetail.getPrice().longValue()))
                .amount(invoiceDetail.getAmount())
                .productName(invoiceDetail.getProductName())
                .build();

    }

}

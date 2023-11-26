package co.com.system.invoice.mappers;

import co.com.system.invoice.constants.GeneralConstans;
import co.com.system.invoice.model.InvoiceDetail;
import co.com.system.invoice.model.InvoiceDetailPdf;
import org.springframework.stereotype.Component;

@Component
public class InvoiceDetailToInvoiceDetailPdf {


    public InvoiceDetailPdf toInvoiceDetailPdf(InvoiceDetail invoiceDetail) {
        return InvoiceDetailPdf.builder()
                .subtotal(String.format(GeneralConstans.FORMAT_STR, invoiceDetail.getSubtotal().longValue()))
                .id(invoiceDetail.getId())
                .iva(String.format(GeneralConstans.FORMAT_STR, invoiceDetail.getIva().longValue()))
                .total((String.format(GeneralConstans.FORMAT_STR, invoiceDetail.getTotal().longValue())))
                .price(String.format(GeneralConstans.FORMAT_STR, invoiceDetail.getPrice().longValue()))
                .amount(invoiceDetail.getAmount())
                .productName(invoiceDetail.getProductName())
                .build();

    }

}

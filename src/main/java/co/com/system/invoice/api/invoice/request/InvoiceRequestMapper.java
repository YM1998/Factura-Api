package co.com.system.invoice.api.invoice.request;

import co.com.system.invoice.model.Invoice;
import co.com.system.invoice.model.InvoiceDetail;
import co.com.system.invoice.model.Product;
import co.com.system.invoice.service.product.GetProductService;
import co.com.system.invoice.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class InvoiceRequestMapper {


   private final  GetProductService productService;

    public Invoice invoiceRequestToInvoice(InvoiceRequest invoiceRequest) {

        List<InvoiceDetail> invoiceDetailList = invoiceRequest.getInvoiceDetails()
                .stream().map(this::mapperInvoiceDetail).collect(Collectors.toList());

        return Invoice.builder()
                .paymentTypeId(invoiceRequest.getPaymentTypeId())
                .clientId(invoiceRequest.getClientId())
                .userId(invoiceRequest.getSellerId())
                .iva(invoiceDetailList.stream().mapToDouble(InvoiceDetail::getIva).sum())
                .subtotal(invoiceDetailList.stream().mapToDouble(InvoiceDetail::getSubtotal).sum())
                .total(invoiceDetailList.stream().mapToDouble(InvoiceDetail::getTotal).sum())
                .cost(invoiceDetailList.stream().mapToDouble(InvoiceDetail::getCost).sum())
                .createdAt(DateUtils.getColombianDate())
                .sellingPointId(invoiceRequest.getSellingPointId())
                .invoiceDetails(invoiceDetailList)
                .build();
    }


    private InvoiceDetail mapperInvoiceDetail(InvoiceDetailRequest invoiceDetailRequest) {
        try {
            Product product = productService.findByCode(invoiceDetailRequest.getProductCode());
            Double subtotal = invoiceDetailRequest.getPrice() * invoiceDetailRequest.getAmount();
            return InvoiceDetail.builder()
                    .productId(product.getIdProduct())
                    .amount(invoiceDetailRequest.getAmount())
                    .iva(invoiceDetailRequest.getIva())
                    .price(invoiceDetailRequest.getPrice())
                    .cost(product.getCost()*invoiceDetailRequest.getAmount())
                    .subtotal(subtotal)
                    .total(subtotal + (subtotal * (invoiceDetailRequest.getIva())))
                    .build();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }



}

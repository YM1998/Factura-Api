package co.com.system.invoice.api;

import co.com.system.invoice.api.invoice.request.InvoiceDetailRequest;
import co.com.system.invoice.api.invoice.request.InvoiceRequest;
import co.com.system.invoice.api.invoice.request.InvoiceRequestMapper;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.Invoice;
import co.com.system.invoice.model.Product;
import co.com.system.invoice.service.product.GetProductService;
import jdk.internal.dynalink.linker.LinkerServices;
import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRequestMapperTest {


    @InjectMocks private InvoiceRequestMapper invoiceRequestMapper;
    @Mock private GetProductService productService;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void invoiceRequestToInvoice()throws AppException {

        Mockito.when(productService.findByCode(Mockito.anyString())).thenReturn(Product.builder().cost(100D).build());
        List<InvoiceDetailRequest> invoiceDetailRequestList = new ArrayList<>();
        invoiceDetailRequestList.add(InvoiceDetailRequest.builder().price(100D).productCode("001").amount(2).build());
        invoiceDetailRequestList.add(InvoiceDetailRequest.builder().price(250D).productCode("002").amount(1).build());
        invoiceDetailRequestList.add(InvoiceDetailRequest.builder().price(300D).productCode("003").amount(3).build());


        Invoice invoice = invoiceRequestMapper.invoiceRequestToInvoice(InvoiceRequest
                .builder()
                .clientId(1L)
                .sellerId(1L)
                .paymentTypeId(1)
                .invoiceDetails(invoiceDetailRequestList).build(), 1L);


        Assertions.assertAll(
                () -> Assertions.assertEquals(1350D, invoice.getTotal()),
                () -> Assertions.assertEquals(1350D, invoice.getSubtotal()),
                () -> Assertions.assertEquals(0D, invoice.getIva()),
                () -> Assertions.assertEquals(invoiceDetailRequestList.size(), invoice.getInvoiceDetails().size()));



    }





}

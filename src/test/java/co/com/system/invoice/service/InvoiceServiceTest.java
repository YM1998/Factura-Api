package co.com.system.invoice.service;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.*;
import co.com.system.invoice.persistence.invoice.InvoiceDataProvider;
import co.com.system.invoice.service.client.GetClientService;
import co.com.system.invoice.service.invoice.InvoiceService;
import co.com.system.invoice.service.payment.type.PaymentTypeService;
import co.com.system.invoice.service.product.UpdateProductService;
import co.com.system.invoice.service.user.GetUserService;
import co.com.system.invoice.service.sellingpoint.GetSellingPointService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InvoiceServiceTest {

    @InjectMocks private InvoiceService invoiceService;
    @Mock private InvoiceDataProvider invoiceDataProvider;
    @Mock private GetClientService getClientService;
    @Mock private GetUserService getSellerService;
    @Mock private PaymentTypeService paymentTypeService;
    @Mock private GetSellingPointService getSellingPointService;


    @Mock private UpdateProductService updateProductService;

    private Invoice invoice;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        List<InvoiceDetail> invoiceDetails = new ArrayList<>();
        invoiceDetails.add(InvoiceDetail.builder().amount(2).productId(1L).build());
        invoiceDetails.add(InvoiceDetail.builder().amount(1).productId(2L).build());

        invoice = Invoice.builder().invoiceDetails(invoiceDetails).build();
    }



    @Test
    public void saveSellerNotExist (){
        mockSeller(Optional.empty(), 1L);
        invoice.setUserId(1L);
        AppException thrown = Assertions.assertThrows(AppException.class, () -> invoiceService.save(invoice));
        Assertions.assertEquals(CodeExceptions.SELLER_NOT_FOUND.getValue(), thrown.getCodError());
    }



    @Test
    public void saveClientNotExist (){
        mockSeller(Optional.of(User.builder().build()), 1L);
        mockClient(Optional.empty(), 2L);
        invoice.setUserId(1L);
        invoice.setClientId(2L);
        AppException thrown = Assertions.assertThrows(AppException.class, () -> invoiceService.save(invoice));
        Assertions.assertEquals(CodeExceptions.CLIENT_NOT_FOUND.getValue(), thrown.getCodError());
    }

    @Test
    public void savePaymentTypeNotExist (){
        mockSeller(Optional.of(User.builder().build()), 1L);
        mockClient(Optional.of(Client.builder().build()), 2L);
        mockPaymentType(Optional.empty(), 1);
        invoice.setUserId(1L);
        invoice.setClientId(2L);
        invoice.setPaymentTypeId(1);
        AppException thrown = Assertions.assertThrows(AppException.class, () -> invoiceService.save(invoice));
        Assertions.assertEquals(CodeExceptions.PAYMENT_TYPE_NOT_FOUND.getValue(), thrown.getCodError());
    }



    @Test
    public void saveSellerPointNotExist (){
        mockSeller(Optional.of(User.builder().build()), 1L);
        mockClient(Optional.of(Client.builder().build()), 2L);
        mockPaymentType(Optional.of(PaymentType.builder().build()), 1);
        mockSellingPoint(Optional.empty(), 1L);
        invoice.setUserId(1L);
        invoice.setClientId(2L);
        invoice.setPaymentTypeId(1);
        invoice.setSellingPointId(1L);
        AppException thrown = Assertions.assertThrows(AppException.class, () -> invoiceService.save(invoice));
        Assertions.assertEquals(CodeExceptions.SELLING_POINT_NOT_FOUND.getValue(), thrown.getCodError());
    }

    @Test
    public void save () throws  AppException{
        mockSeller(Optional.of(User.builder().build()), 1L);
        mockClient(Optional.of(Client.builder().build()), 2L);
        mockPaymentType(Optional.of(PaymentType.builder().build()), 1);
        mockSellingPoint(Optional.of(SellingPoint.builder().build()), 1L);
        invoice.setSellerId(1L);
        invoice.setClientId(2L);
        invoice.setPaymentTypeId(1);
        invoice.setSellingPointId(1L);
        invoiceService.save(invoice);
        Mockito.verify(invoiceDataProvider).save(Mockito.any());
        Mockito.verify(updateProductService, Mockito.times(2)).updateQuantityInventory(Mockito.anyLong(), Mockito.anyInt());
    }


    private void mockClient(Optional<Client> person, Long idClient) {
        Mockito.when(getClientService.findById(idClient)).thenReturn(person);
    }

    private void mockSeller(Optional<User> seller, Long idSeller) {
        Mockito.when(getSellerService.findById(idSeller)).thenReturn(seller);
    }

    private void mockPaymentType(Optional<PaymentType> paymentType, Integer id) {
        Mockito.when(paymentTypeService.findById(id)).thenReturn(paymentType);
    }

    private void mockSellingPoint(Optional<SellingPoint> sellingPoint, Long id) {
        Mockito.when(getSellingPointService.findById(id)).thenReturn(sellingPoint);
    }

}

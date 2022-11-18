package co.com.system.invoice.service;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.Invoice;
import co.com.system.invoice.model.Person;
import co.com.system.invoice.persistence.invoice.InvoiceDataProvider;
import co.com.system.invoice.service.invoice.InvoiceService;
import co.com.system.invoice.service.person.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class InvoiceServiceTest {

    @InjectMocks private InvoiceService invoiceService;
    @Mock private InvoiceDataProvider invoiceDataProvider;
    @Mock private PersonService personService;

    private Invoice invoice = Invoice.builder().build();


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }



    @Test
    public void saveSellerNotExist (){
        mockPerson(Optional.empty(), 1L);
        invoice.setSellerId(1L);
        AppException thrown = Assertions.assertThrows(AppException.class, () -> invoiceService.save(invoice));
        Assertions.assertEquals(CodeExceptions.SELLER_NOT_FOUND.getValue(), thrown.getCodError());
    }



    @Test
    public void saveClientNotExist (){
        mockPerson(Optional.of(Person.builder().build()), 1L);
        mockPerson(Optional.empty(), 2L);
        invoice.setSellerId(1L);
        invoice.setClientId(2L);
        AppException thrown = Assertions.assertThrows(AppException.class, () -> invoiceService.save(invoice));
        Assertions.assertEquals(CodeExceptions.CLIENT_NOT_FOUND.getValue(), thrown.getCodError());
    }


    @Test
    public void save () throws  AppException{
        mockPerson(Optional.of(Person.builder().build()), 1L);
        mockPerson(Optional.of(Person.builder().build()), 2L);
        invoice.setSellerId(1L);
        invoice.setClientId(2L);
        invoiceService.save(invoice);
        Mockito.verify(invoiceDataProvider).save(Mockito.any());
    }


    private void mockPerson(Optional<Person> person, Long idPerson) {
        Mockito.when(personService.findById(idPerson)).thenReturn(person);
    }

}

package co.com.system.invoice.service;

import co.com.system.invoice.persistence.attribute.AttributeDataProvider;
import co.com.system.invoice.service.attribute.AttributeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;


public class AttributeServiceTest {

    @InjectMocks private AttributeService attributeService;
    @Mock private AttributeDataProvider attributeDataProvider;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllTest() {
        Mockito.when(attributeDataProvider.findAll()).thenReturn(Collections.emptyList());
        Assertions.assertNotNull(attributeService.findAll());
    }


}

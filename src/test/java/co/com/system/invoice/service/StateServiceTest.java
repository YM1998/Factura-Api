package co.com.system.invoice.service;

import co.com.system.invoice.persistence.state.StateDataProvider;
import co.com.system.invoice.service.state.StateService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

public class StateServiceTest {

    @InjectMocks private StateService stateService;
    @Mock private StateDataProvider stateDataProvider;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllTest() {
        Mockito.when(stateDataProvider.findAll()).thenReturn(Collections.emptyList());
        Assertions.assertNotNull(stateService.findAll());
    }

}

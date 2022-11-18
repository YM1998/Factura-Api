package co.com.system.invoice.service.product;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.model.Attribute;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;
import java.util.List;

public class ProductUtilTest {



    private ProductUtil productUtil;

    @Before
    public void setup() {
        productUtil = new ProductUtil();
    }

    @Test
    public void saveErrorAttributesDuplicated() throws AppException {
        List<Attribute> attributeList = new ArrayList<>();
        attributeList.add(Attribute.builder().idAttribute(2L).build());
        attributeList.add(Attribute.builder().idAttribute(2L).build());
        AppException thrown = Assertions.assertThrows(AppException.class, () -> productUtil.validateAttributeNotDuplicates(attributeList));
        Assertions.assertEquals(CodeExceptions.PRODUCT_ATTRIBUTES_DUPLICATES.getValue(), thrown.getCodError());

    }
}

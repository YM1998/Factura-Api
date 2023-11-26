package co.com.system.invoice.service.category;

import co.com.system.invoice.constants.CodeExceptions;
import co.com.system.invoice.exception.AppException;
import co.com.system.invoice.persistence.category.CategoryDataProvider;
import co.com.system.invoice.service.product.GetProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteCategoryService {
    private final GetProductService getProductService;
    private final CategoryDataProvider categoryDataProvider;

    @Transactional
    public void delete(final Long idCategory) throws AppException {
        validateDelete(idCategory);
        categoryDataProvider.delete(idCategory);
    }

    private void validateDelete(final Long idCategory) throws AppException {
        Long countProducts = getProductService.countByIdCategory(idCategory);
        if(countProducts!=null && countProducts.compareTo(0L)>0)
            throw new AppException(CodeExceptions.CATEGORY_CANNOT_BE_DELETED);
    }

}

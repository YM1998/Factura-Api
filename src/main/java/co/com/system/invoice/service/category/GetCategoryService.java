package co.com.system.invoice.service.category;

import co.com.system.invoice.model.Category;
import co.com.system.invoice.persistence.category.CategoryDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetCategoryService {

    private final  CategoryDataProvider categoryDataProvider;

    @Transactional(readOnly = true)
    public List<Category> findAll(){
        return categoryDataProvider.findAll();
    }


}

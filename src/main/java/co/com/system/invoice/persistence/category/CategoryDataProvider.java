package co.com.system.invoice.persistence.category;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.com.system.invoice.model.Category;

@RequiredArgsConstructor
@Repository
public class CategoryDataProvider {


    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public void save(final Category category){
        categoryRepository.save(categoryMapper.toEntity(category));
    }

    public List<Category> findAll(){
        return categoryRepository.findAllOrderByName()
                                 .stream()
                                 .map(categoryMapper::toData)
                                 .collect(Collectors.toList());
    }

    public Category findById(long id) {
        Optional<CategoryEntity> categoryEntity = categoryRepository.findById(id);
        return categoryEntity.isPresent()? categoryMapper.toData(categoryEntity.get()) : null;
    }

    public void delete(final Long idCategory){
        categoryRepository.deleteById(idCategory);
    }


    public boolean existName(final String name) {
        List<CategoryEntity> categories = categoryRepository.findByName(name);
        return categories != null && !categories.isEmpty();
    }


    public boolean existNameForOtherRecords(final String name, final Long id){
        List<CategoryEntity> categories = categoryRepository.findByNameForOtherRecords(name, id);
        return categories != null && !categories.isEmpty();
    }


}

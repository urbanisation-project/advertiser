package advertiser.service.impl;

import advertiser.model.Category;
import advertiser.payload.CategoryPayload;
import advertiser.repository.CategoryRepository;
import advertiser.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryPayload save(CategoryPayload category) {
        return categoryRepository.save(category.toEntity()).toPayload();
    }

    @Override
    public CategoryPayload findById(Long categoryId) {
        return categoryRepository.findById(categoryId).get().toPayload();
    }

    @Override
    public List<CategoryPayload> findAll() {
        return categoryRepository.findAll().stream().map(Category::toPayload).collect(Collectors.toList());
    }

    @Override
    public CategoryPayload update(CategoryPayload category) {
        return categoryRepository.save(category.toEntity()).toPayload();
    }

    @Override
    public boolean deleteById(Long categoryId) {
        try{
            categoryRepository.deleteById(categoryId);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}

package advertiser.service;

import advertiser.payload.CategoryPayload;

import java.util.List;

public interface CategoryService {
    CategoryPayload save(CategoryPayload category);
    CategoryPayload findById(Long categoryId);
    List<CategoryPayload> findAll();
    CategoryPayload update(CategoryPayload category);
    boolean deleteById(Long categoryId);
}

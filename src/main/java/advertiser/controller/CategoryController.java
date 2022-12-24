package advertiser.controller;

import advertiser.payload.CategoryPayload;
import advertiser.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping("/save")
    public CategoryPayload save(@RequestBody CategoryPayload category){
        return categoryService.save(category);
    }
    @GetMapping("/{categoryId}")
    public CategoryPayload getById(@PathVariable Long categoryId){
        return categoryService.findById(categoryId);
    }

    @GetMapping("/")
    public List<CategoryPayload> getAll(){
        return categoryService.findAll();
    }
    @GetMapping("/{categoryId}/delete")
    public Boolean deleteById(@PathVariable Long categoryId){
        return categoryService.deleteById(categoryId);
    }
    @PutMapping("/update")
    public CategoryPayload update(@RequestBody CategoryPayload category){
        return categoryService.update(category);
    }
}

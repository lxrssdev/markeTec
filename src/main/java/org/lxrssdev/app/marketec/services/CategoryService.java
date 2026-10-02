package org.lxrssdev.app.marketec.services;

import lombok.AllArgsConstructor;
import org.lxrssdev.app.marketec.entities.Category;
import org.lxrssdev.app.marketec.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    //get all categories
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }
    //create category
    public void createCategory(String name){
        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);
    }
    //update category
    public void updateCategory(Long id, String name){
        Category categoryToUpdate = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category doesn't exists!"));
        categoryToUpdate.setName(name);
        categoryRepository.save(categoryToUpdate);
    }
    //delete category
    public void deleteCategory(Long id){
        Category categoryToDelete = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category doesn't exists!"));
        categoryRepository.delete(categoryToDelete);
    }

}

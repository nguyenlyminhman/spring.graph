package vn.study.graph.db;

import vn.study.graph.input.CategoryInput;
import vn.study.graph.models.Category;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class CategorySingleton {
    private static CategorySingleton categorySingleton = new CategorySingleton();
    private List<Category> categories = new CopyOnWriteArrayList<>();

    private CategorySingleton(){

    }
    public static CategorySingleton getInstance() {
        return categorySingleton;
    }

    public List<Category> getAllCategories(){
        return categories;
    }

    public Category create(CategoryInput input) {
        Long newCate = (long) (categories.size() + 1);
        Category category = new Category();

        category.setId(newCate);
        category.setName(input.getName());
        category.setDescription(input.getDescription());

        categories.add(category);
        return category;
    }

    public Category update(Long id, CategoryInput input){
        categories = categories.stream().map(cat -> {
            if(cat.getId().equals(id)){
                cat.setName(input.getName());
                cat.setDescription(input.getDescription());
                return cat;
            }
            return cat;
        }).collect(Collectors.toList());
        return getById(id);
    }

    public Category getById(Long id) {
        return categories.stream().filter(cat-> cat.getId().equals(id)).findFirst().get();
    }
    public Category delete(Long id){
         categories = categories.stream().filter(cat -> !cat.getId().equals(id)).collect(Collectors.toList());
        return getById(id);
    }
}

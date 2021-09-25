package vn.study.graph.services;

import org.springframework.stereotype.Service;
import vn.study.graph.contracts.mutations.CategoryMutationContract;
import vn.study.graph.contracts.queries.CategoryQueryContract;
import vn.study.graph.db.CategorySingleton;
import vn.study.graph.input.CategoryInput;
import vn.study.graph.models.Category;

import java.util.List;

@Service
public class CategoryService implements CategoryQueryContract, CategoryMutationContract {

    @Override
    public Category createCategory(CategoryInput input) {
        return CategorySingleton.getInstance().create(input);
    }

    @Override
    public Category updateCategory(Long id, CategoryInput input) {
        return CategorySingleton.getInstance().update(id, input);
    }

    @Override
    public Category deleteCategory(Long id) {
        return CategorySingleton.getInstance().delete(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return CategorySingleton.getInstance().getAllCategories();
    }

    @Override
    public Category getCategory(Long id) {
        return CategorySingleton.getInstance().getById(id);
    }
}

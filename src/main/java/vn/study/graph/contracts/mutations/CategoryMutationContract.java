package vn.study.graph.contracts.mutations;

import vn.study.graph.input.CategoryInput;
import vn.study.graph.entities.Category;

public interface CategoryMutationContract {
    Category createCategory(CategoryInput input);
    Category updateCategory(Long id,  CategoryInput input);
    Category deleteCategory(Long id);
}

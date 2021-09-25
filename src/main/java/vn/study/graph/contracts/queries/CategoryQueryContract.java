package vn.study.graph.contracts.queries;

import vn.study.graph.models.Category;

import java.util.List;

public interface CategoryQueryContract {
    List<Category> getAllCategories();
    Category getCategory(Long id);
}

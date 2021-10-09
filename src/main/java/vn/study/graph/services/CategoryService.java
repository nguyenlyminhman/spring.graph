package vn.study.graph.services;

import graphql.GraphQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.study.graph.contracts.mutations.CategoryMutationContract;
import vn.study.graph.contracts.queries.CategoryQueryContract;
import vn.study.graph.entities.Category;
import vn.study.graph.input.CategoryInput;
import vn.study.graph.repositories.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Primary
public class CategoryService implements CategoryQueryContract, CategoryMutationContract {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(CategoryInput input) {
        Optional<Category> check = categoryRepository.checkExistName(input.getName() );
        if(check.isPresent()){
            throw new GraphQLException(input.getName() + " is exist");
        }
        Category category = new Category();
        category.setName(input.getName());
        category.setDescription(input.getDescription());
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Category updateCategory(Long id, CategoryInput input) {
        Optional<Category> check = categoryRepository.checkExistName(id);
        if(!check.isPresent()){
            throw new GraphQLException(id + " is not exist");
        }
        String name = input.getName();
        String desc = input.getDescription();
        Category cate = categoryRepository.getOne(id);
        cate.setDescription(desc);
        cate.setName(name);
        categoryRepository.save(cate);
        return cate;
    }

    @Override
    public Category deleteCategory(Long id) {
        Optional<Category> check = categoryRepository.checkExistName(id);
        if(!check.isPresent()){
            throw new GraphQLException(id + " is not exist");
        }
        Category cate = categoryRepository.getOne(id);
        categoryRepository.delete(cate);
        return cate;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long id) {
        Optional <Category> check = categoryRepository.findById(id);
        if(!check.isPresent()){
            throw new GraphQLException(id + " is not exist");
        }
        return check.get();
    }
}

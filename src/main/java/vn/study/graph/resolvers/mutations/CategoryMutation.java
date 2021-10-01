package vn.study.graph.resolvers.mutations;

import graphql.GraphQLException;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import vn.study.graph.contracts.mutations.CategoryMutationContract;
import vn.study.graph.input.CategoryInput;
import vn.study.graph.entities.Category;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Component
@Validated
public class CategoryMutation implements GraphQLMutationResolver {

    @Autowired
    private CategoryMutationContract categoryMutationContract;

    @Autowired
    private Validator validator;

    Category createCategory(CategoryInput input){
        Set<ConstraintViolation<CategoryInput>> validate = validator.validate(input);
        int size = validate.size();
        if(size > 0){
            throw new GraphQLException(validate.iterator().next().getMessage());
        }
        return categoryMutationContract.createCategory(input);
    }

    Category updateCategory(Long id,  CategoryInput input){
            return categoryMutationContract.updateCategory(id, input);
    }

    Category deleteCategory(Long id){
        return categoryMutationContract.deleteCategory(id);
    }

}

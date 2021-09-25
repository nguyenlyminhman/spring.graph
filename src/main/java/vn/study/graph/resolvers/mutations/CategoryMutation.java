package vn.study.graph.resolvers.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
//import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.study.graph.contracts.mutations.CategoryMutationContract;
import vn.study.graph.input.CategoryInput;
import vn.study.graph.models.Category;

import java.lang.annotation.Annotation;

@Component
public class CategoryMutation implements GraphQLMutationResolver {

    @Autowired
    private CategoryMutationContract categoryMutationContract;

    Category createCategory(CategoryInput input){
        return categoryMutationContract.createCategory(input);
    }
    Category updateCategory(Long id,  CategoryInput input){
        return categoryMutationContract.updateCategory(id, input);
    }
    Category deleteCategory(Long id){
        return categoryMutationContract.deleteCategory(id);
    }

}

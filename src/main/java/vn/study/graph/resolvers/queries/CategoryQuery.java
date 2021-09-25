package vn.study.graph.resolvers.queries;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
//import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.study.graph.contracts.queries.CategoryQueryContract;
import vn.study.graph.models.Category;

import java.lang.annotation.Annotation;
import java.util.List;

@Component
public class CategoryQuery implements GraphQLQueryResolver {

    @Autowired
    private CategoryQueryContract categoryQueryContract;

    List<Category> getAllCategories(){
        return categoryQueryContract.getAllCategories();
    }

    Category getCategory(Long id){
        return categoryQueryContract.getCategory(id);
    }

}

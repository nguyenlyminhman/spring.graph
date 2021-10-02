package vn.study.graph.resolvers.queries;


import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.study.graph.contracts.queries.CategoryQueryContract;
import vn.study.graph.contracts.queries.TodoQueryContract;
import vn.study.graph.entities.Category;
import vn.study.graph.entities.Todo;

import java.util.List;

@Component
public class TodoQuery implements GraphQLQueryResolver {

    @Autowired
    private TodoQueryContract todoQueryContract;

    List<Todo> getAllToDo(){
       return  todoQueryContract.getAllToDo();
    }
    Todo getOneToDo(Long id){
        return todoQueryContract.getOneToDo(id);
    }
    List<Todo> getToDoByCategoryId(Long id){
        return todoQueryContract.getToDoByCategoryId(id);
    }
    List<Todo> getAllCompleteToDo(){
        return todoQueryContract.getAllCompleteToDo();
    }
    List<Todo> getOverDueToDos(){
        return todoQueryContract.getOverDueToDos();
    }

}

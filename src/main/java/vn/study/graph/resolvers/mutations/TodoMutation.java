package vn.study.graph.resolvers.mutations;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import vn.study.graph.contracts.mutations.CategoryMutationContract;
import vn.study.graph.contracts.mutations.TodoMutationContract;
import vn.study.graph.entities.Todo;
import vn.study.graph.input.ToDoInput;


@Component
public class TodoMutation implements GraphQLMutationResolver {

    @Autowired
    private TodoMutationContract todoMutationContract;

    Todo createToDo(ToDoInput input){
        return todoMutationContract.createToDo(input);
    }

    Todo updateToDo(Long id, ToDoInput input){
        return todoMutationContract.updateToDo(id, input);
    }

    Todo deleteToDo(Long id){
        return todoMutationContract.deleteToDo(id);
    }

    Todo completeToDo(Long id, String completedDate){
        return todoMutationContract.completeToDo(id, completedDate);
    }

}

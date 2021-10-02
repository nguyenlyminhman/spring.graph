package vn.study.graph.resolvers.mutations;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import vn.study.graph.contracts.mutations.TodoMutationContract;
import vn.study.graph.contracts.mutations.UsersMutationContract;
import vn.study.graph.entities.Todo;
import vn.study.graph.entities.Users;
import vn.study.graph.input.ToDoInput;
import vn.study.graph.input.UserInput;


@Component
public class UsersMutation implements GraphQLMutationResolver {

    @Autowired
    private UsersMutationContract usersMutationContract;

    Users createUser(UserInput input){
        return usersMutationContract.createUser(input);
    }

    Users updateUser(Long id,  UserInput input){
        return usersMutationContract.updateUser(id, input);
    }

    Users deleteUser(Long id){
        return usersMutationContract.deleteUser(id);
    }
}

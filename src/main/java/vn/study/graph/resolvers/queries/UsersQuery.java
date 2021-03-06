package vn.study.graph.resolvers.queries;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.study.graph.contracts.queries.UsersQueryContract;
import vn.study.graph.entities.Users;

import java.util.List;

@Component
public class UsersQuery implements GraphQLQueryResolver {

    @Autowired
    private UsersQueryContract usersQueryContract;

    List<Users> getActiveUsersList(){
        return usersQueryContract.getActiveUsersList();
    }

    List<Users> getDeActiveUsersList(){
        return usersQueryContract.getDeActiveUsersList();
    }

    Users getUserByEmail(String email){
        return usersQueryContract.getUserByEmail(email);
    }
}

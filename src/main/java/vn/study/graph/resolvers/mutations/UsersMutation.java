package vn.study.graph.resolvers.mutations;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.study.graph.contracts.mutations.UsersMutationContract;
import vn.study.graph.entities.Users;
import vn.study.graph.input.UserChangePasswordInput;
import vn.study.graph.input.UserInfoInput;


@Component
public class UsersMutation implements GraphQLMutationResolver {

    @Autowired
    private UsersMutationContract usersMutationContract;

    Users createUser(UserInfoInput input){
        return usersMutationContract.createUser(input);
    }
    Users updateUserInfo(String email,  UserInfoInput input){
        return usersMutationContract.updateUserInfo(email, input);
    }
    Users activeUser(String email){
        return usersMutationContract.activeUser(email);
    }
    Users deActiveUser(String email){
        return usersMutationContract.deActiveUser(email);
    }
    Users updateUserPassword(UserChangePasswordInput input){
        return usersMutationContract.updateUserPassword(input);
    }
}

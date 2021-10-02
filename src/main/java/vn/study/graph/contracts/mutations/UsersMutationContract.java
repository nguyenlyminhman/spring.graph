package vn.study.graph.contracts.mutations;

import vn.study.graph.entities.Users;
import vn.study.graph.input.UserInput;

public interface UsersMutationContract {
    Users createUser(UserInput input);
    Users updateUser(Long id,  UserInput input);
    Users deleteUser(Long id);
}

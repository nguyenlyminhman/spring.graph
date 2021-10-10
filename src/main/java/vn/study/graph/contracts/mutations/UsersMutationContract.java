package vn.study.graph.contracts.mutations;

import vn.study.graph.auth.domains.AuthResponse;
import vn.study.graph.auth.input.AuthInput;
import vn.study.graph.entities.Users;
import vn.study.graph.input.UserChangePasswordInput;
import vn.study.graph.input.UserInfoInput;

public interface UsersMutationContract {
    Users createUser(UserInfoInput input);
    Users updateUserInfo(String email,  UserInfoInput input);
    Users activeUser(String email);
    Users deActiveUser(String email);
    Users updateUserPassword(UserChangePasswordInput input);
    AuthResponse authUser(AuthInput input);
}

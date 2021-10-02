package vn.study.graph.contracts.queries;

import vn.study.graph.entities.Users;

import java.util.List;

public interface UsersQueryContract {
    List<Users> getAllUser();
    Users getOneUser(Long id);
}

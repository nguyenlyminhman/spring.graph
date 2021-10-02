package vn.study.graph.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.study.graph.contracts.mutations.UsersMutationContract;
import vn.study.graph.contracts.queries.UsersQueryContract;
import vn.study.graph.entities.Users;
import vn.study.graph.input.UserInput;

import java.util.List;

@Service
@Transactional
public class UsersService implements UsersQueryContract, UsersMutationContract {
    @Override
    public Users createUser(UserInput input) {
        return null;
    }

    @Override
    public Users updateUser(Long id, UserInput input) {
        return null;
    }

    @Override
    public Users deleteUser(Long id) {
        return null;
    }

    @Override
    public List<Users> getAllUser() {
        return null;
    }

    @Override
    public Users getOneUser(Long id) {
        return null;
    }
}

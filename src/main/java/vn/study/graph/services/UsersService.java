package vn.study.graph.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.study.graph.contracts.mutations.UsersMutationContract;
import vn.study.graph.contracts.queries.UsersQueryContract;
import vn.study.graph.entities.Users;
import vn.study.graph.exception_handlers.EntityException;
import vn.study.graph.input.UserChangePasswordInput;
import vn.study.graph.input.UserInfoInput;
import vn.study.graph.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsersService implements UsersQueryContract, UsersMutationContract {

    @Autowired
    private UsersRepository repository;

    @Override
    public Users createUser(UserInfoInput input) {

        Optional<Users> existUser = repository.getUserByEmail(input.getEmail());
        if(existUser.isPresent()){
            throw new EntityException("Email is not exist", input.getEmail());
        }

        Users users = new Users();
        users.setEmail(input.getEmail());
        users.setFullName(input.getFullName());
        users.setUserName(input.getUserName());
        users.setPassword(input.getPassword());
        users.setActive(true);
        repository.save(users);
        return users;
    }


    @Override
    public Users updateUserInfo(String email, UserInfoInput input) {
        Users user = this.getUserByEmail(email);
        user.setFullName(input.getFullName());
        user.setUserName(input.getUserName());
        repository.save(user);
        return user;
    }

    @Override
    public Users activeUser(String email) {
        Users user = this.getUserByEmail(email);
        int rs = repository.activeUser(email);
        if(rs == 0)
            throw new EntityException("Not updated", email);
        return user;
    }

    @Override
    public Users deActiveUser(String email) {
        Users user = this.getUserByEmail(email);
        int rs = repository.deActiveUser(email);
        if(rs == 0)
            throw new EntityException("Not updated", email);
        return user;
    }

    @Override
    public Users updateUserPassword(UserChangePasswordInput input) {
        return null;
    }

    @Override
    public List<Users> getActiveUsersList() {
        return repository.getActiveUsersList();
    }

    @Override
    public List<Users> getDeActiveUsersList() {
        return repository.getDeActiveUsersList();
    }

    @Override
    public Users getUserByEmail(String email) {
        Optional<Users> existUser = repository.getUserByEmail(email);
        if(!existUser.isPresent()){
            throw new EntityException("Email is not exist", email);
        }
        return existUser.get();
    }
}

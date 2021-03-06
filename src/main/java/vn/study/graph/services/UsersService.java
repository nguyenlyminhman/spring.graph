package vn.study.graph.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.study.graph.auth.domains.AuthResponse;
import vn.study.graph.auth.input.AuthInput;
import vn.study.graph.auth.services.AuthService;
import vn.study.graph.auth.utils.JwtUser;
import vn.study.graph.auth.utils.JwtUtils;
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

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtils jwtUtils;

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
        Users user = this.getUserByEmail(input.getEmail());
        String currentPass = user.getPassword();
        String inputPass = input.getOldPassword();
        String newPass = input.getNewPassword();
        if( !currentPass.equals(inputPass)){
            throw new EntityException("Not updated", "oldPassword");
        }
        user.setPassword(newPass);
        repository.save(user);
        return user;
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

    @Override
    public AuthResponse authUser(AuthInput input) {
        boolean auth = authService.AuthAttempt(input.getEmail(), input.getPassword());
        if(!auth){
            throw new EntityException("auth error", input.getEmail());
        }

        JwtUser jwtUser = new JwtUser();
        jwtUser.setEmail(input.getEmail());

        String token = jwtUtils.generate(jwtUser);
        return new AuthResponse(token);
    }

}

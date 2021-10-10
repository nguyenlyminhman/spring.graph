package vn.study.graph.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.study.graph.entities.Users;
import vn.study.graph.repositories.UsersRepository;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    UsersRepository usersRepository;

    public boolean AuthAttempt(String email, String password){

        Optional <Users> users = usersRepository.getActiveUserByMail(email);

        if(!users.isPresent())
            return false;
        Users user = users.get();

        if(!password.equals(user.getPassword())){
            return false;
        }
        return true;
    }
}

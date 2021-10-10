package vn.study.graph.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import vn.study.graph.entities.Users;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {


    @Query(value = "Select * from Users u where u.email=?1", nativeQuery = true)
    Optional<Users> getUserByEmail(String email);

    @Query(value = "Select * from Users u where u.active=true", nativeQuery = true)
    List<Users> getActiveUsersList();

    @Query(value = "Select * from Users u where u.active=false", nativeQuery = true)
    List<Users> getDeActiveUsersList();

    @Modifying
    @Query(value = "Update users  set active=true where email=?1", nativeQuery = true)
    int activeUser(String email);

    @Modifying
    @Query(value = "Update users set active=false where email=?1", nativeQuery = true)
    int deActiveUser(String email);

    @Query(value = "Select * from Users u where u.active=true and u.email=?1", nativeQuery = true)
    Optional<Users> getActiveUserByMail(String email);
}

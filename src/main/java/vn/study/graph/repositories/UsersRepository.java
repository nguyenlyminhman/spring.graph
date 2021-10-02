package vn.study.graph.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.study.graph.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
}

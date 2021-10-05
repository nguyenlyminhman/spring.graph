package vn.study.graph.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.study.graph.entities.Category;
import vn.study.graph.entities.Todo;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository <Todo, Long>{

    @Query(value = "Select t from todo_list t where t.active=true and t.title=?1 and category_id=?2", nativeQuery = true)
    Optional<Todo> checkExitsTodo(String title, Category category);

    @Query(value = "Update todo_list t set t.active=false where t.id=?1", nativeQuery = true)
    Optional<Todo> deleteTodo(Long id);

    @Query(value = "Select t from todo_list t where t.active=true", nativeQuery = true)
    List<Todo> getAllTodo();

}

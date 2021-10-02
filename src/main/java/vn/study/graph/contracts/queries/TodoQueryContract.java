package vn.study.graph.contracts.queries;

import vn.study.graph.entities.Category;
import vn.study.graph.entities.Todo;

import java.util.List;

public interface TodoQueryContract {
    List<Todo> getAllToDo();
    Todo getOneToDo(Long id);
    List<Todo> getToDoByCategoryId(Long id);
    List<Todo> getAllCompleteToDo();
    List<Todo> getOverDueToDos();
}

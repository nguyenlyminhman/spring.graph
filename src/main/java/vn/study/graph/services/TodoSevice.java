package vn.study.graph.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.study.graph.contracts.mutations.TodoMutationContract;
import vn.study.graph.contracts.queries.TodoQueryContract;
import vn.study.graph.entities.Todo;
import vn.study.graph.input.ToDoInput;

import java.util.List;

@Service
@Transactional
public class TodoSevice implements TodoMutationContract, TodoQueryContract {
    @Override
    public Todo createToDo(ToDoInput input) {
        return null;
    }

    @Override
    public Todo updateToDo(Long id, ToDoInput input) {
        return null;
    }

    @Override
    public Todo deleteToDo(Long id) {
        return null;
    }

    @Override
    public Todo completeToDo(Long id, String completedDate) {
        return null;
    }

    @Override
    public List<Todo> getAllToDo() {
        return null;
    }

    @Override
    public Todo getOneToDo(Long id) {
        return null;
    }

    @Override
    public List<Todo> getToDoByCategoryId(Long id) {
        return null;
    }

    @Override
    public List<Todo> getAllCompleteToDo() {
        return null;
    }

    @Override
    public List<Todo> getOverDueToDos() {
        return null;
    }
}

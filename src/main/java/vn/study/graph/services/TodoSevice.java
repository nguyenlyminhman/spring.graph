package vn.study.graph.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.study.graph.contracts.mutations.TodoMutationContract;
import vn.study.graph.contracts.queries.TodoQueryContract;
import vn.study.graph.entities.Category;
import vn.study.graph.entities.Todo;
import vn.study.graph.entities.Users;
import vn.study.graph.enums.ToDoStatus;
import vn.study.graph.exception_handlers.EntityException;
import vn.study.graph.input.ToDoInput;
import vn.study.graph.repositories.CategoryRepository;
import vn.study.graph.repositories.TodoRepository;
import vn.study.graph.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TodoSevice implements TodoMutationContract, TodoQueryContract {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UsersRepository userRepository;

    @Override
    public Todo createToDo(ToDoInput input) {
        Long categoryId = input.getCategoryId();
        Long userId = input.getUserId();

        String title = input.getTitle();
        Category category = categoryRepository.getOne(categoryId);
        Users user = userRepository.getOne(userId);



        Optional<Todo> todoCheck = todoRepository.checkExitsTodo(title, category);

        if(todoCheck.isPresent()){
            throw new EntityException("Todo exists", input);
        }
        Todo todo = new Todo();
        todo.setTitle(title);

        todo.setDescription(input.getDescription());
        todo.setStatus(ToDoStatus.CREATED);
        todo.setStartDate(input.getStartDate());
        todo.setEndDate(input.getEndDate());
        todo.setCompleted(true);
        todo.setCategory(category);
        todo.setUsers(user);
        todo.setCompletedDate("2020-10-12");
        todoRepository.save(todo);
        return todo;
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
        Optional<Todo> todo = todoRepository.findById(id);

        return todo.get();
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

package vn.study.graph.contracts.mutations;

import vn.study.graph.entities.Category;
import vn.study.graph.entities.Todo;
import vn.study.graph.input.CategoryInput;
import vn.study.graph.input.ToDoInput;

public interface TodoMutationContract {
    Todo createToDo(ToDoInput input);
    Todo updateToDo(Long id, ToDoInput input);
    Todo deleteToDo(Long id);
    Todo completeToDo(Long id, String completedDate);
}

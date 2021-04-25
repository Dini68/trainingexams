package exam03retake02;

import java.util.ArrayList;
import java.util.List;

public class TodoList {

    private List<Todo> todos = new ArrayList<>();

    public List<Todo> getTodos() {
        return todos;
    }


    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public int getNumberOfItemsLeft() {
        int count = 0;
        for (Todo t: todos) {
            if (t.getState() == State.NON_COMPLETED) {
                count ++;
            }
        }
        return count;
    }

    public List<String> getMostImportantTodosText() {
        List<String> result = new ArrayList<>();
        int min = 6;
        for (Todo t: todos) {
            if (t.getPriority() < min) {
                min = t.getPriority();
            }
        }
        for (Todo t: todos) {
            if (t.getPriority() == min) {
                result.add(t.getText());
            }
        }
        return result;
    }

    public void deleteCompleted() {
        List<Todo> ready = new ArrayList<>();
        for (Todo t: todos) {
            if (t.getState() == State.COMPLETED) {
                ready.add(t);
            }
        }
        todos.removeAll(ready);
    }
}
